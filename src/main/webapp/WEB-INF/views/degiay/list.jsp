<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
/>
<link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
/>
<br>

<h1 style="text-align: center">QUẢN LÝ ĐẾ GIÀY</h1>
<a style="margin-left: 750px;" href="/de-giay/view-add" class="btn btn-success"><i class='bx bxs-add-to-queue' style="font-size: 27px;"></i></a>

<form action="/de-giay/search" method="post" style="margin-left: 1150px;">
    <div class="row mb-3">
        <div class="col-sm-8">
            <input type="text" class="form-control" id="inputEmail3" name="keyword">
        </div>
        <div class="col-sm-3">
            <button type="submit" class="btn btn-success">Search</button>
        </div>
    </div>

</form>

<a class="btn btn-success" href="/de-giay/sort">Sort</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Loại Đế</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="deGiay" varStatus="i" >
        <tr>
            <td>${i.index+1}</td>
            <td>${deGiay.id}</td>
            <td>${deGiay.ma}</td>
            <td>${deGiay.loaide}</td>
            <td>${deGiay.mota}</td>
            <td>
                <c:if test="${deGiay.trangthai == 0}">
                    Còn hàng
                </c:if>
                <c:if test="${deGiay.trangthai == 1}">
                    Hết hàng
                </c:if>
            </td>
            <td><a href="/de-giay/view-update/${deGiay.id}" class="btn btn-warning"><i class='bx bxs-edit' style="font-size: 23px;"></i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="text-center" style="margin-left: 650px;">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/de-giay/hien-thi?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/de-giay/hien-thi?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/de-giay/hien-thi?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link" href="/de-giay/hien-thi?p=${page.totalPages-1}">Next</a></li>
        </ul>
    </nav>
</div>

