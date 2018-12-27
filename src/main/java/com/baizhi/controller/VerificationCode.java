package com.baizhi.controller;

import com.baizhi.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping
public class VerificationCode {

    @RequestMapping("/gainValidateCode.do")
    public void gainValidateCode(HttpSession session, HttpServletResponse response) throws IOException {
        // 创建验证码对象
        CreateValidateCode validateCode = new CreateValidateCode();
        // 获取验证码随机数，存入session作用域
        String code = validateCode.getCode();
        session.setAttribute("code", code);
        // 获取输出流，输出验证码
        ServletOutputStream out = response.getOutputStream();
        validateCode.write(out);
    }
}
