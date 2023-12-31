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

    .item-right select {
        height: 30px;
        margin-top: 20px;
        width: 150px;
        border: none;

    }

    .item-right img {
        margin-top: 20px;
        margin-right: 40px;
    }

</style>
<div class="container">
    <h2 style="text-align: center;padding-top: 20px;margin-bottom: 20px">Thêm/Sửa sản phẩm</h2>
    <form:form action="${action}" modelAttribute="sanpham" cssClass="text-center" enctype="multipart/form-data">
        <form:input path="id" class="form-control" type="hidden"/>
        <div class="form">
            <div class="left">
                <div class="item inp">
                    <label class="form-label">Tên sản phẩm: </label>
                    <form:input path="sanPham" class="form-control" type="hidden"/>
                    <form:input path="sanPham.tenSP" value="${tensp}" readonly="true"/>
<%--                    <form:input path="id"  id="qrText" readonly="true"/>--%>
                </div>
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
                    <img src="/src/main/resources/static/image/${photo}"/>
                </div>
                <div class="ite" style="margin-top: 20px">
                    <label class="form-label" style="color: #FB6D60;margin-right: 20px">Trạng Thái</label>
                    <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"
                                       cssStyle="margin-right: 15px;margin-left: 20px;"/>
                </div>
            </div>
            <div class="right ">
                <div class="item-right">
                    <form:select path="loaiGiay">
                        <form:option value="">Loại giầy</form:option>
                        <form:options items="${listLoaiGiay}" itemLabel="tentheloai" itemValue="id"/>
                    </form:select>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal"><img
                            src="/images/plus.png"></a>

                </div>

                <div class="item-right">
                    <form:select path="kichCo">
                        <form:option value="">Kích cỡ</form:option>
                        <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
                    </form:select>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal2"><img
                            src="/images/plus.png"></a>
                </div>
                <div class="item-right">
                    <form:select path="mauSac">
                        <form:option value="">Màu sắc</form:option>
                        <form:options items="${listMau}" itemLabel="ten" itemValue="id"/>
                    </form:select>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal3"><img
                            src="/images/plus.png"></a>

                </div>
                <div class="item-right">

                    <form:select path="chatLieu">
                        <form:option value="">Chất liệu</form:option>
                        <form:options items="${listChatLieu}" itemLabel="ten" itemValue="id"/>
                    </form:select>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal4"><img
                            src="/images/plus.png"></a>
                </div>
                <div class="item-right">

                    <form:select path="deGiay">
                        <form:option value="">Đế giày</form:option>
                        <form:options items="${listDeGiay}" itemLabel="loaide" itemValue="id"/>
                    </form:select>
                    <a data-bs-toggle="modal" data-bs-target="#exampleModal5"><img
                            src="/images/plus.png"></a>
                </div>
            </div>
        </div>
        <div class="text-center" style="padding-bottom: 20px">
            <button type="submit" id="but" class="btn btn-success"
                  onclick="return confirm('Bạn có chắc muốn thực hiện ?');">
                Submit
            </button>
        </div>
    </form:form>
    <%--    modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="lg" method="post" action="/san-pham/loai-giay/add/${sanpham.id}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm Loại Giầy</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="input" style="">
                            <p>Mã:</p>
                            <form:input path="ma" class="form-control"/>
                        </div>
                        <form:errors path="ma"/>
                        <div style="margin-left: 10px;color: red">${errorMa}</div>
                        <div class="input">
                            <p>Loại giày:</p>
                            <form:input path="tentheloai" class="form-control"/>

                        </div>
                        <form:errors path="tentheloai"/>
                        <div style="margin-left: 10px;color: red">${errorTen}</div>
                        <div class="mb-3">
                            <label class="form-label">Trạng Thái</label>
                            <form:radiobuttons items="${dsTrangThai}" path="trangthai" class="form-check-input"/>
                            <form:errors path="trangthai" cssStyle="color: crimson"/>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal2--%>
    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="kichco" action="/san-pham/kich-co/add/${sanpham.id}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel2">Thêm kích cỡ</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <div class="mb-3">
                            <label class="form-label">Size</label>
                            <form:input path="size" class="form-control"/>
                            <form:errors path="size" cssStyle="color: crimson"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giới Tính</label>
                            <form:radiobuttons items="${dsGioiTinh}" path="gioiTinh" class="form-check-input"/>
                            <form:errors path="gioiTinh" cssStyle="color: crimson"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Loại size</label>
                            <form:input path="loaiSize" class="form-control"/>
                            <form:errors path="loaiSize" cssStyle="color: crimson"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Trạng Thái</label>
                            <form:radiobuttons items="${dsTrangThai}" path="trangThai" class="form-check-input"/>
                            <form:errors path="trangThai" cssStyle="color: crimson"/>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal3--%>
    <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="ms" action="/san-pham/mau-sac/add/${sanpham.id}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel3">Thêm màu sắc</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label> Mã</label>
                            <form:input class="form-control" path="ma"/>
                            <form:errors path="ma"/>
                        </div>
                        <br>
                        <div class="mb-3">
                            <label> Tên</label>
                            <form:input class="form-control" path="ten"/>
                            <form:errors path="ten"/>
                        </div>
                        <br>
                        <div class="mb-3">
                            <form:radiobutton class="form-check-input" path="tt" value="1"/>Còn Hoạt Động
                            <form:radiobutton class="form-check-input" path="tt" value="0"/>K Hoạt Động
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal4--%>
    <div class="modal fade" id="exampleModal4" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="vm" action="/san-pham/chat-lieu/add/${sanpham.id}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel4">Thêm chất liệu</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div id="ma">
                            <label>Mã</label>
                            <form:input path="ma" class="form-control"/> <br/>
                            <form:errors path="ma" cssStyle="color: red"/>
                        </div>
                        <div id="ten">
                            <label>Tên</label>
                            <form:input path="ten" class="form-control"/> <br/>
                            <form:errors path="ten" cssStyle="color: red"/>
                        </div>
                        <div id="tt">
                            <label>Trạng Thái</label>
                            <form:radiobutton class="form-check-input" path="trangThai" value="1" checked="true"/>HĐ
                            <form:radiobutton class="form-check-input" path="trangThai" value="0"/>Ngưng HĐ
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
    <%--    modal4--%>
    <div class="modal fade" id="exampleModal5" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form modelAttribute="degiay" action="/san-pham/de-giay/add/${sanpham.id}">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel5">Thêm đế giầy</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Mã</label>
                        <div class="mb-3">
                            <form:input type="text" class="form-control" id="inputEmail3" path="ma"/>
                            <form:errors path="ma" cssStyle="color: crimson"></form:errors>
                                ${mess_Ma}
                        </div>

                        <label for="inputEmail3" class="col-sm-2 col-form-label">Loại đế</label>
                        <div class="mb-3">
                            <form:input type="text" class="form-control" id="inputEmail3" path="loaide"/>
                            <form:errors path="loaide" cssStyle="color: crimson"></form:errors>
                        </div>

                        <label for="inputEmail3" class="col-sm-2 col-form-label">Mô tả</label>
                        <div class="mb-3">
                            <form:input type="text" class="form-control" id="inputEmail3" path="mota"/>
                            <form:errors path="mota" cssStyle="color: crimson"></form:errors>
                        </div>


                        <label for="inputEmail3" class="col-sm-2 col-form-label">Trạng thái</label>
                        <div class="mb-3">
                            <form:radiobuttons items="${dsTrangThai}" path="trangthai" class="form-check-input"/>
                            <form:errors path="trangthai" cssStyle="color: crimson"></form:errors>
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</div>
<div class="text-center" style="color: crimson">${mess}</div>


