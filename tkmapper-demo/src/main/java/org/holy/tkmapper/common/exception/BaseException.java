package org.holy.tkmapper.common.exception;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 基础异常
 * @author holy
 * @version 1.0.0
 * @email holylcd@foxmail.com
 * @date 2019/4/12
 */
@Getter
abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4764276147992596434L;

    static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    private HttpStatus httpStatus;

    public BaseException(@NotNull HttpStatus httpStatus) {
        super(httpStatus.getReasonPhrase());
        this.httpStatus = httpStatus;
    }

    public BaseException(@NotNull HttpStatus httpStatus, @NotNull Throwable cause) {
        super(httpStatus.getReasonPhrase(), cause);
        this.httpStatus = httpStatus;
    }

    public BaseException(@NotNull HttpStatus httpStatus, @NotNull Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace) {
        super(httpStatus.getReasonPhrase(), cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }
}
