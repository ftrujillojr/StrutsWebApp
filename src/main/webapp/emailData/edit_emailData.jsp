<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData Edit!</h1>
<h2><s:property value="%{restMethod}"></s:property></h2>
<s:form namespace="/emailData" action="%{emailData.id}" method="GET">
    <button id="cancelButton" type="submit" class="btn btn-secondary">Cancel Edit</button>
</s:form>

<s:form class="form-horizontal" namespace="/emailData" action="%{emailData.id}" method="POST">
    <s:hidden name="hidden_override_method" value="PUT"></s:hidden>

    <%@include file="/emailData/common_emailData.jsp" %>

    <div class="form-group">
        <div class="col-xs-12 col-sm-9 col-sm-offset-3">
            <button id="updateButton" type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
</s:form>

<script type="text/javascript">

    $(document).ready(function ($) {


    }); // end ready

    $(window).load(function () {
        // your code here.
    });
</script>



