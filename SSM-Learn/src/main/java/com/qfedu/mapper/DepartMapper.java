package com.qfedu.mapper;


import com.qfedu.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartMapper {
        public int addDepart(Depart depart);

        public int getDepartCount();

        public List<Depart> getDeparts(@Param("pageStart") long pageStart,@Param("pageSize") long pageSize);

        public int deleteDepart(int id);

        /**
         * 查询可用下拉框
         */
        public List<Depart> findDeparts();
}
