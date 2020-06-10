package com.example.demo.Mapper;

import com.example.demo.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClientMapper {
    @Update("insert into client values (null,#{username},#{password})")
    public int update(Client client);

    @Select("select count(*) from client where username=#{username} and password=#{password}")
    public int select(Client client);
}
