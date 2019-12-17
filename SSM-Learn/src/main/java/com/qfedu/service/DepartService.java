package com.qfedu.service;

import com.qfedu.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartService {
    public int addDepart(Depart depart);
    public int getDepartCount();
    public List<Depart> getDeparts(@Param("pageStart") long pageStart, @Param("pageSize") long pageSize);
    public int deleteDepart(int id);

    public List<Depart> findDeparts();
}
