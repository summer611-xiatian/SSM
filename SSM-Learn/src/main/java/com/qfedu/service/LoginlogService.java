package com.qfedu.service;

import com.qfedu.pojo.Loginlog;

import java.util.List;

public interface LoginlogService {
    public int  addLoginLog(Loginlog loginlog);

    public List<Loginlog> getLoginLog(String no);
}
