package com.qfedu.service.Impl;

import com.qfedu.mapper.EmpMapper;
import com.qfedu.pojo.Emp;
import com.qfedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    EmpMapper empMapper;

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    @Override
    public int getEmpCount() {
        return empMapper.getEmpCount();
    }

    @Override
    public List<Emp> getEmps(long pageStart, long pageSize) {
        return empMapper.getEmps(pageStart,pageSize);
    }
}
