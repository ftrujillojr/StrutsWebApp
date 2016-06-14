<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>/Home (tiles)</h1>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/home">
    <div class="form-group">
        <div class="col-xs-4 col-xs-offset-1">
        <!--<button id="testJqueryAjax" type="button" class="btn btn-secondary" onclick="javascript:homeJson_POST_EXAMPLE('${pageContext.request.contextPath}');">Test jQuery Ajax</button>-->
            <button id="testJqueryAjax" type="button" class="btn btn-secondary">Test jQuery Ajax</button>
            <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>


<script type="text/javascript">

    $(document).ready(function ($) {
        // your code here.

        $('#testJqueryAjax').on('click', function (event) {
            event.preventDefault();
            homeJson_POST_EXAMPLE("${pageContext.request.contextPath}");
        }); // end onClick

    }); // end ready

    $(window).load(function () {
        // your code here.
    });
</script>



