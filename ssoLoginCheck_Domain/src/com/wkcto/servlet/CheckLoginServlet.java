package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:CheckLoginServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/11 0011 下午 8:26
 * PXY
 */
@WebServlet("/checkLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getHeader("Referer");
        Cookie[] cookies = req.getCookies();
        if (null == cookies) {
            resp.sendRedirect(path+"login.jsp");
            return;
        }
        for (Cookie cookie : cookies) {
            if ("ssoCookie".equals(cookie.getName()) && "sso".equals(cookie.getValue())) {
                resp.sendRedirect(path+"demo.jsp");
                return;
            }
        }
        resp.sendRedirect(path+"login.jsp");
    }
}
