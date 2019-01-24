package com.mitrais.rms.controller;

import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet
{
    private static final String VIEW_PREFIX = "/WEB-INF/jsp";
    private static final String VIEW_SUFFIX = ".jsp";

    protected String getTemplatePath(String path)
    {
        if (path.equalsIgnoreCase("/"))
        {
            return path + "index" + VIEW_SUFFIX;
        }
        else
        {
            return VIEW_PREFIX + path + VIEW_SUFFIX;
        }
    }

}
