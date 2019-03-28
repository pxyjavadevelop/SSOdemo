package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:LoginServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/11 0011 下午 8:25
 * PXY
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "123".equals(password)) {
            Cookie ssoCookie = new Cookie("ssoCookie","sso");
            //cookie有目录限制，不同域名可能不能访问cookie
            ssoCookie.setPath("/");
            //登录成功后的返回地址
            resp.sendRedirect(req.getParameter("gotoUrl"));
        } else {
            System.out.println("login error.............");
        }
    }
}
