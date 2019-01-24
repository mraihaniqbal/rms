package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet("/users/*")
public class UserServlet extends AbstractController
{
    static final String USERLIST_URI = "/users/list";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath()+req.getPathInfo());
        req.setAttribute("loggedUser",req.getSession().getAttribute("userId"));

        if ("/list".equals(req.getPathInfo()))
        {
            list(req);
        }
        else if (req.getPathInfo().contains("/form"))
        {
            if(req.getParameter("username") != null)
            {
                update(req);
            }
            else
            {
                req.setAttribute("path","add");
            }
        }
        else if( req.getPathInfo().equals("/delete"))
        {
            path = getTemplatePath(req.getServletPath()+"/list");
            delete(req);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = req.getContextPath()+USERLIST_URI;

        if ("/add".equals(req.getPathInfo()))
        {
            save(req);
        }
        else if("/update".equals(req.getPathInfo()))
        {
            updatePost(req);
        }
        else if(req.getPathInfo().equals("/deleteAll"))
        {
            deleteAll(req);
        }else
        {
            req.setAttribute("msg","Something wrong. Please notify your administrator.");
        }

        resp.sendRedirect(path);
    }

    private static void list(HttpServletRequest req)
    {
        UserDao userDao = UserDaoImpl.getInstance();
        List<User> users = userDao.findAll();
        req.setAttribute("users", users);
    }

    private static void save(HttpServletRequest req)
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao dao = UserDaoImpl.getInstance();
        User user = new User(username,password);

        if(dao.save(user))
        {
            req.setAttribute("msg", "Successfully add the user");
        }
        else
        {
            req.setAttribute("msg", "Failed to add the user");
        }

        list(req);
    }

    private static void updatePost(HttpServletRequest req){
        UserDao dao = UserDaoImpl.getInstance();
        Optional<User> opt = dao.find(Long.parseLong(req.getParameter("id")));

        if(opt.isPresent())
        {
            User user = opt.get();

            user.setUserName(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));

            if(dao.update(user))
            {
                req.setAttribute("msg", "Successfully update the user");
            }
            else
            {
                req.setAttribute("msg", "Failed to update the user");
            }

        }
        else
        {
            req.setAttribute("msg","Something happen. User not found.");
        }

        list(req);
    }

    private static void update(HttpServletRequest req)
    {
        UserDao userDao = UserDaoImpl.getInstance();
        Optional<User> opt = userDao.findByUserName(req.getParameter("username"));
        req.setAttribute("user",opt.orElse(null));
        req.setAttribute("path","update");
        list(req);

    }
    private static void delete(HttpServletRequest req)
    {
        UserDao userDao = UserDaoImpl.getInstance();
        if(!userDao.deleteByUserName(req.getParameter("username")))
        {
            req.setAttribute("msg","Failed to delete the user");
        }
        else
        {
            req.setAttribute("msg","Successfully delete the user");
        }

        list(req);
    }

    private static void deleteAll(HttpServletRequest req)
    {
        String[] usernames = req.getParameterValues("usernames");
        Arrays.stream(usernames).forEach(x->UserDaoImpl.getInstance().deleteByUserName(x));
        req.setAttribute("msg","Username(s) sucessfully deleted");

        list(req);
    }
}
