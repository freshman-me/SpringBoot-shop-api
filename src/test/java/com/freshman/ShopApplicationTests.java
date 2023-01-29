package com.freshman;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {

        // 逢7避过
        for (int i = 1; i <= 100; i++) {
            // 判断
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0)
                System.out.println(i);
        }


    }

}
