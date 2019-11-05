package club.yuit;

import club.yuit.entity.User;
import club.yuit.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {


    @Autowired
    private UserService service;

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {

        Environment environment= context.getEnvironment();

        System.out.println(environment.getActiveProfiles());

    }

}
