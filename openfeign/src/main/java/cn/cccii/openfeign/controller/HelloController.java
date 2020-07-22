package cn.cccii.openfeign.controller;

import javax.annotation.Resource;
import java.net.URLEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cccii.commons.bean.User;
import cn.cccii.openfeign.service.HelloService;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月02日
 * description：添加描述
 */
@RestController
public class HelloController
{
    @Resource
    HelloService helloService;

    @GetMapping
    public String hello() {
        String hello = helloService.hello();

        String name = helloService.name("张三");

        helloService.delById(12);

        User user = new User();
        user.setUsername("admin");
        User result = helloService.user(user);
        System.out.println(result);

        helloService.header(URLEncoder.encode("请求头内容测试"));

        return hello + name;
    }
}
