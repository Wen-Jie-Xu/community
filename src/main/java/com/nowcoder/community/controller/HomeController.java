package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DisscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

   @RequestMapping("/index")
    public String getIndexPage(Model model, Page page){
       //方法调用前，SpringMVC会自动实例化Model和page，并将page注入到MOdel
       //所以，在Thymeleaf中可以直接访问page中的数据
      page.setRows(discussPostService.findDiscussPostRows(0));
      page.setPath("/index");
      List<DisscussPost> list= discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
      List<Map<String,Object>> discussPosts=new ArrayList<>();
      if(list!=null){
          for(DisscussPost post:list){
              Map<String,Object> map=new HashMap<>();
              map.put("post",post);
              User user=userService.findUserById(post.getUserId());
              map.put("user",user);
              discussPosts.add(map);
              System.out.println(map);
          }
      }
       model.addAttribute("discussPosts",discussPosts);
       return "index";
   }

}



