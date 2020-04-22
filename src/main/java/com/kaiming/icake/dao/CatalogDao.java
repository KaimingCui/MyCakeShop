package com.kaiming.icake.dao;

import com.kaiming.icake.entity.Catalog;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CatalogDao {

    @Insert("<script>" +
            "INSERT INTO catalog(title,pid,info) VALUES" +
            "<foreach collection='list' item='catalog' separator=','>" +
            "(#{catalog.title},#{catalog.pid},#{catalog.info})" + "</foreach>"
            + "</script>")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void batchInsert(List<Catalog> list);

    @Delete("DELETE FROM catalog WHERE id = #{id}")
    public void delete(@Param("id") Integer id);

    @Select("SELECT * FROM catalog WHERE id = #{id}")
    @Results(id="all",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "pid",property = "pid"),
            @Result(column = "info",property = "info"),
            @Result(column = "id",property = "children",many = @Many(select = "selectByPid"))
    })
    public Catalog select(@Param("id") Integer id);

    @Select("SELECT * FROM catalog WHERE pid = #{pid}")
    @ResultMap("all")
    public List<Catalog> selectByPid(@Param("pid") Integer pid);
}
