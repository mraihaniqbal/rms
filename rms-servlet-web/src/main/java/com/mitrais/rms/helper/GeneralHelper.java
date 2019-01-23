package com.mitrais.rms.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GeneralHelper {

    public static boolean isLoggedIn(HttpServletRequest req){
        HttpSession session = req.getSession();
        return session.getAttribute("userId") != null;
    }

}
