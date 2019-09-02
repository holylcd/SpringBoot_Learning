package org.holy.tkmapper.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description //TODO
 * @Author holyl
 * @Date 2019/9/2 15:33
 * @Version 1.0.0
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private Long id;
    private String accout;
    private String realname;
    private String password;
    private String status;
    private Boolean disabled;
}
