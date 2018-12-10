package org.restfulapi.controller;

import org.restfulapi.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户
 * <p>
 *
 * @author holy
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private ConcurrentHashMap<Integer, User> map0 = new ConcurrentHashMap<>();
//    private Map map1 = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, Object> add(@ModelAttribute User user) {
        int id = map0.size()+1;
        map0.put(id, user);

        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 0);
        map.put("id", id);
        return map;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable int id) {
        int code = 0;
        Object remove = map0.remove(id);
        if(null == remove){
            code = 100;
        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("code", code);
        map.put("msg", 0==code?"success":"该用户不存在");
        return map;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Map<String, Object> update(@PathVariable int id, @ModelAttribute User user) {
        User u = map0.get(id);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());

        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map<String, Object> find(@PathVariable int id) {
        int code = 0;

        User user = map0.get(id);

        if(null == user){
            code = 101;
        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("code", code);
        map.put("msg", 0 == code?"success":"该用户不存在");
        if (0==code){
            map.put("data", user);
        }
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> find() {

        Map<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", map0);
        return map;
    }

}
