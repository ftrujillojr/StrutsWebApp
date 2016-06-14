<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="accordion" id="leftMenu">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home pull-left"></span> Home</a>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle align-middle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseTwo">
                <i class="icon-th"></i>Example Links
            </a>
        </div>
        <div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/ns2/dude">Show /ns2/Dude</a></li>
                    <li><a href="${pageContext.request.contextPath}/ns2/home">Show /ns2/Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/home">Show /</a></li>
                    <li><a href="${pageContext.request.contextPath}/css/project.css" target="_new">Show CSS new tab</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
