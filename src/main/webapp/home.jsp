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
//        setWebContext("${pageContext.request.contextPath}");

        PostExample = {
            jqxhr: null,
            payLoad: function () {
                var jsonDataObj = {
                    emailData: {// This MUST be the same object name in the controller.
                        email: "ftrujillojr@gmail.com",
                        firstName: "Francis",
                        lastName: "Trujillo",
                        dude: "Not funny!" // This is not an attr in Controller object emailData
                    }
                };
                return JSON.stringify(jsonDataObj);
            },
            execAjax: function () {
                PostExample.jqxhr = $.ajax({
                    async: true, // defaults to true
                    cache: false, //defaults to true
                    method: "POST", // GET, POST, PUT, PATCH, DELETE
                    url: "${pageContext.request.contextPath}/homeJson", // Struts2 route
                    contentType: "application/json", // payload type
                    dataType: 'json', // Accept <=  json, xml, script, jsonp, html, or text
                    data: PostExample.payLoad(), // string version of Json object
                    beforeSend: function (jqXHR, settings) {
                        //jqXHR.setRequestHeader("X-HTTP-Method-Override", "PUT"); // Override method
                        jqXHR.url = settings.url; // SAVE URL for these methods => done,fail, always.
                        jqXHR.method = settings.method; // same for method.
                    },
                    global: false, // Do not fire global handlers if false
                    timeout: 5000 // in milliseconds
//            username: "",
//            password: ""
                }).done(function (data, textStatus, jqXHR) { // Pre jQuery 1.9, this was ,success()
                    
                    var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
                    var jsonObj = JSON.parse(jsonString); // If you need the object, then here you go.
                    jsonString = JSON.stringify(jsonObj, null, 4);  // Format pretty print
                    
                    alert("SUCCESS: \n" + jsonString);
                    
                }).fail(function (jqXHR, textStatus, errorThrown) { // Pre jQuery 1.9, this was ,error()
                    
                    var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
                    var jsonObj = JSON.parse(jsonString);
                    jsonString = JSON.stringify(jsonObj, null, 4);  // Format pretty print
                    
                    var errMsg =
                            "      ERROR: " + errorThrown +
                            "\n        URL: " + jqXHR.url +
                            "\n     METHOD: " + jqXHR.method +
                            "\n     STATUS: " + jqXHR.status +
                            "\n   RESPONSE: " + jsonObj.message;

                    console.log(errMsg);
                    console.log(jsonString);
                    alert(errMsg);
                }).always(function (jqXHR, textStatus) {      // Pre jQuery 1.9, this was .complete()
                    // run after done() or fail()
                });
            }
        };

    });

    $(window).load(function () {
        // your code here.
    });
</script>



