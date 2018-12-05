package order.service;

import api.IOrderService;
import bean.YQFRequest;
import entity.User;
import order.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:48
 **/
@RestController
public class OrderService implements IOrderService {
    @Autowired
    MemberFeign memberFeign;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/")
    public String index(){
        return "我是订单服务,端口号："+serverPort;
    }
    @Override
    @RequestMapping("/hello")
    public YQFRequest hello() {
        return new YQFRequest();
    }

    @Override
    @RequestMapping("/orderToMember")
    public YQFRequest orderToMember(String userName) {
        System.out.println(userName);
        YQFRequest<User> result = memberFeign.selectUserByName(userName);
        return result;
    }
    @RequestMapping("/testHystrix")
    @Override
    public YQFRequest testHystrix() {
        return memberFeign.testHystrix();
    }
}
