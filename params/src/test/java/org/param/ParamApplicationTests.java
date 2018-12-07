package org.param;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParamApplicationTests {

    @Value("${org.key}")
    private String key;

    @Value("${org.password}")
    private String password;

    @Value("${my.secret}")
    private String name;

    @Value("${my.number}")
    private String number;

    @Value("${my.bignumber}")
    private String bigNumber;

    @Value("${my.uuid}")
    private String uuid;

    @Value("${my.number.less.than.ten}")
    private String numberTen;

    @Value("${my.number.in.range}")
    private String range;

    @Test
    public void contextLoads() {

        System.out.println(key);
        System.out.println(password);
        System.out.println(name);
        System.out.println(number);
        System.out.println(bigNumber);
        System.out.println(uuid);
        System.out.println(numberTen);
        System.out.println(range);

    }

}
