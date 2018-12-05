package api;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qfyu
 * Date:2018/12/5
 * Time:9:32
 **/
public interface IPayService {
    @RequestMapping("/")
    public String index();
}
