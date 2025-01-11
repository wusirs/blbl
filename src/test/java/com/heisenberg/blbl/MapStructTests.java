package com.heisenberg.blbl;

import com.heisenberg.blbl.bean.po.BankCard;
import com.heisenberg.blbl.bean.po.BankUser;
import com.heisenberg.blbl.convert.BankUserConvert;
import com.heisenberg.blbl.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = BlblApplication.class)
@RunWith(SpringRunner.class)
public class MapStructTests {

    @Autowired
    private BankUserConvert bankUserConvert;

    @Autowired
    private CommentService commentService;

    @Test
    public void testMapStruct(){
        System.out.println("_____________________________");
        System.out.println(bankUserConvert);
        BankUser bankUser = new BankUser("123", "张三", "12321421321", new Date(), "1,2,3");
        System.out.println(bankUserConvert.po2Dto(bankUser));

        BankCard bankCard = new BankCard("123", BigDecimal.valueOf(30000.00D), 1, new Date());
        System.out.println(bankUserConvert.po2BankCardDto(bankCard));

        BankUser bankUser2 = new BankUser("123", "张三", "12321421321", new Date(), "1,2,3");
        List<BankUser> bankUserList = Arrays.asList(bankUser, bankUser2);
        System.out.println(bankUserConvert.po2BanKUserDto(bankUserList));
    }
}
