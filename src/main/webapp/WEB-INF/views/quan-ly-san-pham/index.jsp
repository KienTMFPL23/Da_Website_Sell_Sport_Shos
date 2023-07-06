<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<br>

<div class="container text-center">
    <div class="row">
        <div class="col-6 col-md-6 col-sm-6">
            <a href="/admin/quan-ly-san-pham" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
            <br>
        </div>

    </div>
    <form:form action="${action}" modelAttribute="sanpham" cssClass="text-center">
        <form:input path="id" class="form-control" type="hidden"/>

        <div class="mb-3">

            <a href="/quan-ly-san-pham/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

            <label class="form-label">Loại giầy: </label>
            <form:select path="loaiGiay">
                <form:option value="">-----</form:option>
                <form:options items="${listLoaiGiay}" itemLabel="tentheloai" itemValue="id"/>
            </form:select>
            <a href="/loai-giay/form" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>
        </div>
        <div class="mb-3">
            <label class="form-label">Đơn giá: </label>
            <form:input path="donGia"/>

            <label class="form-label">Kích cỡ: </label>
            <form:select path="kichCo">
                <form:option value="">-----</form:option>
                <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
            </form:select>
            <a href="/kich-co/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng: </label>
            <form:input path="soLuong"/>

            <label class="form-label">Màu sắc: </label>
            <form:select path="mauSac">
                <form:option value="">-----</form:option>
                <form:options items="${listMau}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <a href="mau-sac/hien-thi-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

        </div>
        <div class="mb-3">
            <label class="form-label">Mô tả: </label>
            <form:textarea cols="14" rows="5" path="moTaCT"/>

            <label class="form-label">Chất liệu: </label>
            <form:select path="chatLieu">
                <form:option value="">-----</form:option>
                <form:options items="${listChatLieu}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <a href="view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

        </div>
        <div class="mb-3">
            <label class="form-label">Hình ảnh: </label>
            <form:input type="file" path="hinhAnh" />
            <label class="form-label">Đế giày: </label>
            <form:select path="deGiay">
                <form:option value="">-----</form:option>
                <form:options items="${listDeGiay}" itemLabel="loaide" itemValue="id"/>
            </form:select>
            <a href="/de-giay/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

        </div>


        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
            <form:errors path="trangThai" cssStyle="color: crimson"/>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                Submit
            </button>
        </div>
    </form:form>
    <div class="text-center" style="color: crimson">${mess}</div>

</div>