<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Welcome ${name}...!</h1>
<hr><br><br>
<h1>Your todos are : </h1>
<table class="table">
<tr>
<th>Id</th>
<th>Description</th>
<th>Target Date</th>
<th>Is Done?</th>
<th></th>
<th></th>
</tr>
<c:forEach items="${todos}" var="todo">

<tr>
<td>${todo.id}</td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td><a href="delete-todos?id=${todo.id}" class="btn btn-warning">Delete</a></td>
<td><a href="update-todos?id=${todo.id}" class="btn btn-success">Update</a></td>
</tr>
</c:forEach>
</table>
<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>