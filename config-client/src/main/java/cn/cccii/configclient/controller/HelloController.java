package cn.cccii.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月03日
 * description：添加描述
 */
@RestController
public class HelloController
{
    @Value("${config}")
    private String config;

    @GetMapping
    public String hello()
    {
        return "hello " + config;
    }
}
