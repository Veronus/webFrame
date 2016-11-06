package com.mes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mes.meta.Event;

@Repository
public interface EventDao {
	
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "location", column = "location"),
			@Result(property = "starttime", column = "starttime") })
	@Insert("insert into event (id,name,location,starttime) values (#{id},#{name},#{location},#{starttime})")
	public void insertEvent(@Param("id")String id ,@Param("name") String name, @Param("location") String location,@Param("starttime")String date);

	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "location", column = "location"),
			@Result(property = "starttime", column = "starttime") })
	@Select("select * from event")
	public List<Event> getEvents();
}
