<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>404.jsp</title>
    </head>
    <body>
        <%@include file="/partials/actionErrors.jsp" %>
        <h1>404 Not found</h1>

        <h4>Exception Name: <s:property value="exception" /> </h4>

        <h4>Exception Details: <s:property value="exceptionStack" /></h4> 

        <p>You must provide your own ERROR content here</p>

        <%@include file="/partials/bodySection.jsp" %>
        <script type="text/javascript">
            $(document).ready(function ($) {
                // your code here.
                // alert("javscript works!!");
            });

            $(window).load(function () {
                // your code here.
            });
        </script>
    </body>
</html>
