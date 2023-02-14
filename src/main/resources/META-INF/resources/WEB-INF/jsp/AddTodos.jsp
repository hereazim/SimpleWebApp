<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Enter Todo Details</h1><br>
<form:form method="post" modelAttribute="todo">

<fieldset class="mb-3">
<form:label path="description">Description</form:label>
<form:input type="text" path="description" required="required"/><br>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<fieldset class="mb-3">
<form:label path="targetDate">Target Date</form:label>
<form:input type="text" path="targetDate" required="required"/><br>
<form:errors path="targetDate" cssClass="text-warning"/>
</fieldset>

<form:input type="hidden" path="id"/><br>
<form:input type="hidden" path="done"/><br>
<br><input type="submit" class="btn btn-success" /><br><br>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>