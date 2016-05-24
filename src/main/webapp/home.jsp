<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>/Home (tiles)</h1>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/home">
    <div class="col-xs-4 col-xs-offset-2">
        <button id="test" type="button" class="btn btn-secondary" onclick="javascript:PostExample.execAjax();">Test jQuery Ajax</button>
        <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
        <button id="submit" type="submit" class="btn btn-primary">Submit</button>
    </div>    
</form>

<script type="text/javascript">
    $(document).ready(function ($) {

        PostExample = {
            jqxhr: null,
            payLoad: function () {
                var emailData = {
                    email: "ftrujillojr@gmail.com",
                    firstName: "Francis",
                    lastName: "Trujillo"
                }
                return "emailData:" + JSON.stringify(emailData);
            },
            execAjax: function () {
                PostExample.jqxhr = $.ajax({
                    async: true, // defaults to true
                    cache: false, //defaults to true
                    method: "POST",
                    url: "${pageContext.request.contextPath}/home",
                    contentType: "application/json;charset=UTF-8",
                    data: PostExample.payLoad(),
                    dataType: 'json', // json, xml, script, jsonp, html, or text
                    timeout: 5000 // in milliseconds
//            username: "",
//            password: ""
                }).done(function(response) {  // SUCCESS
                    alert(response);
                }).fail(function(jqXHR, textStatus) { // ERROR
                    var errMsg = "ERROR: " + textStatus;
                    alert(errMsg); // Do something with errMsg
                }).always(function(jqXHR, textStatus) { // COMPLETE
                    // run after done() or fail()
                });
            }
        }

    });

    $(window).load(function () {
        // your code here.
    });
</script>



