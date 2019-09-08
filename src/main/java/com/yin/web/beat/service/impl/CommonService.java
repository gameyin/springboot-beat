package com.yin.web.beat.service.impl;

import com.yin.web.beat.entity.User;
import com.yin.web.beat.mapper.UserMapper;
import com.yin.web.beat.service.ICommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommonService implements ICommonService {

    @Resource
    UserMapper mapper;

    @Override
    public User getUserInfo(int uid) {
        return mapper.selectByPrimaryKey(uid);
    }

    @Override
    public void insertUser(User u) {
        mapper.insertSelective(u);
    }

    @Override
    public User getUserByNick(String nick) {
        return mapper.selectByNickName(nick);
    }
}
