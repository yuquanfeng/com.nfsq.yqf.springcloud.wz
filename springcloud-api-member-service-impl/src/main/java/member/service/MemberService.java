package member.service;

import api.IMemberService;
import bean.YQFRequest;
import entity.User;
import member.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:14:08
 **/
@RestController
public class MemberService implements IMemberService {
    @Autowired
    UserMapper userMapper;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/")
    public String index(){
        return "我是会员服务,端口号;"+serverPort;
    }

    @Override
    @RequestMapping("/getUser")
    public YQFRequest<User> selectUserByName(String userName) {
        YQFRequest<User> result = new YQFRequest<>();
        System.out.println(userName);
        try {
            User user = userMapper.selectUserByName(userName);
            if(user!=null){
                result.setMessage("调用服务成功，查询到用户名："+user.getUserName()+"年龄："+user.getUserAge());
            }else{
                result.setMessage("调用服务成功,但当前用户名不存在");
            }
            result.setSuccess(true);
            result.setData(user);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("调用服务失败");
        }
        return result;
    }

    @Override
    @RequestMapping("/testHystrix")
    public YQFRequest testHystrix() {
        YQFRequest result = new YQFRequest();
        try {
            Thread.sleep(4000);
            result.setMessage("调用服务成功");
            result.setSuccess(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("调用服务失败");
        }
        return result;
    }
}
