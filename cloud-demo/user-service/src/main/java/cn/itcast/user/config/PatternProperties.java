package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author zhuchifeng
 * @Date 2022/11/26 4:50
 * @Version 1.0
 */
//配置热更新：方式二：使用@ConfigurationProperties注解代替@Value注解。
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
}