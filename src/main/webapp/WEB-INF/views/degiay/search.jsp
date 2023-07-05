<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
/>

<br>

<h1 style="text-align: center">QUẢN LÝ ĐẾ GIÀY</h1>

<form action="/de-giay/search" method="post" style="margin-left: 800px;">
    <div class="row mb-3">
        <div class="col-sm-8">
            <input type="text" class="form-control" id="inputEmail3" name="keyword">
        </div>
        <div class="col-sm-3">
            <button type="submit" class="btn btn-success">Search</button>
        </div>
    </div>
</form>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Loại Đế</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Trạng thái</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${search}" var="search" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${search.id}</td>
            <td>${search.ma}</td>
            <td>${search.loaide}</td>
            <td>${search.mota}</td>
            <td>
                <c:if test="${search.trangthai == 0}">
                    Còn hàng
                </c:if>
                <c:if test="${search.trangthai == 1}">
                    Hết hàng
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>