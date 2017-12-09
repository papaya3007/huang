package me.ordersystem.huang.dao;

import java.math.BigDecimal;
import java.util.List;

import me.ordersystem.huang.pojo.Dish;
import me.ordersystem.huang.pojo.DishExample;
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

public interface DishMapper {
    @SelectProvider(type = DishSqlProvider.class, method = "countByExample")
    int countByExample(DishExample example);

    @DeleteProvider(type = DishSqlProvider.class, method = "deleteByExample")
    int deleteByExample(DishExample example);

    @Delete({
            "delete from dish",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into dish (dishName, dishPrice, ",
            "dishType)",
            "values (#{dishname,jdbcType=VARCHAR}, #{dishprice,jdbcType=DECIMAL}, ",
            "#{dishtype,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Dish record);

    @InsertProvider(type = DishSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Dish record);

    @SelectProvider(type = DishSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "dishName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "dishPrice", javaType = BigDecimal.class, jdbcType = JdbcType.DECIMAL),
            @Arg(column = "dishType", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    List<Dish> selectByExample(DishExample example);

    @Select({
            "select",
            "id, dishName, dishPrice, dishType",
            "from dish",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "dishName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "dishPrice", javaType = BigDecimal.class, jdbcType = JdbcType.DECIMAL),
            @Arg(column = "dishType", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    Dish selectByPrimaryKey(Integer id);

    @UpdateProvider(type = DishSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dish record, @Param("example") DishExample example);

    @UpdateProvider(type = DishSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Dish record, @Param("example") DishExample example);

    @UpdateProvider(type = DishSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dish record);

    @Update({
            "update dish",
            "set dishName = #{dishname,jdbcType=VARCHAR},",
            "dishPrice = #{dishprice,jdbcType=DECIMAL},",
            "dishType = #{dishtype,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dish record);
}