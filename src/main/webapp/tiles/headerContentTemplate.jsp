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
        <div class="wrapper">
            <div id="header" class="header">
                <tiles:insertAttribute name="header" />
            </div>
            <div class="main">
                <div id="content" class="box content">
                    <div style="visibility: hidden; margin: 0px;">My Hidden Text to align table-cell</div>                    
                    <div style="margin-top: -45px;">
                        <%@include file="/partials/actionErrors.jsp" %>
                        <tiles:insertAttribute name="content" />
                    </div>                    
                </div>
            </div>
            <div id="footer" class="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>
