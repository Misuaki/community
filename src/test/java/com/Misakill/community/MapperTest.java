package com.Misakill.community;

import com.Misakill.community.dao.DiscussPostMapper;
import com.Misakill.community.dao.UserMapper;
import com.Misakill.community.entity.DiscussPost;
import com.Misakill.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunitydemoApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void test_selectUser(){
        User user = userMapper.selectById(118);
        System.out.println(user);
    }

    @Test
    public void test_updateUser(){
        int row = userMapper.updateStatus(149, 0);
        System.out.println(row);
    }

    @Test
    public void test_discussPostMapper(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost dp : discussPosts){
            System.out.println(dp);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
