<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<table class="table table-striped">
		<caption><spring:message code="todo.caption" /></caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Completed?</th>
				<th></th>
			</tr>
		
		</thead>
		<tbody>	
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
				<td>${todo.done}</td>
				<td><a class="btn btn-success" href="/update-todo?id=${todo.id}"> Update </a></td>
				<td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}"> Delete </a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- for(Todo todo: todos) -->
	<%-- <c:forEach items="${todos}" var="todo">
		${todo.id} ${todo.desc} ${todo.user}<br>
	</c:forEach> --%>
	<!-- this model used the to string method - java expression language -->
	
	<div>
		<a class="btn btn-success" href="/add-todo"> Add </a>
	</div>
<!-- 		<div class = "gallery">
		<img alt="" src="/resources/images/family.png">		
	</div> -->
</div>

<%@ include file="common/footer.jspf" %>


