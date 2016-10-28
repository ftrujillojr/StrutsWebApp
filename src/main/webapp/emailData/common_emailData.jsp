<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<s:if test="%{restMethod.equals('show')}">
    <s:set var="ROflag">true</s:set>
    <s:else>
        <s:set var="ROflag">false</s:set>
    </s:else>
</s:if>

<s:if test="%{restMethod.equals('show') || restMethod.equals('edit')}">
    <div class="form-group">
        <label for="id" class="control-label col-xs-12 col-sm-3 text-left">Id*:</label>
        <div class="col-xs-3 col-sm-4">
            <s:textfield type="id" name="emailData.id" class="form-control" id="id" disabled="true"/>
            <s:fielderror class="bg-danger" fieldName="emailData.id"/>
        </div>
    </div>
</s:if>

<div class="form-group">
    <label for="email" class="control-label col-xs-12 col-sm-3 text-left">Email*:</label>
    <div class="col-xs-3 col-sm-4">
        <s:textfield type="email" name="emailData.email" class="form-control" id="email" disabled="#ROflag"/>
        <s:fielderror class="bg-danger" fieldName="emailData.email"/>
    </div>
</div>
<div class="form-group">
    <label for="firstName" class="control-label col-xs-12 col-sm-3 text-left">FirstName*:</label>
    <div class="col-xs-3 col-sm-4">
        <s:textfield type="text" name="emailData.firstName" class="form-control" id="firstName" disabled="#ROflag"/>
        <s:fielderror class="bg-danger" fieldName="emailData.firstName"/>
    </div>
</div>
<div class="form-group">
    <label for="lastName" class="control-label col-xs-12 col-sm-3 text-left">LastName*:</label>
    <div class="col-xs-3 col-sm-4">
        <s:textfield name="emailData.lastName" type="text" class="form-control" id="lastName" disabled="#ROflag"/>
        <s:fielderror class="bg-danger" fieldName="emailData.lastName"/>
    </div>
</div>
<div class="form-group">
    <label for="phone" class="control-label col-xs-12 col-sm-3 text-left">Phone:</label>
    <div class="col-xs-3 col-sm-4">
        <s:textfield name="emailData.phone" type="text" class="form-control" id="phone" disabled="#ROflag"/>
        <s:fielderror class="bg-danger" fieldName="emailData.phone"/>
    </div>
</div>
<div class="form-group">
    <label for="age" class="control-label col-xs-12 col-sm-3 text-left">Age:</label>
    <div class="col-xs-3 col-sm-4">
        <s:textfield name="emailData.age" type="text" class="form-control" id="age" disabled="#ROflag"/>
        <s:fielderror class="bg-danger" fieldName="emailData.age"/>
    </div>
</div>
