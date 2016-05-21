<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- YOUR HTML HERE --%>

<%-- 
     STRUTS2 tags  => https://struts.apache.org/docs/tag-reference.html
     BOOTSTRAP css => http://bootstrapdocs.com/v3.3.5/docs/css/ 
                      http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/bootstrap-forms.php

     This jsp file will be rendered in WEB-INF/tiles.xml
--%>

<h1>Horizontal Form layout</h1>
<!-- STEP1 form class form-horizontal -->


<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/dude">
    <!-- STEP2 wrap labels and form controls in div with class form-group -->

<!--    <div class="form-group">
         STEP3 use class control-label on label and  class form-control on form inputs 
        <label for="skill" class="control-label col-xs-2 text-right">Skill Level:</label>
        <div class="col-xs-4">
            <input type="range" class="form-control" id="skill" min="0" max="100" value="0">
        </div>
    </div>

    <div class="form-group">
        <label for="dt" class="control-label col-xs-2 text-right">Date:</label>
        <div class="col-xs-4">
              date, time, month, week 
            <input type="date" class="form-control" id="dt">
        </div>
        <label for="tm" class="control-label col-xs-2 text-right">Time:</label>
        <div class="col-xs-4">
              date, time, datetime, month, week 
            <input type="time" class="form-control" id="tm">
        </div>
    </div>

    <div class="form-group">
        <label for="polparty" class="control-label col-xs-2 text-right">Political Party:</label>
        <div class="col-xs-4">
            <label class="btn btn-secondary-outline">
                <input type="radio" class="form-control btn-1em" name="polparty" value="None" checked>None
            </label>
            <label class="btn btn-secondary-outline">
                <input type="radio" class="form-control btn-1em" name="polparty" value="Democrat">Democrat
            </label>
            <label class="btn btn-secondary-outline">
                <input type="radio" class="form-control btn-1em" name="polparty" value="Republican">Republican
            </label>
            <label class="btn btn-secondary-outline">
                <input type="radio" class="form-control btn-1em" name="polparty" value="3rd_party">3rd Party
            </label>
        </div>
    </div>

    <div class="form-group">
        <label for="shoesize" class="control-label col-xs-2 text-right">Shoe Size:</label>
        <div class="col-xs-4">
            <input type="number" class="form-control" id="shoesize" min="5" max="18" step="0.5" value="9">
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="control-label col-xs-2 text-right">Email address:</label>
        <div class="col-xs-4">
            <input type="email" class="form-control" id="email">
        </div>

        <label for="select_lang" class="control-label col-xs-2 text-right">Software Language:</label>
        <div class="col-xs-4">
            <select id="select_lang" class="form-control" required>
                <option value="">-- Choose Language --</option>
                <option value="java">Java</option>
                <option value="javascript">JavaScript</option>
                <option value="jquery">jQuery</option>
                <option value="cpp">C++</option>
                <option value="perl">Perl</option>
                <option value="ruby">Ruby</option>
                <option value="python">Python</option>
            </select>
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
    </div>-->

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

<div class="col-xs-10 col-xs-offset-2">
    <h3 class="text-center">Tab example</h3> 
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#tab1">Tab1</a></li>
        <li><a data-toggle="tab" href="#tab2">Tab2</a></li>
        <li><a data-toggle="tab" href="#tab3">Tab3</a></li>
    </ul>

    <div class="tab-content">
        <div id="tab1" class="tab-pane fade in active">
            <h3>Tab1 content</h3>
            <p>This is cool.</p>
        </div>
        <div id="tab2" class="tab-pane fade">
            <h3>Tab2 content</h3>
            <p>Bootstrap is very cool.</p>
        </div>
        <div id="tab3" class="tab-pane fade">
            <h3>Tab3 content</h3>
            <p>Wow!! Amazing!</p>
        </div>
    </div>
</div>

<div class="col-xs-8 col-xs-offset-2">
    <table class="table table-striped">
        <thead class="fjt-yellow">
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function ($) {
        // your code here.
        //alert("Woo Hoo Dude!!");
    });

    $(window).load(function () {
        // your code here.
    });
</script>
