package com.qfedu.service.Impl;
import	java.lang.ref.Reference;
import java.util.List;

import com.qfedu.mapper.DepartMapper;
import com.qfedu.pojo.Depart;
import com.qfedu.service.DepartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    DepartMapper departMapper;
    @Override
    public int addDepart(Depart depart) {
        return departMapper.addDepart(depart);
    }

    @Override
    public int getDepartCount() {
        return departMapper.getDepartCount();
    }

    @Override
    public List<Depart> getDeparts(long pageStart, long pageSize) {
        return departMapper.getDeparts(pageStart,pageSize);
    }

    @Override
    public int deleteDepart(int id) {
        return departMapper.deleteDepart(id);
    }

    @Override
    public List<Depart> findDeparts() {
        return departMapper.findDeparts();
    }
}
