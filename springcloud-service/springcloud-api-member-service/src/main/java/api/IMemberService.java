package api;

import bean.YQFRequest;
import entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:33
 **/
public interface IMemberService {
    @RequestMapping("/getUser")
    YQFRequest<User> selectUserByName(@RequestParam("userName") String userName);
    @RequestMapping("/testHystrix")
    YQFRequest testHystrix();
}
