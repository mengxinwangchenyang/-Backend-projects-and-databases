package com.mayikt.service.service;

import com.mayikt.service.Mapper.UserMapper;
import com.mayikt.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local")
public class UserService1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper ;
//    插入
    @RequestMapping("/child1/insertUser")
    public String insertUser(String name,String value){
        int update=jdbcTemplate.update("INSERT into child1 VALUES (null,?,?);",name,value);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child1/findByName")
    public UserEntity findByID(String fathername){

        return userMapper.selectById1(fathername);
    }

    @RequestMapping("/child1/deleteByName")
    public String deleteUser(String fathername){
        int update=jdbcTemplate.update("DELETE FROM child1 WHERE fathername=?;",fathername);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child1/changefatherByName")
    public String changefather(String fathername,String name){
        int update=jdbcTemplate.update( "update child1 set fathername=? where fathername=?",name,fathername);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child1/changechildByName")
    public String changevalue(String fathername,String value){
        int update=jdbcTemplate.update( "update child1 set childvalue=? where fathername=?",value,fathername);
        return update>0?"success":"fall";
    }
}
