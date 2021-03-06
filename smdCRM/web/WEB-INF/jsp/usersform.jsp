<%-- 
    Document   : usersform
    Created on : Feb 7, 2017, 6:28:10 PM
    Author     : sethd
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Users > Add Users</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    
        <div class="w3-container w3-blue">
            <h2>User</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="users">
            <div class="w3-padding-8">
                <label><b>Username</b></label>
                <form:input path="username" cssClass="w3-input w3-border"  />
                <form:errors path="username" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Password</b></label>
                <form:password path="password" cssClass="w3-input w3-border"  />
                <form:errors path="password" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Role</b></label>
                <form:select multiple="true" path="role" cssClass="w3-select w3-border">
                    <form:options items="${users.rolemap}"  />
                </form:select>            
            </div>
            <div class="w3-padding-8">
                <%--                
                <label><b>Enabled</b></label>
                <form:select path="enable" cssClass="w3-select w3-border">
                    <form:options items="${users.enable}"  />
                </form:select>
            </div>
--%>
            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    

</div>

<%@ include file="theme/footer.jsp" %>