package com.newer.Mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select userid,username,state from sys_user where " +
            "username=#{username} and password=#{password}")
    User findByParam(@Param("username") String username,
                     @Param("password") String password);

    @Insert("insert into sys_user values(null,#{username},#{password}," +
            "#{state},#{mobile},#{email},#{jointime},#{job},#{sex}")
    int addUser(User user);

    @Select("select count(userid) from sys_user where " +
            "username=#{username}")
    int findUsername(@Param("username") String username);

    @Select("select * from sys_user where userid=#{userId}")
    User findById(@Param("userId") int userid);

    @Update("update sys_user set password=#{password} where " +
            "userid=#{userId}")
    int updateUser(@Param("userId") int userid,
                   @Param("password") String password);
}
