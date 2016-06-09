<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>/ns2/dude (tiles)</h1>

<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/home">

    <div class="form-group">
        <label for="email" class="control-label col-xs-2 text-right">Email address:</label>
        <div class="col-xs-4">
            <input type="email" name="email" class="form-control" id="email">
        </div>
    </div>
    
    <div class="form-group">
        <label for="pwd" class="control-label col-xs-2 text-right">Password:</label>
        <div class="col-xs-4">
            <input type="password" name="password" class="form-control" id="password">
        </div>
    </div>

    <div class="form-group">
        <label for="select_lang" class="control-label col-xs-2 text-right">Software Language:</label>
        <div class="col-xs-4">
            <select id="select_lang" name="progLang" class="form-control">
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
        <label class="col-sm-2 control-label text-right">Best Friend<i class="glyphicon glyphicon-info-sign s2b_tooltip" title="Choose your Best Friend"></i>
        </label>    
        <div class="col-sm-4 controls">
            <div class="radio">
                <label for="bestFriend-1" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-1" value="Wes"/>Wes</label>
            </div>
            <div class="radio">
                <label for="bestFriend-2" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-2" value="Patrick"/>Patrick</label>
            </div>
            <div class="radio">
                <label for="bestFriend-3" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-3" value="Jason"/>Jason</label>
            </div>
            <div class="radio">
                <label for="bestFriend-4" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-4" value="Jay"/>Jay</label>
            </div>
            <div class="radio">
                <label for="bestFriend-5" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-5" value="Toby"/>Toby</label>
            </div>
            <div class="radio">
                <label for="bestFriend-6" class="">
                    <input type="radio" name="bestFriend" id="bestFriend-6" value="Rene"/>Rene</label>
            </div>
        </div>
    </div>
    
    <div class="form-group">
        <div class="col-xs-4 col-xs-offset-2">
            <div class="checkbox">
                <label><input id="debug" type="checkbox">Debug?</label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-4 col-xs-offset-2">
            <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
    
</form>
