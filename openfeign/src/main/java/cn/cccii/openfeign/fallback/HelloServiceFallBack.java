package cn.cccii.openfeign.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.cccii.commons.bean.User;
import cn.cccii.openfeign.service.HelloService;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月02日
 * description：添加描述
 */
@Component
@RequestMapping("/helloError")
public class HelloServiceFallBack implements HelloService
{
    @Override
    public String hello()
    {
        return "error hello ";
    }

    @Override
    public String name(String name)
    {
        return "error name " + name;
    }

    @Override
    public User user(User user)
    {
        return null;
    }

    @Override
    public void header(String name)
    {
        System.out.println("error " + name);
    }

    @Override
    public void delById(Integer id)
    {
        System.out.println("error " + id);
    }
}
