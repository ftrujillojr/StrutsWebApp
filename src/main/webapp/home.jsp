<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>home</title>
    </head>
    <body>

        <%-- YOUR HTML HERE --%>

        <%-- 
             STRUTS2 tags  => https://struts.apache.org/docs/tag-reference.html
             BOOTSTRAP css => http://bootstrapdocs.com/v3.3.5/docs/css/ 
                              http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/bootstrap-forms.php
        --%>

        <div class="container-fluid text-left">
            <div class="row">
                <div id="topLayout" class="col-xs-12">Header
                </div>
            </div>
            <div class="row">
                <div id="leftLayout" class="col-sm-2">
                    <%@include file="/partials/leftNav.jsp" %>
                </div>
                <div id="rightLayout" class="col-xs-12 col-sm-10">
                    <%@include file="/partials/actionErrors.jsp" %>
                
                    <h1>Horizontal Form layout</h1>
                    <!-- STEP1 form class form-horizontal -->
                    <form class="form-horizontal">
                        <!-- STEP2 wrap labels and form controls in div with class form-group -->
                        <div class="form-group">
                            <!-- STEP3 use class control-label on label and  class form-control on form inputs -->
                            <label for="email" class="control-label col-xs-2 text-right">Email address:</label>
                            <div class="col-xs-4">
                                <input type="email" class="form-control" id="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pwd" class="control-label col-xs-2 text-right">Password:</label>
                            <div class="col-xs-4">
                                <input type="password" class="form-control" id="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-2">
                            </div>
                            <div class="col-xs-4">
                                <div class="checkbox">
                                    <label><input id="debug" type="checkbox">Debug?</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-2">
                            </div>
                            <div class="col-xs-4">
                                <button id="reset" type="reset" class="btn btn-default">Reset</button>
                                <button id="submit" type="submit" class="btn btn-default">Submit</button>
                            </div>
                            <br>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div id="bottomLayout" class="col-xs-12">Footer
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(document).ready(function ($) {
                // your code here.
                // alert("javscript works!!");
//                $(".form-horizontal .control-label").addClass("text-left");
//                
//                $("#resetBtn").on("click", function(event){
//                    event.preventDefault();
//                    $("#myForm1").clearForm();
//                });

            });

            $(window).load(function () {
                // your code here.
            });
        </script>
    </body>
</html>

