<%-- 
    Document   : dude
    Created on : May 20, 2016, 4:34:04 PM
    Author     : ftrujillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>DUDE!</h1>

<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/home">
    
    <div class="form-group">
        <div class="col-xs-2">
        </div>
        <div class="col-xs-4">
            <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
        </div>
        <br>
    </div>    

</form>
