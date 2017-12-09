package me.ordersystem.huang.dao;

import java.util.List;

import me.ordersystem.huang.pojo.Dishtype;
import me.ordersystem.huang.pojo.DishtypeExample;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DishtypeMapper {
    @SelectProvider(type = DishtypeSqlProvider.class, method = "countByExample")
    int countByExample(DishtypeExample example);

    @DeleteProvider(type = DishtypeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(DishtypeExample example);

    @Delete({
            "delete from dishtype",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into dishtype (dishType)",
            "values (#{dishtype,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Dishtype record);

    @InsertProvider(type = DishtypeSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Dishtype record);

    @SelectProvider(type = DishtypeSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "dishType", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Dishtype> selectByExample(DishtypeExample example);

    @Select({
            "select",
            "id, dishType",
            "from dishtype",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "dishType", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Dishtype selectByPrimaryKey(Integer id);

    @UpdateProvider(type = DishtypeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dishtype record, @Param("example") DishtypeExample example);

    @UpdateProvider(type = DishtypeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Dishtype record, @Param("example") DishtypeExample example);

    @UpdateProvider(type = DishtypeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dishtype record);

    @Update({
            "update dishtype",
            "set dishType = #{dishtype,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dishtype record);
}