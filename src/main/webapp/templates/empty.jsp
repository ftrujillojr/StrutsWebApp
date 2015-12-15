<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>empty template</title>
    </head>
    <body>
        <%@include file="/partials/actionErrors.jsp" %>

        <%-- 
             STRUTS2 tags  => https://struts.apache.org/docs/tag-reference.html
             BOOTSTRAP css => http://bootstrapdocs.com/v3.3.5/docs/css/ 
        --%>

        <div class="container-fluid text-center">
            <div class="row content">
                <div class="hidden-xs col-sm-1 col-md-1 col-lg-1 sidenav">
                    <p>SIDE NAV</p>
                </div>

                <%-- YOUR HTML HERE --%>

                <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                    <p>MAIN CONTENT</p>
                </div>
            </div>
        </div>


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

    