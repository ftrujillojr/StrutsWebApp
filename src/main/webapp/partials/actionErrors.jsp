<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:if test="hasActionErrors()">
    <div class="bg-danger">
        <s:actionerror/>
    </div>
</s:if>
<s:if test="hasActionMessages()">
    <div class="bg-warning">
        <s:actionmessage/>
    </div>
</s:if>
