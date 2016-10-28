<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData Show</h1>
<s:form namespace="/emailData" action="" method="GET">
    <button id="cancelButton" type="submit" class="btn btn-secondary">Cancel Show</button>
</s:form>
    
<s:form class="form-horizontal" namespace="/emailData" action="%{emailData.id}/edit" method="GET">
    <%@include file="/emailData/common_emailData.jsp" %>

    <div class="form-group">
        <div class="col-xs-12 col-sm-9 col-sm-offset-3">
            <button id="editButton" type="submit" class="btn btn-primary">Edit</button>
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



