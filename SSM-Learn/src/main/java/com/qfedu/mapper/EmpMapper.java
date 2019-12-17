package com.qfedu.mapper;

import com.qfedu.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    public Emp login(Emp emp);

    public int addEmp(Emp emp);

    public int getEmpCount();

    public List<Emp> getEmps(@Param("pageStart") long pageStart,@Param("pageSize") long pageSize);

}
