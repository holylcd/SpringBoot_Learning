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
@NoArgsConstructor
@Setter(lombok.AccessLevel.PACKAGE)
@Getter
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4764276147992596434L;

    static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    static String DEFAULT_MESSAGE = "系统异常";

    private HttpStatus httpStatus;

    public BaseException(@NotNull HttpStatus httpStatus, @NotBlank String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BaseException(@NotNull HttpStatus httpStatus, @NotBlank String message,
                         @NotNull Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public BaseException(@NotNull HttpStatus httpStatus, @NotBlank String message,
                         @NotNull Throwable cause, boolean enableSuppression,
                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }
}
