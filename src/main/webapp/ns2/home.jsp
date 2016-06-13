<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>/ns2/Home (tiles)</h1>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/dude">
    <div class="form-group">
        <div class="col-xs-4 col-xs-offset-1">
            <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>    
</form>