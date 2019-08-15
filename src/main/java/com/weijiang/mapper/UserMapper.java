package com.weijiang.mapper;

import com.weijiang.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avarta_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avartaUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByCookie(@RequestParam("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@RequestParam("id") int id);
}