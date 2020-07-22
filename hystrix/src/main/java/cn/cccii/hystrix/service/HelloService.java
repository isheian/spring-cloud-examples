package cn.cccii.hystrix.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月02日
 * description：添加描述
 */
@Service
public class HelloService
{
    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hello()
    {
        return restTemplate.getForObject("http://provider/hello", String.class);
    }

    public String error()
    {
        return "error";
    }
}
