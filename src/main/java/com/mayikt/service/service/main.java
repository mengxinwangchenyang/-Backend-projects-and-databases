package com.mayikt.service.service;

import com.mayikt.service.Mapper.UserMapper;
import com.mayikt.service.entity.Result;
import com.mayikt.service.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.AutoPopulatingList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/local")
public class main {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper ;
    //    插入
    @RequestMapping("/insertUser")
    public String insertUser(String formname,String name,String value){
        String sql="INSERT into "+formname+" VALUES(null,?,?);";
        int update=jdbcTemplate.update(sql,name,value);
        return update>0?"success":"fall";
    }

    @RequestMapping("/findByName")
    public UserEntity findByID(String formname,String fathername){
        return userMapper.selectById(formname,fathername);
    }

    @RequestMapping("/deleteByName")
    public String deleteUser(String formname,String fathername){
        String sql="DELETE FROM "+formname+" WHERE fathername=?;";
        int update=jdbcTemplate.update(sql,fathername);
        return update>0?"success":"fall";
    }
    //
    @RequestMapping("/changefatherByName")
    public String changefather(String formname,String fathername,String name){
        String sql="update "+formname+" set fathername=? where fathername=?";
        int update=jdbcTemplate.update( sql,name,fathername);
        return update>0?"success":"fall";
    }
    @RequestMapping("/changechildByName")
    public String changevalue(String formname,String fathername,String value){
        String sql="update "+formname+" set childvalue=? where fathername=?";
        int update=jdbcTemplate.update( sql,value,fathername);
        return update>0?"success":"fall";
    }


    @RequestMapping("/addtable")
    public String addtable(String formname){
        String SQL = "CREATE TABLE `"+ formname +"` (`id` int NOT NULL,`fathername` longtext CHARACTER SET utf8 NULL,`childvalue` longtext CHARACTER SET utf8 NULL);";
        jdbcTemplate.execute(SQL);
        return "";
    }
    @RequestMapping("/init1")
    public List<String> init(){
        String sql="show tables;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> tables = new ArrayList<>();
        List<String> tabelNames = new ArrayList<>();
        int i = 1;
        for (Map<String, Object> table : list) {
            Map<String, Object> sort = new HashMap<>();
            sort.put("id", i);
            sort.put("name", table.get("Tables_in_regist") + "");
            i++;
            tables.add(sort);
            tabelNames.add(table.get("Tables_in_regist") + "");
        }

        return tabelNames;
    }
    @RequestMapping("/getname")
    public UserEntity getfathername(String formname){

        return userMapper.selectByTrueId(formname);
    }

    @RequestMapping("/get-all-name")
    public Object getAllName( ){
        List<String> tableNames = init();
        List<Map<String, Object>> sorts = new ArrayList<>();
        int i = 1;
        for(String tableName : tableNames) {
            UserEntity s = userMapper.selectByTrueId(tableName);
            Map<String, Object> sort = new HashMap<>();
            sort.put("id", i);
            sort.put("name", s.getfathername());
            sort.put("tableName", tableName);
            sorts.add(sort);
            i++;
        }
        return Result.success(sorts);

    }

    @RequestMapping("/get-second-name")
    public Object getSecondName(String formname){
        String sql="select id,fathername,childvalue from "+formname+" where id != 0;";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> sorts = new ArrayList<>();
        for (Map<String, Object> row : list) {
            Map<String, Object> sort = new HashMap<>();
            sort.put("id", row.get("id"));
            sort.put("name", row.get("fathername"));
            sorts.add(sort);
        }
        return Result.success(sorts);
    }

    @RequestMapping("/get-third-name")
    public Object getThirdName(String formname, int secondId){
        String sql="select id,fathername,childvalue from "+formname+" where id=" + secondId;
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        Map<String, Object> second = list.get(0);
        String thirds = second.get("childvalue").toString();
        List<Map<String, Object>> sorts = new ArrayList<>();
        String [] thirdNames = thirds.split(",");
        int i = 1;
        for (String name : thirdNames) {
            Map<String, Object> sort = new HashMap<>();
            sort.put("id", i);
            sort.put("name", name);
            sorts.add(sort);
            i++;
        }
        return Result.success(sorts);
    }

}

