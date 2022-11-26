package cn.itcast.order;

import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//Feign的日志配置：如果要全局生效，将其放到启动类的@EnableFeignClients这个注解中
@EnableFeignClients(basePackages = "cn.itcast.feign.client", defaultConfiguration = DefaultFeignConfiguration.class)
//开启Feign的功能
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入Spring容器
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //自定义负载均衡策略
    //注意，一般用默认的负载均衡规则，不做修改。
    /*@Bean
    public IRule randomRule() {
        return new RandomRule();
    }*/
}