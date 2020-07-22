package cn.cccii.hystrix.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import cn.cccii.hystrix.HelloCommand;
import cn.cccii.hystrix.service.HelloService;

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

    @Resource
    RestTemplate restTemplate;

    @GetMapping
    public String main()
    {
        return helloService.hello();
    }

    @GetMapping("command")
    public String command()
    {
        HelloCommand command = new HelloCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("command")), restTemplate);
        return command.execute();
    }
}
