package cn.cccii.provider.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import cn.cccii.commons.bean.User;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月01日
 * description：添加描述
 */
@RestController
public class HelloController
{
    @Value("${server.port}")
    private int port;

    @GetMapping("hello")
    public String hello()
    {
        return "hello！provider " + port;
    }

    @GetMapping("name")
    public String name(String name)
    {
        return "hello！" + name;
    }

    @PostMapping("user")
    public User name(User user)
    {
        return user;
    }

    @PostMapping("jsonUser")
    public User jsonUser(@RequestBody User user)
    {
        return user;
    }

    @GetMapping("header")
    public void header(@RequestHeader String name)
    {
        System.out.println(URLDecoder.decode(name));
    }

    @DeleteMapping("del/{id}")
    public void delById(@PathVariable Integer id)
    {
        System.out.println("删除：" + id);
    }
}
