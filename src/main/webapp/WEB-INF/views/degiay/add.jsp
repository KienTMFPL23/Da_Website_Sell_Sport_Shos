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

<h1 style="text-align: center">THÊM/SỬA ĐẾ GIÀY</h1>

<form:form action="${action}" modelAttribute="degiay" method="post" style="margin-left: 470px; margin-top: 50px;">

    <div class="row mb-3">
        <div class="col-sm-3">
            <form:input type="hidden" class="form-control" id="inputEmail3" path="id"/>
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-3">
            <form:input type="text" class="form-control" id="inputEmail3" path="ma"/>
            <form:errors path="ma" cssStyle="color: crimson"></form:errors>
                ${mess_Ma}
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Loại đế</label>
        <div class="col-sm-3">
            <form:input type="text" class="form-control" id="inputEmail3" path="loaide"/>
            <form:errors path="loaide" cssStyle="color: crimson"></form:errors>
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Mô tả</label>
        <div class="col-sm-3">
            <form:input type="text" class="form-control" id="inputEmail3" path="mota"/>
            <form:errors path="mota" cssStyle="color: crimson"></form:errors>
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Trạng thái</label>
        <div class="col-sm-3">
            <form:radiobuttons items="${dsTrangThai}" path="trangthai" class="form-check-input"/>
            <form:errors path="trangthai" cssStyle="color: crimson"></form:errors>
        </div>
    </div>

    <button type="submit" class="btn btn-success" style="margin-left: 150px; margin-top: 30px;">Submit</button>


</form:form>