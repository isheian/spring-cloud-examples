package cn.cccii.hystrix;

import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.HystrixCommand;

/**
 * @author as
 * @email heian@126.com
 * @date 2020年07月02日
 * description：添加描述
 */
public class HelloCommand extends HystrixCommand<String>
{
    RestTemplate restTemplate;

    public HelloCommand(Setter setter, RestTemplate restTemplate)
    {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception
    {
        return restTemplate.getForObject("http://provider/hello", String.class);
    }
}
