<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>exception.jsp</title>
    </head>
    <body>
        <%@include file="/partials/actionErrors.jsp" %>

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
    