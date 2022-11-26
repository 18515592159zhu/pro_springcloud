package cn.itcast.order.service;

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.远程查询User
        // 2.1.url地址
        //String url = "http://localhost:8081/user/" + order.getUserId();

        //String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发起调用
        //User user = restTemplate.getForObject(url, User.class);

        //2.3.利用Feign发起http请求，查询用户
        User user = userClient.findById(order.getUserId());
        //3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
