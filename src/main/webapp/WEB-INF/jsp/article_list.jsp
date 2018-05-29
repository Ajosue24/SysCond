<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=devise-width, initial-scale=1">
    <title>Article List</title>
    <link th:href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"
          rel="stylesheet"/>


</head>
<body>
<div class="container"></div>
<h2>Article List</h2>
<table class="table table-striped">
    <thead>
    <th scope="row">#ID</th>
    <th scope="row">Title</th>
    <th scope="row">Category</th>
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
    </thead>
    <tbody>
<!--/*@thymesVar id="articleList" type="com.vv.model.Article"*/-->
<tr th:each="article : ${articleList}" >
    <td>${article.id}</td>
    <td>${article.title}</td>
    <td>${article.category}</td>

</tr>
    </tbody>
</table>
<%--<spring:url value="/article/addArticle/" var="addURL"/>--%>
<a class="btn btn-primary" href="${addURL}" role="button">Add new
    Article</a>

<script th:href="@{/webjars/jquery/3.3.1-1/jquery.min.js}"></script>
<script th:href="@{/webjars/bootstrap/4.1.0/js/bootstrap.min.js}"></script>
</body>
</html>