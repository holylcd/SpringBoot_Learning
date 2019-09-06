package org.holy.security.controller;

import org.holy.security.component.security.UserPrincipal;
import org.holy.security.component.token.JwtPrincipal;
import org.holy.security.component.token.JwtProvider;
import org.holy.security.domain.TokenVo;
import org.holy.security.domain.UserVo;
import org.holy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author holy
 * @version 1.0.0
 * @date 2019/9/5 11:03
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<TokenVo> login() {
        JwtPrincipal jwtPrincipal = new JwtPrincipal();
        jwtPrincipal.setUserId(1L);
        TokenVo tokenVo = jwtProvider.createJwt(jwtPrincipal);

        return new ResponseEntity<>(tokenVo, HttpStatus.OK);
    }

    /**
     * 获得个人信息
     * @param id
     * @return
     */

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<UserVo> selectOne(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Long id) {
        UserVo userVo = userService.selectById2(id);
        return new ResponseEntity<>(userVo, HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("code", "200");
        body.put("mgs", "OK");
        UserVo userVo = new UserVo();
        userVo.setId(1L);
        userVo.setName("test");
        userVo.setState(true);
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(userVo);
        }
        body.put("list", list);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
