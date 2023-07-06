<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chất liệu</title>
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
</head>
<style>
    .form{
        margin-left: 450px;
    }
</style>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-11">
            <h3 style="text-align: center">Chất Liệu</h3>

            <button type="button" class="btn btn-primary">
                <a href="/chat-lieu/view-add">
                    <box-icon name='book-add'></box-icon>
                </a>
            </button>
            <div class="form">
                <sf:form action="/chat-lieu/search" method="get" modelAttribute="searchForm" >
                    <div >
                        <sf:input path="keyword" />
                        <button class="btn btn-success" style="margin-left: 10px">Tìm</button>
                    </div>
                </sf:form>
            </div>
            <table class="table table-danger">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Trạng Thái</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list.content}" var="cl" varStatus="stt">
                    <tr>
                        <th scope="row">${stt.index +1}</th>
                        <td>${cl.id}</td>
                        <td>${cl.ma}</td>
                        <td>${cl.ten}</td>
                        <td>${cl.trangThai == 1? "Còn" : "Ngưng"}</td>
                        <td>
                            <button type="button" class="btn btn-success">
                                <a href="/chat-lieu/edit/${cl.id}">
                                    <box-icon name='calendar-week'></box-icon>
                                </a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-center">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/chat-lieu/hien-thi?page=0&keyword=${param.keyword}">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="/chat-lieu/hien-thi?page=${list.number-1}&keyword=${param.keyword}"><<</a></li>
                        <li class="page-item"><a class="page-link" href="/chat-lieu/hien-thi?page=${list.number+1}&keyword=${param.keyword}">>></a></li>
                        <li class="page-item"><a class="page-link" href="/chat-lieu/hien-thi?page=${list.totalPages-1}&keyword=${param.keyword}">Next</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>