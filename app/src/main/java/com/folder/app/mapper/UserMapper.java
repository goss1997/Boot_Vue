package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {

    @Select("select * from user3 where del != 1")
    public List<UserDTO> findAll();

    @Update("update user3 set name = #{name}, pwd= #{pwd}, gender = #{gender} where no = #{no}")
    public int editById(UserDTO uDto);

    @Update("update user3 set del = 1 where no = #{no}")
    public int delete(int no);

    @Insert("insert into user3 (no,name,email,pwd,gender)values(seq_user3_no.nextval,#{name},#{email},#{pwd},#{gender})")
    @SelectKey(statement = "SELECT seq_user3_no.currval FROM dual", keyProperty = "no", before = false, resultType = int.class)
    public int save(UserDTO uDto);

    @Select("select * from user3 where no = #{no}")
    public UserDTO findById(int no);

}
