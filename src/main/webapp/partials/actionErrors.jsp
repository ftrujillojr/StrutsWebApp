<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:if test="hasActionErrors()">
<!--    <div class="bg-danger">
        <s:actionerror/>
    </div>-->
    <table id="actionErrorTable" align="center" width="100%">
        <s:iterator value="actionErrors">
            <tr>
                <td class="bg-danger action_error_padding">
                    <s:property escape="false"/>
                </td>
            </tr>
        </s:iterator>  
    </table>
</s:if>
<s:if test="hasActionMessages()">
<!--    <div class="bg-warning">
        <s:actionmessage/>
    </div>-->
    <table id="actionMessageTable" align="center" width="100%">
        <s:iterator value="actionMessages">
            <tr>
                <td class="bg-warning action_message_padding">
                    <s:property escape="false"/>
                </td>
            </tr>
        </s:iterator>  
    </table>
</s:if>
