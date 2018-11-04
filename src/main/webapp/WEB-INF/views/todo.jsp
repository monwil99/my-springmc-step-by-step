<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class = "container">
<h1>Add a Todo</h1>
	<!-- We are now using the spring tag form replacing <form> 
		form binding - tying up form elements to a bean
		command object -commandName="todo"-->
	<form:form method="post" commandName="todo" >
		<form:hidden path="id"/>

		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control" required="required"/>
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control" required="required"/>
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<input class="btn btn-success" type="submit" value="Submit"/>
		
	<!-- if there is no action it would redirect to the same action where it came in -->
	
	
	<!-- bootstrap - form-group, form-control, container,table, table-striped
	btn btn-danger, btn btn-success
	 -->
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>