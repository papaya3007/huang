package me.ordersystem.huang.dao;

import java.util.List;

import me.ordersystem.huang.pojo.Admin;
import me.ordersystem.huang.pojo.AdminExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    @SelectProvider(type = AdminSqlProvider.class, method = "countByExample")
    int countByExample(AdminExample example);

    @DeleteProvider(type = AdminSqlProvider.class, method = "deleteByExample")
    int deleteByExample(AdminExample example);

    @Delete({
            "delete from admin",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into admin (adminName, password)",
            "values (#{adminname,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Admin record);

    @InsertProvider(type = AdminSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Admin record);

    @SelectProvider(type = AdminSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "adminName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Admin> selectByExample(AdminExample example);

    @Select({
            "select",
            "id, adminName, password",
            "from admin",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "adminName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(Integer id);

    @UpdateProvider(type = AdminSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type = AdminSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type = AdminSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
            "update admin",
            "set adminName = #{adminname,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);

    @Select("select * from admin where adminName=#{adminName} and password=#{password}")
    Admin login(@Param("adminName") String adminName, @Param("password") String password);
}