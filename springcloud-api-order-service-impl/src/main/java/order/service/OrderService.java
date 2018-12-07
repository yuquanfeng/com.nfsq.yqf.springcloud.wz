package order.service;

import api.IOrderService;
import bean.YQFRequest;
import com.spring4all.swagger.EnableSwagger2Doc;
import entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import order.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:48
 **/
@EnableSwagger2Doc
@RestController
@Api("订单服务")
public class OrderService implements IOrderService {
    @Autowired
    MemberFeign memberFeign;

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value = "得到用户的信息",notes = "根据登录的用户得到用户的信息")
    @ApiImplicitParam(paramType = "query",name = "userName",value = "用户名",required = true,dataType = "String")
    @GetMapping("/getUser")
    public String getUser(@RequestParam("userName") String userName){
        return "当前用户"+userName;
    }

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
