<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:if test="hasActionErrors()">
    <s:actionerror theme="bootstrap"/>
</s:if>
<s:if test="hasActionMessages()">
    <s:actionmessage theme="bootstrap"/>
</s:if>
