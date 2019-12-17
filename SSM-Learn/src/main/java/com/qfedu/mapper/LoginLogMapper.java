package com.qfedu.mapper;

import com.qfedu.pojo.Loginlog;

import java.util.List;

public interface LoginLogMapper {
    public int  addLoginLog(Loginlog loginlog);

    public List<Loginlog> getLoginLog(String no);
}
