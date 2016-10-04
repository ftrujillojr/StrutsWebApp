<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="application/json; charset=UTF-8" %>
<% response.setStatus(500); %>
{
    "status": 500,
    "message": "<s:property value="%{exception.message}"/>",
    "details": "<s:property value="exceptionStack" />"
}