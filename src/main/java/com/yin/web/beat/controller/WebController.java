package com.yin.web.beat.controller;

import com.yin.web.beat.entity.User;
import com.yin.web.beat.service.ICommonService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value = "/user")
public class WebController {

    @Autowired
    ICommonService commonService;

    /**
     * 查询用户账号信息
     * @param uid
     * @return
     */
    @GetMapping(value = "/account")
    public String getAccountInfo(@Param("uid") String uid, Model model) {
        User user = commonService.getUserInfo(Integer.parseInt(uid));
        model.addAttribute("user",user);

        return "info";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user,Model model) {
        String nick = user.getNickname();
        String password = user.getPassword();

        if (StringUtils.isEmpty(nick) || StringUtils.isEmpty(password)) {
            return "register";
        }
        else {
            commonService.insertUser(user);
            model.addAttribute("user",user);
            return "info";
        }
    }

    /**
     * 登录页，与主页相同
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        String nickname = user.getNickname();
        String password = user.getPassword();
        if(StringUtils.isEmpty(nickname) || StringUtils.isEmpty(password)){
            return "index";
        }

        User userVal = commonService.getUserByNick(nickname);

        if (userVal == null || !password.equals(userVal.getPassword())) {
            return "register";
        }
        else {
            return "redirect:/user/account?uid="+userVal.getUid();
        }
    }
}
