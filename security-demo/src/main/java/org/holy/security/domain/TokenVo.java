package org.holy.security.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author holy
 * @version 1.0.0
 * @date 2019/9/5 11:03
 */
@Data
@Accessors(chain = true)
public class TokenVo implements Serializable {
    private String token;
    private Date expireDate;
    private String refreshToken;
}
