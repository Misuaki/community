package com.Misakill.community.dao;


import com.Misakill.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);   //修改用户状态

    int updateHeader(int id, String headerUrl); //修改用户头像

    int updatePassword(int id, String password);
}
