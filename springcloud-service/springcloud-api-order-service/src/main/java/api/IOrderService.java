package api;

import bean.YQFRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:45
 **/
public interface IOrderService {

    @RequestMapping("/hello")
    YQFRequest hello();

    @RequestMapping("/orderToMember")
    YQFRequest orderToMember(@RequestParam("userName") String userName);

    @RequestMapping("/testHystrix")
    YQFRequest testHystrix();
}
