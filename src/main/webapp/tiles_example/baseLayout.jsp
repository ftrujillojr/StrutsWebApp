<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <tiles:insertAttribute name="banner" /><br/>
        <hr/>
        <tiles:insertAttribute name="menu" /><br/>
        <hr/>
        <tiles:insertAttribute name="body" /><br/>
        <hr/>
        <tiles:insertAttribute name="footer" /><br/>
    </body>      
</html>
