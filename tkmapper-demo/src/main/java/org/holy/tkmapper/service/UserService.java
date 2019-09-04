package org.holy.tkmapper.service;

import org.holy.tkmapper.domain.UserInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface UserService {

    List<UserInfo> findAll();

    List<UserInfo> findAll1(Example example);

}
