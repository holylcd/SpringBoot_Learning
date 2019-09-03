package org.holy.tkmapper.controller.v1;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.holy.tkmapper.common.http.rest.response.body.ResponseBodyPage;
import org.holy.tkmapper.domain.UserInfo;
import org.holy.tkmapper.mapper.UserMapper;
import org.holy.tkmapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

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
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseBodyPage<UserInfo> all(
            @RequestParam(value = "page") Integer pageNum,
            @RequestParam(value = "pre_page") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> userInfos = userService.findAll();

        return ResponseBodyPage
                .ok(userInfos, pageSize);
    }

  /*  @RequestMapping(value = "ex", method = RequestMethod.GET)
    public ResponseBodyPage<UserInfo> get() {
        int pageNum = 2, pageSize = 8;
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(UserInfo.class);
        example.setOrderByClause("realname");
        List<UserInfo> userInfos = userMapper.selectByExample(example);

        return ResponseBodyPage
                .ok(userInfos, pageSize);
    }*/

}
