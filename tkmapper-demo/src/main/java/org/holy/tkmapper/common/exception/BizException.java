package org.holy.tkmapper.common.exception;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 统一业务异常
 * @author holy
 * @version 1.0.0
 * @email holylcd@foxmail.com
 * @date 2019/4/12
 */
public class BizException extends BaseException {

    public BizException() {
        this(DEFAULT_HTTP_STATUS, DEFAULT_MESSAGE);
    }

    public BizException(@NotNull HttpStatus httpStatus) {
        this(httpStatus, DEFAULT_MESSAGE);
    }

    public BizException(@NotBlank String message) {
        this(DEFAULT_HTTP_STATUS, message);
    }

    public BizException(@NotNull HttpStatus httpStatus, @NotBlank String message) {
        super(httpStatus, message);
    }

    public BizException(@NotNull HttpStatus httpStatus, @NotBlank String message,
                        @NotNull Throwable cause) {
        super(httpStatus, message, cause);
    }

    public BizException(@NotNull HttpStatus httpStatus, @NotBlank String message,
                        @NotNull Throwable cause, boolean enableSuppression,
                        boolean writableStackTrace) {
        super(httpStatus, message, cause, enableSuppression, writableStackTrace);
    }

}
