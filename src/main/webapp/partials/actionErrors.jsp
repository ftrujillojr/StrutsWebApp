<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:if test="hasActionErrors()">
    <s:actionerror theme="bootstrap"/>
</s:if>
<s:if test="hasActionMessages()">
    <s:actionmessage theme="bootstrap"/>
</s:if>
<div>
    <div>
        <ul>
            <li>Error1</li>
            <li>Error2</li>
            <li>Error3</li>
        </ul>                 
    </div>
</div>    