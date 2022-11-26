package cn.itcast.feign.pojo;

import lombok.Data;

/**
 * @Author zhuchifeng
 * @Date 2022/11/26 5:42
 * @Version 1.0
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}