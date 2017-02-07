package com.jee.servlet;

import com.jee.bean.UserBean;
import com.jee.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ���� on 05.02.2017.
 */
public class UserServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("list") != null) {
            List<User> allUser = null;
            try {
                allUser = userBean.getAll();
            } catch (Exception e) {
                allUser = new ArrayList<>();
            }
            req.setAttribute("users", allUser);
            req.getRequestDispatcher("user/list.jsp").forward(req, resp);
        } else if (req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            User user = userBean.get(id);
            req.setAttribute("user", user);
        } else if (req.getParameter("delete") != null) {
            long id = Long.valueOf(req.getParameter("delete"));
            try {
                userBean.delete(id);
            } catch (Exception ignore) {
            }
            req.getRequestDispatcher("user/list.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("user/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        int age = Integer.valueOf(req.getParameter("age"));
        if (!Objects.equals(req.getParameter("id"), "")) {
            long id = Long.valueOf(req.getParameter("id"));
            User user = userBean.get(id);
            user.setAge(age);
            user.setLastName(lastName);
            user.setName(name);
            try {
                userBean.update(user);
            } catch (Exception ignore) {
            }
        } else {
            try {
                userBean.add(new User(name, lastName, age));
            } catch (Exception ignore) {
                System.out.println(ignore.getLocalizedMessage());
            }
        }
        resp.sendRedirect("user?list=true");
    }
}
