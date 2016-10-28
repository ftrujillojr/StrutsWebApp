<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData New</h1>
<s:form namespace="/emailData" action="" method="GET">
    <button id="cancel_new_emailData" type="submit" class="btn btn-secondary">Cancel New</button>
</s:form>

<!--<h2><s:property value="restMethod"></s:property></h2>-->

<s:form class="form-horizontal" method="POST" namespace="/emailData" action="">

    <%@include file="/emailData/common_emailData.jsp" %>
    
    <div class="form-group">
        <div class="col-xs-12 col-sm-9 col-sm-offset-3">
            <button id="submit" type="submit" class="btn btn-primary">Create Email Submit</button>
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



