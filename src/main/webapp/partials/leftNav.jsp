<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="accordion" id="leftMenu">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#">
                <span class="glyphicon glyphicon-home pull-left"></span> Home
            </a>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle align-middle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseTwo">
                <i class="icon-th"></i> Layout
            </a>
        </div>
        <div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li>This is one</li>
                    <li>This is two</li>
                    <li>This is Three</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseThree">
                <i class="icon-th-list"></i> UI Components
            </a>
        </div>
        <div id="collapseThree" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li>This is one</li>
                    <li>This is two</li>
                    <li>This is Three</li>
                </ul>                 
            </div>
        </div>
    </div>
</div>
