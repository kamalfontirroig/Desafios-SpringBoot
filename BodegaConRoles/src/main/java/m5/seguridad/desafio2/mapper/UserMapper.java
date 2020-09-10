package m5.seguridad.desafio2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import m5.seguridad.desafio2.model.Users;

@Mapper
public interface UserMapper {

    @Select("select * from users where email = #{email}")
    Users findByEmail(@Param("email") String email);

}
