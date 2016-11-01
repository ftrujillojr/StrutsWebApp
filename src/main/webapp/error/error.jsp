<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>Errors</title>
    </head>
    <body>
        <%@include file="/partials/actionErrors.jsp" %>
        <h1>There were errors</h1>
        <s:form class="form-horizontal" namespace="/" action="" method="GET">
            <div class="form-group">
                <div class="col-xs-12 col-sm-9 col-sm-offset-0">
                    <button id="HomeButton" type="submit" class="btn btn-primary">Home</button>
                </div>
            </div>
        </s:form>
        <script type="text/javascript">
            $(document).ready(function ($) {
                // your code here.
                // alert("javscript works!!");
                $("body").css({"padding-top": "5px"});
            });

            $(window).load(function () {
                // your code here.
            });
        </script>
    </body>
</html>
