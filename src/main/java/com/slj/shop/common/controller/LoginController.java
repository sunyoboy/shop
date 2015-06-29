package com.slj.shop.common.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.slj.shop.common.bean.Role;
import com.slj.shop.common.bean.User;


/**
 * @author chenlf
 * 
 *         2014-3-24
 */
@Controller
public class LoginController {
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    return new ModelAndView("/login");
  }

  @RequestMapping(value = "/submit", method = RequestMethod.POST)
  public ModelAndView submit(String username, String password) {
    User user = new User("shiro", "123456");
    Set<Role> role = new HashSet<Role>();
    role.add(new Role("member"));
    user.setRoleSet(role);
    try {
      // 如果登陆成功
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user
            .getPassword().toString());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ModelAndView("redirect:/member/index.htm");
  }
}