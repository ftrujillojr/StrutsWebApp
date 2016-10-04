<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Other pages
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/ns2/home">ns2/home</a></li>
                                <li><a href="${pageContext.request.contextPath}/ns2/dude">ns2/dude</a></li> 
                                <li><a href="${pageContext.request.contextPath}/css/project.css">css/project.css</a></li> 
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a hef="#">Help</a></li>
                    </ul> 
                </div>
            </div>
        </nav>
        <div id="main" class="main">
            <div id="content" class="container-fluid">
                <%@include file="/partials/actionErrors.jsp" %>
                <tiles:insertAttribute name="content" />
            </div>
        </div>
    </div>
</body>
</html>
