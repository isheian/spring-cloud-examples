package cn.cccii.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import cn.cccii.commons.bean.User;
import cn.cccii.openfeign.fallback.HelloServiceFallBack;
import cn.cccii.openfeign.fallback.HelloServiceFallBackFactory;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月02日
 * description：添加描述
 */
//@FeignClient(value = "provider", fallback = HelloServiceFallBack.class)
@FeignClient(value = "provider", fallbackFactory = HelloServiceFallBackFactory.class)
public interface HelloService
{
    @GetMapping("hello")
    String hello();

    @GetMapping("name")
    String name(@RequestParam("name") String name);

    @PostMapping("jsonUser")
    User user(@RequestBody User user);

    @GetMapping("header")
    void header(@RequestHeader String name);

    @DeleteMapping("del/{id}")
    void delById(@PathVariable("id") Integer id);
}
