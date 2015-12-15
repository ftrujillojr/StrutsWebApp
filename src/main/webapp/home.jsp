<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
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

        <div class="container-fluid text-center">
            <div class="row content">
                <div class="hidden-xs col-sm-1 col-md-1 col-lg-1 sidenav">
                    <p>SIDE NAV</p>
                </div>

                <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
                    
                    <%-- This is the html produced from the struts2 tag.  View source.
                         <form id="myform1" name="myform1" action="/ExampleWebApp/index" method="post" enctype="multipart/form-data" class="form-horizontal"> 
                    
                         theme overrides struts.properties
                    --%>
                    <s:form action="index"
                            namespace=""
                            method="post"
                            id="myForm1"
                            enctype="multipart/form-data" 
                            theme="bootstrap"
                            cssClass="form-horizontal"
                            label="A sample horizontal Form" >
                        
                        <s:a id="resetBtn" cssClass="btn btn-default" href="#">Reset</s:a>
                        
                        <s:textfield
                            label="Name"
                            name="name"
                            tooltip="Enter your Name here"/>
                        
                        <div class="has-error">
                            <s:textfield
                                label="Textfield with Error"
                                name="error" 
                                value=""/>
                        </div>
                        
                        <s:textarea
                            tooltip="Enter your Biography"
                            label="Biography"
                            name="bio"
                            cols="20"
                            rows="3"/>

                        <s:select
                            tooltip="Choose Your Favourite Color"
                            label="Favorite Color"
                            list="{'Red', 'Blue', 'Green'}"
                            name="favouriteColor"
                            emptyOption="true"
                            headerKey="None"
                            headerValue="None"/>

                        <s:checkboxlist
                            tooltip="Choose your Friends"
                            cssClass="text-left"
                            label="Friends"
                            list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                            name="friends"/>

                        <s:checkboxlist
                            tooltip="Checkboxes with inline position"
                            labelposition="inline"
                            label="Friends Inline"
                            list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                            name="friendsInline"/>

                        <s:radio
                            tooltip="Choose your Best Friend"
                            cssClass="text-left"
                            label="Best Friend"
                            list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                            name="bestFriend"
                            cssErrorClass="foo"/>

                        <s:radio
                            tooltip="Radio Buttons with inline position"
                            label="Best Friend Inline"
                            labelposition="inline"
                            list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                            name="bestFriend"
                            cssErrorClass="foo"/>

                        <s:checkbox
                            tooltip="Confirmed that your are Over 18"
                            label="Age 18+"
                            name="legalAge"/>


                        <s:doubleselect
                            tooltip="Choose Your State"
                            label="State"
                            name="region" list="{'North', 'South'}"
                            value="'South'"
                            doubleValue="'Florida'"
                            doubleList="top == 'North' ? {'Oregon', 'Washington'} : {'Texas', 'Florida'}"
                            doubleName="state"
                            headerKey="-1"
                            headerValue="---------- Please Select ----------"
                            emptyOption="true"/>

                        <s:file
                            tooltip="Upload Your Picture"
                            label="Picture"
                            name="picture"/>

                        <%-- optiontransferselect widget produces a StrutsUtil is not defined javascript error.  
                             Add this line to your head section.  See partials/headSection.jsp.
                        
                             <script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
                        --%>
                        <s:optiontransferselect
                            tooltip="Select Your Favourite Cartoon Characters"
                            label="Favourite Cartoons Characters"
                            name="leftSideCartoonCharacters"
                            leftTitle="Left Title"
                            rightTitle="Right Title"
                            list="{'Popeye', 'He-Man', 'Spiderman'}"
                            multiple="true"
                            headerKey="headerKey"
                            headerValue="--- Please Select ---"
                            emptyOption="true"
                            doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
                            doubleName="rightSideCartoonCharacters"
                            doubleHeaderKey="doubleHeaderKey"
                            doubleHeaderValue="--- Please Select ---"
                            doubleEmptyOption="true"
                            doubleMultiple="true"/>

                        <s:textarea
                            label="Your Thougths"
                            name="thoughts"
                            tooltip="Enter your thoughts here"/>
                        
                        <s:submit cssClass="btn btn-primary"/>
                    </s:form>

                </div>
            </div>
        </div>


        <%@include file="/partials/bodySection.jsp" %>
        <script type="text/javascript">
            $(document).ready(function ($) {
                // your code here.
                // alert("javscript works!!");
                $(".form-horizontal .control-label").addClass("text-left");
                
                $("#resetBtn").on("click", function(event){
                    event.preventDefault();
                    $("#myForm1").clearForm();
                });
                
            });

            $(window).load(function () {
                // your code here.
            });
        </script>
    </body>
</html>

    