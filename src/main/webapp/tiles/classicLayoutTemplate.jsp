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
                    <%@include file="/partials/actionErrors.jsp" %>
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
