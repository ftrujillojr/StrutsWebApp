<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/partials/headSection.jsp" %>
        <title>home</title>

    </head>
    <body>
        <%@include file="/partials/actionErrors.jsp" %>

        <%-- YOUR HTML HERE --%>

        <%-- 
             STRUTS2 tags  => https://struts.apache.org/docs/tag-reference.html
             BOOTSTRAP css => http://bootstrapdocs.com/v3.3.5/docs/css/ 
        --%>

        <div class="container-fluid text-left">
            <div class="row content">
                <div class="hidden-xs col-sm-2 col-md-2 col-lg-2 sidenav">
                    <%@include file="/partials/leftNav.jsp" %>
                </div>

                <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                    <div class="row content">
                        <div class="col-md-10">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="email">Email address:</label>
                                    <input type="email" class="form-control" id="email">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" id="pwd">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                    </div>
                    <div class="row content">
                        <div class="col-md-10">
                            <form class="form-inline">
                                <div class="form-group">
                                    <label for="email">Email address:</label>
                                    <input type="email" class="form-control" id="email">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" id="pwd">
                                </div>
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember me</label>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                    </div>

                    <h3>Buttons - also use  btn-lg, btn-sm, btn-xs classes </h3>
                    <p>
                        <button type="button" class="btn btn-default">Default</button>
                        <button type="button" class="btn btn-primary">Primary</button>
                        <button type="button" class="btn btn-success">Success</button>
                        <button type="button" class="btn btn-xs btn-info">Info</button>
                        <button type="button" class="btn btn-sm btn-warning">Warning</button>
                        <button type="button" class="btn btn-lg btn-danger">Danger</button>
                        <button type="button" class="btn btn-link">Link</button>
                    </p>
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#">Home</a></li>
                        <li role="presentation"><a href="#">Profile</a></li>
                        <li role="presentation"><a href="#">Messages</a></li>
                    </ul>
                    <ul class="nav nav-pills" role="tablist">
                        <li role="presentation" class="active"><a href="#">Home</a></li>
                        <li role="presentation"><a href="#">Profile</a></li>
                        <li role="presentation"><a href="#">Messages</a></li>
                    </ul>

                    <div class="alert alert-success" role="alert">
                        <strong>Well done!</strong> You successfully read this important alert message.
                    </div>
                    <div class="alert alert-info" role="alert">
                        <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
                    </div>
                    <div class="alert alert-warning" role="alert">
                        <strong>Warning!</strong> Best check yo self, you're not looking too good.
                    </div>
                    <div class="alert alert-danger" role="alert">
                        <strong>Oh snap!</strong> Change a few things up and try submitting again.
                    </div>


                    <div class="col-md-4">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td rowspan="2">1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@TwBootstrap</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-7">
                        <table class="table table-condensed">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>


        <%@include file="/partials/bodySection.jsp" %>
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

