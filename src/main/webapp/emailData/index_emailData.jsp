<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>EmailData index</h1>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ns2/home">
    <div class="form-group">
        <div class="col-xs-12">
            <s:if test='emailDataList != null && emailDataList.size() > 0'>
                <table id="emailDataListTable" class = "table table-striped">
                    <caption>Striped Table Layout</caption>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>email</th>
                            <th>firstName</th>
                            <th>lastName</th>
                            <th>phone</th>
                            <th>age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="emailDataList" status="emailDataStatus">
                            <tr>
                                <td><s:property value="id"></s:property></td>
                                <td><s:property value="email"></s:property></td>
                                <td><s:property value="firstName"></s:property></td>
                                <td><s:property value="lastName"></s:property></td>
                                <td><s:property value="phone"></s:property></td>
                                <td><s:property value="age"></s:property></td>
                            </tr>
                        </s:iterator> 
                    </tbody>
                </table>
            </div>
        </s:if>
        <div class="col-xs-12">
            <button id="testJqueryAjax" type="button" class="btn btn-secondary">Test jQuery Ajax</button>
            <button id="reset" type="reset" class="btn btn-secondary">Reset</button>
            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>


<script type="text/javascript">

    $(document).ready(function ($) {
        // your code here.
        window.history.pushState("","", location.href);

        $('#testJqueryAjax').on('click', function (event) {
            event.preventDefault();
            emailData_POST_EXAMPLE("${pageContext.request.contextPath}");
        }); // end onClick
        
        
        $('#emailDataListTable').DataTable();

    }); // end ready

    $(window).load(function () {
        // your code here.
    });
</script>



