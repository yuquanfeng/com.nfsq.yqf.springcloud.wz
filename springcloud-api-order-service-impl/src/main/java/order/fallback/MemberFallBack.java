package order.fallback;

import api.IMemberService;
import bean.YQFRequest;
import entity.User;
import order.feign.MemberFeign;
import org.springframework.stereotype.Component;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:14:29
 **/
//注意此类要实现标有@FeignClient注解的接口不然指向不到fallBackFactory
@Component
public class MemberFallBack implements MemberFeign {
    @Override
    public YQFRequest<User> selectUserByName(String userName) {
        YQFRequest<User> result = new YQFRequest<>();
        result.setSuccess(false);
        result.setMessage("当前排队人数过多，请稍后再试");
        return result;
    }

    @Override
    public YQFRequest testHystrix() {
        YQFRequest result = new YQFRequest();
        result.setMessage("当前排队人数过多，请稍后重试");
        result.setSuccess(false);
        return result;
    }
}
