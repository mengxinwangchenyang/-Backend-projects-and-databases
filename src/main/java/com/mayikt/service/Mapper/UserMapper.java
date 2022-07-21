package com.mayikt.service.Mapper;

import com.mayikt.service.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface UserMapper {
    @Select("select id as id,fathername as fathername,childvalue as childvalue from child1 where fathername =#{fathername};")
    UserEntity selectById1(@Param("fathername") String fathername);
    @Select("select id as id,fathername as fathername,childvalue as childvalue from child2 where fathername =#{fathername};")
    UserEntity selectById2(@Param("fathername") String fathername);
    @Select("select id as id,fathername as fathername,childvalue as childvalue from child3 where fathername =#{fathername};")
    UserEntity selectById3(@Param("fathername") String fathername);
    @Select("select id as id,fathername as fathername,childvalue as childvalue from child4 where fathername =#{fathername};")
    UserEntity selectById4(@Param("fathername") String fathername);
    @Select("select id as id,fathername as fathername,childvalue as childvalue from child5 where fathername =#{fathername};")
    UserEntity selectById5(@Param("fathername") String fathername);

    @Select("select id as id,fathername as fathername,childvalue as childvalue from ${formname} where fathername =#{fathername};")
    UserEntity selectById( @Param("formname") String formname,@Param("fathername") String fathername);

    @Select("select id as id,fathername as fathername,childvalue as childvalue from ${formname} where id =0;")
    UserEntity selectByTrueId( @Param("formname") String formname);
}
