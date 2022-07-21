package com.mayikt.service.service;

import com.mayikt.service.Mapper.UserMapper;
import com.mayikt.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/local")
@RestController
public class UserService4 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper ;
//    插入
    @RequestMapping("/child4/insertUser")
    public String insertUser(String name,String value){
        int update=jdbcTemplate.update("INSERT into child4 VALUES (null,?,?);",name,value);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child4/findByName")
    public UserEntity findByID(String fathername){
        return userMapper.selectById4(fathername);
    }

    @RequestMapping("/child4/deleteByName")
    public String deleteUser(String fathername){
        int update=jdbcTemplate.update("DELETE FROM child4 WHERE fathername=?;",fathername);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child4/changefatherByName")
    public String changefather(String fathername,String name){
        int update=jdbcTemplate.update( "update child4 set fathername=? where fathername=?",fathername,name);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child4/changechildByName")
    public String changevalue(String fathername,String value){
        int update=jdbcTemplate.update( "update child4 set childvalue=? where fathername=?",value,fathername);
        return update>0?"success":"fall";
    }
}
