package member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:14:02
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"member.mapper"})
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class,args);
    }
}
