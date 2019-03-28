package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName:CheckLoginServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/15 0015 下午 10:15
 * PXY
 */
@WebServlet("/checkLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        for (Cookie cookie : cookies) {
            if ("ssoCookie".equals(cookie.getName()) && "sso".equals(cookie.getValue())) {
                URL url = new URL("http://www.login.com:8080/ssoLoginCheck/checkLogin?cookieName=ssoCookie" + "cookieValue=" + cookie.getValue());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String temp = "";
                StringBuffer stringBuffer = new StringBuffer();
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuffer.append(temp);
                }
                if ("1".equals(stringBuffer.toString())) {
                    resp.sendRedirect("demo.jsp");
                    return;
                }
            }
            resp.sendRedirect("login.jsp");
        }
    }
}
