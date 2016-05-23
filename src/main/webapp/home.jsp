<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>/Home (tiles)</h1>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/home">
    <div class="col-xs-4 col-xs-offset-2">
        <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
        <button id="submit" type="submit" class="btn btn-primary">Submit</button>
    </div>    
</form>

<script type="text/javascript">
    $(document).ready(function ($) {
        // your code here.
        alert("Woo Hoo from /home!!");
    });

    $(window).load(function () {
        // your code here.
    });
</script>



