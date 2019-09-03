package org.holy.tkmapper.common.http.rest.response.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 业务异常时的响应体
 * @author holy
 * @
 * @email holylcd@foxmail.com
 * @date 2019/4/12
 * @version 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ErrorResponseBody implements Serializable {

	private static final long serialVersionUID = -3510814042352393019L;

	private Integer code;

	private String msg;

	public static ErrorResponseBody err(HttpStatus httpStatus) {
		return new ErrorResponseBody(httpStatus.value(), httpStatus.getReasonPhrase());
	}

	public static ErrorResponseBody err(HttpStatus httpStatus, String msg) {
		return new ErrorResponseBody(httpStatus.value(), msg);
	}

}