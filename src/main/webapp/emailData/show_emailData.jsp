<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData Show!</h1>
<h2><s:property value="%{restMethod}"></s:property></h2>
<s:form class="form-horizontal" namespace="/emailData" action="%{emailData.id}/edit" method="GET">
    <%@include file="/emailData/common_emailData.jsp" %>
    <div class="form-group">
        <div class="col-xs-12 col-sm-9 col-sm-offset-3">
            <button id="editButton" type="submit" class="btn btn-primary">Edit</button>
            <button id="indexButton" type="button" class="btn btn-secondary">List</button>
            <button id="deleteButton" type="button" class="btn btn-danger">Delete</button>
        </div>
    </div>
</s:form>

<s:form id="indexForm" namespace="/emailData" action="" method="GET">
</s:form>

<s:form id="deleteForm" namespace="/emailData" action="%{emailData.id}" method="POST">
    <s:hidden name="hidden_override_method" value="DELETE"></s:hidden>
</s:form>

<script type="text/javascript">

    $(document).ready(function ($) {

        $('#indexButton').on('click', function (event) {
            event.preventDefault();
            $("#indexForm").submit();
        });

        $('#deleteButton').on('click', function (event) {
            event.preventDefault();
            $("#deleteForm").submit();
        });

    }); // end ready

    $(window).load(function () {
        // your code here.
    });
</script>



