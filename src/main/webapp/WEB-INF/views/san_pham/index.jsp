<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>San Pham</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <h2 style="text-align: center">Danh sách sản phẩm</h2>
    <div class="row">
        <div class="col-6 col-md-6 col-sm-6">
            <div class="mb-3">
                <form:form action="/san-pham/search" modelAttribute="search" method="post">
                   <form:input path="keyword" />
                    <button type="submit" class="btn btn-success">Search</button>
                </form:form>
            </div>


        </div>
        <div class="col-6 col-md-6 col-sm-6">
            <a href="/san-pham/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i> Add</a>
            <br>
        </div>
    </div>
    <br>
    <a href="/san-pham/sort" class="btn btn-success">Sort</a>
    <table class="table table-bordered">
        <thead class="table table-danger">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.content}" varStatus="i" var="sp">
            <tr>
                <td>${i.count}</td>
                <td>${sp.maSP}</td>
                <td>${sp.tenSP}</td>
                <td>
                    <a href="/san-pham/view-update/${sp.id}" class="btn btn-danger"><i class="bi bi-pencil-square"></i>Detail</a>
                    <a href="/quan-ly-san-pham/view-add/${sp.id}" class="btn btn-danger"><i class="bi bi-pencil-square"></i>Quản
                        lý thuộc tính</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation example" class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="/san-pham/hien-thi?p=${page.number-1}"><<</a></li>
                <li class="page-item"><a class="page-link" href="/san-pham/hien-thi?p=${page.number+1}">>></a></li>
            </ul>
        </nav>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>