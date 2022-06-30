package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DisscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussionPostMapper;
    public List<DisscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussionPostMapper.selectDisscussPosts(userId,offset,limit);
    }
    //查询行数的方法
    public int findDiscussPostRows(int userId){
        return discussionPostMapper.selectDiscussPostRows(userId);
    }

}



