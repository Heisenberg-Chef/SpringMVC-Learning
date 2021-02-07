package com.qi.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getInputStream().read();
//        byte arr[] = new byte[1024];
//        int read = req.getInputStream().read(arr);
//        resp.getWriter().println(arr.toString());
        // 获取参数

        resp.setContentType("utf-8");
        resp.setContentType("text/html");
        ServletContext context = this.getServletContext();
        resp.getWriter().println("HelloServlet");
        String username = "祁磊";
        // 将一个数据保存在了ServletContext中,名字是"username",值为username.
        context.setAttribute("username",username);

        String method = req.getParameter("method");
        if(method.equals("add"))
        {
            req.getSession().setAttribute("msg","执行了add方法");
        }
        if(method.equals("delete"))
        {
            req.getSession().setAttribute("msg","执行了delete方法");
        }
//         业务逻辑
//         视图跳转 , 并且向下继续跳转.
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
