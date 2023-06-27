<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Chất Liệu</title>
</head>
<body>
<h1 style="text-align: center">Chất Liệu</h1>
<table class="table-danger">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">ID</th>
        <th scope="col">Mã Chất Liệu</th>
        <th scope="col">Tên Chất Liệu</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="cl" varStatus="stt">
            <tr>
                <th scope="row">${stt.index +1}</th>
                <td>${cl.id}</td>
                <td>${cl.maChatLieu}</td>
                <td>${cl.tenChatLieu}</td>
                <td>

                </td>
            </tr>
        </c:forEach>
    </tbody>
    <c:forEach begin="0" end="${list.totalPages -1}">
            <button ></button>
    </c:forEach>
</table>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>