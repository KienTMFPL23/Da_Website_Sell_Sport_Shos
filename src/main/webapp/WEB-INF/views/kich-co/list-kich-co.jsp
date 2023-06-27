<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<br>

<div class="container">
    <div class="row">
        <div class="col-6 col-md-6 col-sm-6">
            <a href="/kich-co/hien-thi" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
            <br>
            <br>
            <div class="mb-3">
                <form:form action="/kich-co/search" modelAttribute="searchForm">
                <form:input path="size" class="form-control"/><br>
                <form:input path="loaisize" class="form-control"/><br>
                <button class="btn btn-warning" type="submit">Search</button>
            </div>
            </form:form>

        </div>
        <div class="col-6 col-md-6 col-sm-6">
            <a href="/kich-co/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i> Add</a>
            <br>
        </div>
    </div>

    <a href="/kich-co/sort">Sort</a>
    <br>
    <table class="table table-bordered">
        <thead class="table table-danger">
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Size</th>
            <th>Giới Tính</th>
            <th>Trạng Thái</th>
            <th>Loại size</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.content}" var="kc" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${kc.id}</td>
                <td>${kc.maKichCo}</td>
                <td>${kc.size}</td>
                <td>
                    <c:if test="${kc.gioiTinh==true}">Nam</c:if>
                    <c:if test="${kc.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${kc.trangThai==1?"Hoạt động":"Không hoạt động"}</td>
                <td>${kc.loaiSize}</td>
                <td>
                    <a href="/kich-co/view-update/${kc.id}" class="btn btn-warning"><i class="bi bi-pencil-square"></i></a>
                    <a href="/kich-co/remove/${kc.id}" class="btn btn-danger"
                       onclick="return confirm('Bạn có chắc muốn xoá ?');"><i class="bi bi-trash3-fill"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/kich-co/hien-thi?p=0">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/kich-co/hien-thi?p=${page.number-1}"><<</a></li>
                <li class="page-item"><a class="page-link" href="/kich-co/hien-thi?p=${page.number+1}">>></a></li>
                <li class="page-item"><a class="page-link" href="/kich-co/hien-thi?p=${page.totalPages-1}">Next</a></li>
            </ul>
        </nav>
    </div>
</div>