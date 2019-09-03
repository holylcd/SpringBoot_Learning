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
        this(DEFAULT_HTTP_STATUS);
    }

    public BizException(@NotNull HttpStatus httpStatus) {
        super(httpStatus);
    }

    public BizException(@NotNull HttpStatus httpStatus, @NotNull Throwable cause) {
        super(httpStatus, cause);
    }

    public BizException(@NotNull HttpStatus httpStatus, @NotNull Throwable cause,
                        boolean enableSuppression, boolean writableStackTrace) {
        super(httpStatus, cause, enableSuppression, writableStackTrace);
    }

}
