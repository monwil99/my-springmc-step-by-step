<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<spring:message code="welcome.message" /> ${bagoPangalan} and your password is ${bagoHudyat}<br/>
Now, you can <a href="/list-todos">manage your todos.</a>
</div>

<%@ include file="common/footer.jspf" %>