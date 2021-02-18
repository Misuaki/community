package com.Misakill.community.controller;

import com.Misakill.community.dao.DiscussPostMapper;
import com.Misakill.community.entity.DiscussPost;
import com.Misakill.community.entity.Page;
import com.Misakill.community.entity.User;
import com.Misakill.community.service.DiscussPostService;
import com.Misakill.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //controller的方法一定要有地址映射
    @RequestMapping(path = "/index", method = RequestMethod.GET)     //请求方式get
    public String getIndexPage(Model model, Page page){
        //方法调用前，SPringMVC会自动实例化Model和Page，并将Page注入到Model
        //所以，在thymeleaf中可以直接访问Page对象中的数据 无需model.addAttribute
        page.setRows(discussPostService.findDiscussPostRows(0));//给页面传数据的总数
        page.setPath("/index"); //分页的操作都在index这个地址进行

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit()); //保存返回的帖子
        List<Map<String, Object>> discussPosts = new ArrayList<>();  //存储帖子和对应发帖人

        if(list != null){
            for(DiscussPost post : list){ //遍历帖子列表
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);     //把帖子存入map
                User user = userService.findUserById(post.getUserId()); //根据用户id找到发帖用户，存入map
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        //thymeleaf会使用model传递回页面的数据来操作！！
        model.addAttribute("discussPosts", discussPosts);

        return "/index";   //主页直接放在templa包下面，可以被thymeleaf搜索到
    }
}
