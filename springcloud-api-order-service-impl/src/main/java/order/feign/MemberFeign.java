package order.feign;

import api.IMemberService;
import order.fallback.MemberFallBack;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:14:26
 **/
@FeignClient(value = "springcloud-member",fallback = MemberFallBack.class)
public interface MemberFeign extends IMemberService {
}
