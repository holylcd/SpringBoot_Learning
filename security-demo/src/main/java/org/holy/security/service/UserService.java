package org.holy.security.service;

import org.holy.security.domain.UserVo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author holyl
 * @version 1.0.0
 * @date 2019/9/6 0:04
 */
@Service
public class UserService {

    public UserVo selectById(Long id) {
        UserVo userVo = new UserVo()
                .setId(1L)
                .setName("test")
                .setPassword("123456");
        return userVo;
    }

    public UserVo selectById2(Long id) {
        UserVo userVo = new UserVo()
                .setId(1L)
                .setName("test")
                .setPassword("123456");
        return userVo;
    }
}
