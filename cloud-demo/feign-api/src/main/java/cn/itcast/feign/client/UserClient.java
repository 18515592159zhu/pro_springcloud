package cn.itcast.feign.client;

import cn.itcast.feign.config.DefaultFeignConfiguration;
import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhuchifeng
 * @Date 2022/11/26 5:41
 * @Version 1.0
 */
//Feign的日志配置：局部生效
@FeignClient(value = "userservice", configuration = DefaultFeignConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}