<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- This allows HTML5 --%>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%-- if using other 3rd party CSS, then load here --%>
<%--<link type="text/css" rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.css">--%>

<%-- jquery loaded first, then jquery-ui --%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>--%>

<%-- This initializes bootstrap plugin. You MUST have jquery defined prior to this tag. --%>
<sb:head />

<%-- Load up your project css/js last.  Notice that I use the value stack to get the web context --%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/project.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/generic.js"></script>
    