package com.mayikt.service.service;

import com.mayikt.service.Mapper.UserMapper;
import com.mayikt.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/local")
@RestController
public class UserService5 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper ;
//    插入
    @RequestMapping("/child5/insertUser")
    public String insertUser(String name,String value){
        int update=jdbcTemplate.update("INSERT into child5 VALUES (null,?,?);",name,value);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child5/findByName")
    public UserEntity findByID(String fathername){
        return userMapper.selectById5(fathername);
    }

    @RequestMapping("/child5/deleteByName")
    public String deleteUser(String fathername){
        int update=jdbcTemplate.update("DELETE FROM child5 WHERE fathername=?;",fathername);
        return update>0?"success":"fall";
    }

    @RequestMapping("/child5/changefatherByName")
    public String changefather(String fathername,String name){
        int update=jdbcTemplate.update( "update child5 set fathername=? where fathername=?",fathername,name);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child5/changechildByName")
    public String changevalue(String fathername,String value){
        int update=jdbcTemplate.update( "update child5 set childvalue=? where fathername=?",value,fathername);
        return update>0?"success":"fall";
    }
}
