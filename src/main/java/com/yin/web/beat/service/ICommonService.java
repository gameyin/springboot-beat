package com.yin.web.beat.service;

import com.yin.web.beat.entity.User;

/**
 *
 */
public interface ICommonService {

    /**
     *
     * @param uid
     * @return
     */
    public User getUserInfo(int uid);

    public void insertUser(User u);

    public User getUserByNick(String nick);
}
