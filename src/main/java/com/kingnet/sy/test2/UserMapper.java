package com.kingnet.sy.test2;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by sunyue on 2017/6/6.
 */
public interface UserMapper {

    @Insert("insert into users(name,age) VALUES (#{name},#{age})")
    int add(User user);

    @Delete("DELETE FROM users where id = #{id}")
    int deleteById(int id);

    @Update("UPDATE users set name = #{name} ,age = #{age} where id = #{id}")
    int update(User user);

    @Select("select * from users where id=#{id}")
    User getById(int id);

    @Select("select * from users")
    List<User> getAllUsers();

}
