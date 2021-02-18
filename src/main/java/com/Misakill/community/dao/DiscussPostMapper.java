package com.Misakill.community.dao;

import com.Misakill.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //这个函数返回分页查询的帖子，默认userId为0,返回值为帖子的List
    //userId参数是为了以后实现在用户个人主页查找自己的帖子，动态实现sql
    //后两参数实现分页，offset为每一页起始行号，limit为每一页的行数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //查询出表有多少数据，方便分页计算页数
    int selectDiscussPostRows(@Param("userId") int userId); //该注解为给参数起别名
    //当函数只有一个参数，且函数要实现一个动态的sql时，且该sql需要与用到该唯一参数
    //则该参数前面必须要使用@Param注解给参数起别名
}
