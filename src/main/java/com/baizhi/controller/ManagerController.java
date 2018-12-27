package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 管理员功能Controller控制器
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 比较验证码
     *
     * @param enCode  管理员输入的验证码
     * @param session session作用域
     * @return 布尔值
     */
    @RequestMapping("/compare.do")
    @ResponseBody
    public Boolean compare(String enCode, HttpSession session) {
        String code = (String) session.getAttribute("code");
        if (code.equalsIgnoreCase(enCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 管理员登陆
     *
     * @param username 账户
     * @param password 密码
     * @param session  session作用域
     * @return 跳转路径
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public Map login(String username, String password, HttpSession session) {
        return managerService.queryManager(username, password, session);
    }

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param session     session作用域
     * @return 布尔值
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public Boolean update(String oldPassword, String newPassword, HttpSession session) {
        // 先判断旧密码是否正确
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager.getPassword().equals(oldPassword)) {
            // 先把作用域里的密码更改
            manager.setPassword(newPassword);
            // 再把数据库中的密码更改
            managerService.update(manager.getId(), manager.getPassword());
            return true;
        } else {
            return false;
        }
    }

    /**
     * 退出登陆
     *
     * @return 跳转路径
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("manager");
        return "redirect:/view/login.jsp";
    }
}
