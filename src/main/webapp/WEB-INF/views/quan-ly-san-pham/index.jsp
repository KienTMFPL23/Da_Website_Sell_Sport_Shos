<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<br>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    #but {
        background-color: #1492AE;
        border-radius: 0;
        border: none;
        width: 100px;
    }

    </div>

    <form:form action="${action}" modelAttribute="sanpham" cssClass="text-center">
        <form:input path="id" class="form-control" type="hidden"/>
       <label>Tên sản phẩm:${tensp}</label>
<%--        <form:select  path="sanPham" >--%>
<%--            <form:option value="">-----</form:option>--%>
<%--            <form:options items="${listSP}" itemLabel="tenSP" itemValue="id"/>--%>
<%--        </form:select>--%>
        <a href="/loai-giay/form" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i></a>

    .left {
        width: 45%;
        padding-left: 20px;
    }

    .item {
        float: left;
    }

    .ite {
        float: left;
    }

    .item label {
        color: #FB6D60;
    }

    .inp input {
        border: none;
        width: 280px;
        border-radius: 15px;
    }

    .right {
        width: 27%;
        margin-right: 150px;
    }

    .form {
        display: flex;
        justify-content: space-between;
    }

    .container {
        background-color: #D6FAE7;
        font-family: Regular;
    }

    .img input {
        background-color: white;
    }

    .item input {
        margin-top: 20px;
    }

    .item-right {
        display: flex;
        justify-content: space-between;
    }
    .item-right select{
        height: 30px;
        margin-top: 20px;
        width: 150px;
        border: none;

    }
    .item-right img{
        margin-top: 20px;
        margin-right: 40px;
    }

</style>
<div class="container">
    <h2 style="text-align: center;padding-top: 20px;margin-bottom: 20px">Thêm/Sửa sản phẩm</h2>
    <form:form action="${action}" modelAttribute="sanpham" cssClass="text-center">
        <form:input path="id" class="form-control" type="hidden"/>
        <div class="form">
            <div class="left">
                <div class="item inp">
                    <label class="form-label">Đơn giá: </label>
                    <form:input path="donGia" cssStyle="margin-left: 50px"/>
                </div>
                <div class="item inp">
                    <label class="form-label">Số lượng: </label>
                    <form:input path="soLuong" cssStyle="margin-left: 44px"/>
                </div>
                <div class="item">
                    <label class="form-label">Mô tả: </label>
                    <form:textarea cols="50" rows="5" path="moTaCT"
                                   cssStyle="border: none; width: 280px;height: 100px;border-radius: 15px;margin-left: 65px;margin-top: 20px"/>
                </div>
                <div class="item img">
                    <label class="form-label">Hình ảnh: </label>
                    <form:input type="file" path="hinhAnh" cssStyle="margin-left: 43px"/>
                </div>
                <div class="ite" style="margin-top: 20px">
                    <label class="form-label" style="color: #FB6D60;margin-right: 20px">Trạng Thái</label>
                    <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"
                                       cssStyle="margin-right: 15px;margin-left: 20px;"/>
                    <form:errors path="trangThai" cssStyle="color: crimson"/>
                </div>
            </div>
            <div class="right ">
                <div class="item-right">
                    <form:select path="loaiGiay">
                        <form:option value="">Loại giầy</form:option>
                        <form:options items="${listLoaiGiay}" itemLabel="tentheloai" itemValue="id"/>
                    </form:select>
                    <a href="/loai-giay/form" ><img src="../images/plus.png"></a>
                </div>
                <div class="item-right">
                    <form:select path="kichCo">
                        <form:option value="">Kích cỡ</form:option>
                        <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
                    </form:select>
                    <a href="/kich-co/view-add"><img src="../images/plus.png"></a>
                </div>
                <div class="item-right">
                    <form:select path="mauSac">
                        <form:option value="">Màu sắc</form:option>
                        <form:options items="${listMau}" itemLabel="ten" itemValue="id"/>
                    </form:select>
                    <a href="/mau-sac/hien-thi-add" ><img src="../images/plus.png"></a>
                </div>
                <div class="item-right">

                    <form:select path="chatLieu">
                        <form:option value="">Chất liệu</form:option>
                        <form:options items="${listChatLieu}" itemLabel="ten" itemValue="id"/>
                    </form:select>
                    <a href="/chat_lieu/add_update" ><img src="../images/plus.png"></i></a>
                </div>
                <div class="item-right">

                    <form:select path="deGiay">
                        <form:option value="">Đế giày</form:option>
                        <form:options items="${listDeGiay}" itemLabel="loaide" itemValue="id"/>
                    </form:select>
                    <a href="/de-giay/view-add"><img src="../images/plus.png"></a>
                </div>
            </div>
        </div>
        <div class="text-center" style="padding-bottom: 20px">
            <button type="submit" id="but" class="btn btn-success"
                    onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                SUBMIT
            </button>
        </div>
    </form:form>
</div>
<div class="text-center" style="color: crimson">${mess}</div>

