<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "rms" uri = "/WEB-INF/tlds/link.tld"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        
        <title>RMS</title>
        <meta name="description" content="Index">
        <meta name="author" content="Mitrais">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        <rms:script src="js/script.js"/>
        <rms:link type="stylesheet" href="css/styles.css"/>
        
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
        <![endif]-->
    </head>
    
    <body>
        <div class="demo-layout-transparent mdl-layout mdl-js-layout">
            <header class="mdl-layout__header mdl-layout__header--transparent">
                <div class="mdl-layout__header-row">
                    <!-- Title -->
                    <span class="mdl-layout-title">RMS</span>
                    <!-- Add spacer, to align navigation to the right -->
                    <div class="mdl-layout-spacer"></div>
                    <!-- Navigation -->
                    <nav class="mdl-navigation">
                        <% if(request.getSession(false) == null){ %>
                            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/login">Login</a>
                        <% } else { %>
                            <%--Logged in Menu--%>
                            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/users/list">Users</a>
                            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/logout">Logout</a>
                            <%----%>
                        <% } %>
                    </nav>
                </div>
            </header>
            <div class="mdl-layout__drawer">
                <span class="mdl-layout-title">RMS</span>
                <nav class="mdl-navigation">
                    <% if(request.getSession(false) == null){ %>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/login">Login</a>
                    <% } else { %>
                        <%--Logged in Menu--%>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/users/list">Users</a>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        <%----%>
                    <% } %>
                </nav>
            </div>
            <main class="mdl-layout__content">