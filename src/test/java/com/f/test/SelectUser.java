package com.f.test;

import com.f.App;
import com.f.domain.User;
import com.f.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = App.class)
public class SelectUser {
    @Autowired
    private UserService userService;

    @Test
    void getUser() {
        userService.selectByPrimaryKey(1L);
    }

    @Test
    void paginate() throws JsonProcessingException {
//        PageHelper.offsetPage(10, 10);
        ;
        Page<User> page = PageHelper
                .startPage(1, 10).doSelectPage(
                        () -> userService.selectAll(new RowBounds(10, 10))
                );

        System.out.println(page);
    }
}
