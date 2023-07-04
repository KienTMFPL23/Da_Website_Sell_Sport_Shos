<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<%@page language="java" pageEncoding="UTF-8" %>
<head>
    <title>Bảng Màu Sắc </title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<body>
<div class="container">
    <h1 style="text-align: center">Bảng Màu Sắc</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list.getContent()}" var="ms" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${ms.ma}</td>
                <td>${ms.ten}</td>
                <td>${ms.tt == 1?"hoạt động":"ko hoạt động"}</td>
                <td>
                    <a href="update/${ms.id}">
                        <box-icon name='edit-alt'></box-icon>
                    </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <div>
        <c:if test="${list.number + 1 > 1}">
            <a href="?page=${list.number}&keyword=${param.keyword}&priceRange=${param.priceRange}">
                Previous
            </a>
        </c:if>
        <span>${list.number + 1} / ${list.totalPages}</span>
        <c:if test="${list.number + 1 < list.totalPages}">
            <a href="?page=${list.number + 2}&keyword=${param.keyword}&priceRange=${param.priceRange}">
                Next
            </a>
        </c:if>
    </div>

    <br>
<a href="/mau-sac/hien-thi-add" class="btn btn-primary" >Thêm</a>

</div>
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>