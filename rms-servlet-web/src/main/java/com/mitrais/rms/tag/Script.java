package com.mitrais.rms.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 *
 */
public class Script extends SimpleTagSupport
{
    private String src;

    public void doTag() throws JspException, IOException
    {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String relLink = request.getContextPath()+ "/" + this.src;
        JspWriter out = getJspContext().getOut();
        out.println("<script src=\""+relLink+"\"></script>");
    }

    public String getSrc()
    {
        return src;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

}
