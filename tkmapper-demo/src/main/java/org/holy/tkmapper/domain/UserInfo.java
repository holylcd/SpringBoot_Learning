package org.holy.tkmapper.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description //TODO
 * @Author holyl
 * @Date 2019/9/2 15:33
 * @Version 1.0.0
 */
@Data
@Accessors(chain = true)
//@NameStyle(Style.camelhump)
//@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    private Long id;
    private String account;
    private String realname;
    private String password;
    private String status;
    private Boolean disabled;
}
