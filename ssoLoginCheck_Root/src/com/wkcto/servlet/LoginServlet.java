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
 * @date:2019/3/13 0013 下午 9:17
 * PXY
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "123".equals(password)) {
            Cookie cookie = new Cookie("ssoCookie","sso");
            cookie.setPath("/");
            cookie.setDomain("wkcto.com");
            resp.addCookie(cookie);
            resp.sendRedirect(req.getParameter("gotoUrl"));
        } else {
            System.out.println("login failed");
        }
    }
}
