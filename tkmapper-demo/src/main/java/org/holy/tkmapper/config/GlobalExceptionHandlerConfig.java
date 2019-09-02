package org.holy.tkmapper.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.holy.tkmapper.common.exception.BizException;
import org.holy.tkmapper.common.http.rest.body.ErrorResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理
 * @author holy
 * @email holylcd@foxmail.com
 * @date 2019/4/15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerConfig {

	/**
	 * 业务异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	public ResponseEntity bizExceptionHandler(BizException e) {
		HttpStatus httpStatus = e.getHttpStatus();
		ErrorResponseBody body = ErrorResponseBody.err(httpStatus);
		return ResponseEntity
				.status(httpStatus)
				.body(body);
	}



	/**
	 * VO 验证异常全局处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
	public ResponseEntity voValidateErrorHandler(Exception e) {
		BindingResult bindingResult;
		if (e instanceof BindException) {
			bindingResult = ((BindException) e).getBindingResult();
		}else {
			bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
		}

		// 状态码
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;

		// 异常消息
		String message;
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			message = allErrors.get(0).getDefaultMessage();
		} else {
			message = e.getMessage();
			if(StringUtils.isBlank(message)) {
				message = badRequest.getReasonPhrase();
			}
		}

		// 响应
		ErrorResponseBody body = ErrorResponseBody.err(badRequest, message);
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(body);
	}
	/**
	 * VO 验证异常全局处理
	 * @param e
	 * @return
	 */
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity voValidateErrorHandler(MethodArgumentNotValidException e) {
		return voValidateErrorHandler(e, e.getBindingResult());
	}*/

	/**
	 * VO 验证异常全局处理
	 * @param e
	 * @param bindingResult
	 * @return
	 */
	/*private ResponseEntity voValidateErrorHandler(Exception e, BindingResult bindingResult){
		// 状态码
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;

		// 异常消息
		String message;
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			message = allErrors.get(0).getDefaultMessage();
		} else {
			message = e.getMessage();
			if(StringUtils.isBlank(message)) {
				message = badRequest.getReasonPhrase();
			}
		}

		// 响应
		ErrorResponseBody body = ErrorResponseBody.err(badRequest, message);
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(body);
	}*/



	/**
	 * 全局异常处理
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity exceptionHandler(Throwable e) {
		// 状态码
		HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;

		// 异常消息
		String message = e.getMessage();
		if(StringUtils.isBlank(message)){
			message = badRequest.getReasonPhrase();
		}

		ErrorResponseBody body = ErrorResponseBody.err(badRequest, message);
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(body);
	}

}
