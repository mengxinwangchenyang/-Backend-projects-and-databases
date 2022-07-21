package com.mayikt.service.service;

import com.mayikt.service.Mapper.UserMapper;
import com.mayikt.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/local")
@RestController
public class UserService3 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper ;
//    插入
    @RequestMapping("/child3/insertUser")
    public String insertUser(String name,String value){
        int update=jdbcTemplate.update("INSERT into child3 VALUES (null,?,?);",name,value);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child3/findByName")
    public UserEntity findByID(String fathername){
        return userMapper.selectById3(fathername);
    }

    @RequestMapping("/child3/deleteByName")
    public String deleteUser(String fathername){
        int update=jdbcTemplate.update("DELETE FROM child3 WHERE fathername=?;",fathername);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child3/changefatherByName")
    public String changefather(String fathername,String name){
        int update=jdbcTemplate.update( "update child3 set fathername=? where fathername=?",fathername,name);
        return update>0?"success":"fall";
    }
    @RequestMapping("/child3/changechildByName")
    public String changevalue(String fathername,String value){
        int update=jdbcTemplate.update( "update child3 set childvalue=? where fathername=?",value,fathername);
        return update>0?"success":"fall";
    }
}
