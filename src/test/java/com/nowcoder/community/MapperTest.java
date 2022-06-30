package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DisscussPost;
import com.nowcoder.community.entity.User;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        //根据id进行查询
       User user=userMapper.selectById(101);
        System.out.println(user);
        //根据姓名进行查询
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        //按照邮箱进行查询
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    //插入数据
    @Test
    public void testInsertUser(){
        //构造对象
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        //插入对象 rows表示改变了几行，id是主键id，自动增加
        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    //测试修改
    @Test
    public void updateUserTest(){
          int rows=userMapper.updateStatus(150,1);
          System.out.println(rows);
          rows=userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
          System.out.println(rows);
          rows=userMapper.updatePassword(150,"xwj1995");
          System.out.println(rows);
    }

    @Test
    public void testSelectposts(){
       List <DisscussPost> list= discussPostMapper.selectDisscussPosts(0,0,10);
       for(DisscussPost post:list){
           System.out.println(post);
       }
       int rows=discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }


}



