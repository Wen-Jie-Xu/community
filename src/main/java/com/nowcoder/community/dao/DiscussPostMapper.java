package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DisscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DiscussPostMapper {
    List<DisscussPost> selectDisscussPosts(int userId,int offset,int limit);
    //@Param注解用于给参数起别名
    //如果只有一种参数，并且在if里面使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}



