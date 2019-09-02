package org.holy.tkmapper.controller.v1;

import com.github.pagehelper.PageHelper;
import org.holy.tkmapper.common.http.rest.body.ResponseBodyData;
import org.holy.tkmapper.domain.UserInfo;
import org.holy.tkmapper.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description //TODO
 * @Author holyl
 * @Date 2019/9/2 15:46
 * @Version 1.0.0
 */
@RestController
@RequestMapping(
        value = "user",
        produces = "application/vnd.tk.mapper.app-v1.0.0+json"
)
public class UserController {

    @Autowired
    private UserMapper<UserInfo> userMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseBodyData<List<UserInfo>> get() {
        PageHelper.startPage(1, 10);
        List<UserInfo> userInfos = userMapper.selectAll();

        return ResponseBodyData
                .ok(userInfos);
    }

}
