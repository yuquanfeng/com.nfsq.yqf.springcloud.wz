package pay.service;

import api.IPayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qfyu
 * Date:2018/12/5
 * Time:9:35
 **/
@RestController
public class PayService implements IPayService {
    @Value("${server.port}")
    private String serverPort;
    @Override
    @RequestMapping("/")
    public String index() {
        return "我是支付服务,端口号："+serverPort;
    }
}
