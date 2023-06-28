<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chất liệu</title>
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
</head>

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
            <form action="/chat-lieu/search" method="get">
                <div>
                    <label>Tên</label>
                    <input name="ten" />
                </div>
                <button type="button" class="btn btn-primary">Search</button>
            </form>
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
            <c:forEach begin="0" end="${list.totalPages -1}" varStatus="loop">

                <a href="/chat-lieu/hien-thi?page=${loop.begin + loop.count -1}">
                    <button type="button" class="btn btn-info">${loop.begin + loop.count }</button>
                </a>
            </c:forEach>
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