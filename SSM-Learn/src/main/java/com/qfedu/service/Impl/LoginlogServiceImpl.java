package com.qfedu.service.Impl;


import com.qfedu.mapper.LoginLogMapper;
import com.qfedu.pojo.Loginlog;
import com.qfedu.service.LoginlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginlogServiceImpl implements LoginlogService {
    @Resource
    LoginLogMapper logMapper;

    @Override
    public int addLoginLog(Loginlog loginlog) {
        return logMapper.addLoginLog(loginlog);
    }

    @Override
    public List<Loginlog> getLoginLog(String no) {
        return logMapper.getLoginLog(no);
    }
}
