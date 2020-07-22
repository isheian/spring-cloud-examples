package cn.cccii.consumer.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Resource
    RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello() {
        return restTemplate.getForObject("http://provider/hello", String.class);
    }

    @GetMapping("user")
    public String user()
    {
        MultiValueMap<String, Object> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("username", "admin");
        valueMap.add("password", "123456");
        User result = restTemplate.postForObject("http://provider/user", valueMap, User.class);
        log.warn("result：{}", result);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        User jsonResult = restTemplate.postForObject("http://provider/jsonUser", user, User.class);
        log.warn("jsonResult：{}", jsonResult);
        return jsonResult.toString();
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://provider/hello", user, String.class);
//        String body = responseEntity.getBody();
//        log.warn("响应body：{}", body);
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        log.warn("响应状态码：{}", statusCodeValue);
//        HttpHeaders headers = responseEntity.getHeaders();
//        for (String headerKey : headers.keySet()) {
//            log.warn("响应头：{}={}", headerKey, headers.get(headerKey));
//        }
//        return body;
    }
}
