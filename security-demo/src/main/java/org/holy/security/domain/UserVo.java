package org.holy.security.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author holyl
 * @version 1.0.0
 * @date 2019/9/5 11:03
 */
@Data
@Accessors(chain = true)
public class UserVo implements Serializable {
    private Long id;
    private String name;
    private String password;
    private Boolean state;
}
