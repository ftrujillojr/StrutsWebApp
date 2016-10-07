<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData New</h1>
<s:form namespace="/emailData" action="" method="GET">
    <button id="cancel_new_emailData" type="submit" class="btn btn-secondary">Cancel New</button>
</s:form>

<s:form class="form-horizontal" method="POST" namespace="/emailData" action="">
    <div class="form-group">
        <label for="email" class="control-label col-xs-12 col-sm-3 text-left">Email:</label>
        <div class="col-xs-3 col-sm-4">
            <input type="email" name="email" class="form-control" id="email">
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="control-label col-xs-12 col-sm-3 text-left">FirstName:</label>
        <div class="col-xs-3 col-sm-4">
            <input type="text" name="firstName" class="form-control" id="firstName">
        </div>
    </div>
    <div class="form-group">
        <label for="lastName" class="control-label col-xs-12 col-sm-3 text-left">LastName:</label>
        <div class="col-xs-3 col-sm-4">
            <input type="text" name="lastName" class="form-control" id="lastName">
        </div>
    </div>

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



