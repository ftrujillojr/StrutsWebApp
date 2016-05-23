<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/project.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/generic.js"></script>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <div class="container-fluid text-left">
            <div class="row">
                <div id="topLayout" class="col-xs-12">
                    <tiles:insertAttribute name="topLayout" />
                </div>
            </div>
            <div class="row">
                <div id="leftLayout" class="col-xs-12 hidden-sm hidden-md col-lg-2">
                    <tiles:insertAttribute name="leftLayout" />
                </div>
                <div id="rightLayout" class="col-xs-12 col-sm-12 col-md-12 col-lg-10">
                    <s:if test="hasActionErrors()">
                        <s:actionerror/>
                    </s:if>
                    <s:if test="hasActionMessages()">
                        <s:actionmessage/>
                    </s:if>
                    <tiles:insertAttribute name="rightLayout" />
                </div>
            </div>
            <div class="row">
                <div id="bottomLayout" class="col-xs-12">
                    <tiles:insertAttribute name="bottomLayout" />
                </div>
            </div>
        </div>
    </body>
</html>
