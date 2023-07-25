<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ban Hang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://unpkg.com/html5-qrcode@2.0.9/dist/html5-qrcode.min.js"></script>
</head>
<style>
    .hoadon {
        font-family: Regular;
        margin-right: 10px;
        background-color: white;
        width: 160px;
        border-radius: 15px;
        margin-top: 10px;
        margin-bottom: 10px;
        position: relative;
    }

    .hoadon label {
        padding-left: 10px;
    }

    .imgRemove {
        position: absolute;
        right: 5px;
        top: 3px;
    }
</style>
<body>
<div class="container-fluid">
    <br>
    <div class="row">
        <div class="col-lg-4">
            <div class="wrapper">

                <%--                <div class=""></div>--%>

                <form:form method="get" action="/ban-hang/searchSanPham" modelAttribute="searchForm">
                    <form class="d-flex" role="search">
                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                        <form:input path="keyword" style="width: 250px"/>
                    </form>
                    <div>${searchhNull}</div>
                </form:form>
            </div>
        </div>
        <div class="col-lg-3">
            <!-- Button trigger modal -->
            <a href="#" class="btn btn-primary" data-bs-toggle="modal"
               data-bs-target="#staticBackdrop">
                Tìm kiếm nâng cao
            </a>
            <!-- Modal -->
            <div class="modal modal-lg fade" style="width: 1500px" id="staticBackdrop" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Danh sách sản phẩm</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <%--                        <form:form action="/ban-hang/filter-by-name" method="get" modelAttribute="filterCTSP">--%>
                        <%--                            <form:options items="${listSP}" itemLabel="sanPham.tenSP" itemValue="sanPham.tenSP"/>--%>
                        <%--                        </form:form>--%>
                        <div class="modal-body">
                            <table class="table">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Đơn giá</th>
                                    <th>Số lượng</th>
                                    <th>Hình ảnh</th>
                                    <th>Màu sắc</th>
                                    <th></th>
                                </tr>

                                <tbody>
                                <c:forEach items="${listSP}" var="sp" varStatus="i">
                                    <tr>
                                        <td>${i.count}</td>
                                        <td>${sp.sanPham.tenSP}</td>
                                        <td>${sp.donGia}</td>
                                        <td>${sp.soLuong}</td>
                                        <td>${sp.hinhAnh}</td>
                                        <td>${sp.mauSac.ten}</td>
                                        <td><a href="/ban-hang/them-san-pham/${sp.id}" class="btn btn-primary">Chọn</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <a href="#" id="qr-reader" class="btn btn-primary">Quét QR</a>

        </div>
        <c:if test="${sum != 0}">
            <div class="col-lg-2">
                <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button"
                   aria-controls="offcanvasExample">
                    Thanh toán
                </a>
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample"
                     aria-labelledby="offcanvasExampleLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Thanh toán</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>

                    <div class="offcanvas-body">
                        <form:form method="post" action="/ban-hang/thanhtoan/${idHoaDon}" modelAttribute="hoaDon">
                            <input value="${idHoaDon}" name="id" type="hidden">
                            <div class="row">
                                <p>Khách hàng: <form:input path="tenNguoiNhan" id="phoneNumber"
                                                           onchange="getTenKhachHang()" class="form-control"/><a
                                        href="#"><img
                                        src="/images/plus.png"></a></p>
                                <p>Nhân viên bán hàng: <input class="form-control" value="${fullNameStaff}" readonly>
                                </p>
                                <p>Tổng tiền : <fmt:formatNumber value="${sum}" type="number" groupingUsed="false"/>
                                    đ</p>
                                <p>Giảm giá : 0đ</p>
                                <p>Tổng tiền phải thu : <fmt:formatNumber value="${sum}" type="number"
                                                                          groupingUsed="false"/> đ</p>
                                <p>Tiền khách đưa: <input class="form-control" type="number" id="change"
                                                          onchange="getMoneyChange()"></p>
                                <p>Tiền thừa: <label type="number" id="tienThua"
                                                     groupingUsed="false"></label>đ</p>
                            </div>
                            <div class="dropdown mt-3">
                                    <button class="btn btn-primary">In hóa đơn</button>
                                    <button type="submit" class="btn btn-primary"
                                            onclick="return confirm('Bạn có muốn thanh toán không')">Thanh toán
                                    </button>
                            </div>
                        </form:form>
                    </div>


<%--            <div id="qr-reader" style="width: 600px"></div>--%>
        </div>
        <div class="col-lg-2">
            <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button"
               aria-controls="offcanvasExample">
                Thanh toán
            </a>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample"
                 aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Thanh toán</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>

                <div class="offcanvas-body">
                    <form:form method="post" action="/ban-hang/thanhtoan/${idHoaDon}" modelAttribute="hoaDon">
                        <input value="${idHoaDon}" name="id" type="hidden">
                        <div class="row">
                            <p>Khách hàng: <form:input path="tenNguoiNhan" class="form-control" /><a href="#"><img src="/images/plus.png"></a></p>
                            <p>Nhân viên bán hàng: <input class="form-control"></p>
                            <p>Tổng tiền : <fmt:formatNumber value="${sum}" type="number" groupingUsed="false"  /> đ</p>
                            <p>Giảm giá : 0đ</p>
                            <p>Tổng tiền phải thu : <fmt:formatNumber value="${sum}" type="number" groupingUsed="false"  /> đ</p>
                            <p>Tiền khách đưa: <input class="form-control" type="number" id="change" onchange="getMoneyChange(this.value)"></p>
                            <p>Tiền thừa: <label> <fmt:formatNumber value="${sum}" type="number" groupingUsed="false" /> đ</label> </p>
                        </div>
                        <div class="dropdown mt-3">
                            <button class="btn btn-primary">In hóa đơn</button>
                            <button type="submit" class="btn btn-primary">Thanh toán</button>
                        </div>
                    </form:form>

                </div>

            </div>
        </c:if>
    </div>
    <br>
    <div class="tab">
        <nav data-bs-spy="scroll" class="nav navbar-expand-lg " style="background-color: #e3f2fd;">
            <c:forEach items="${listHoaDon}" var="hd" varStatus="i">
                <div class="hoadon">

                    <a class="nav_link active" href="/ban-hang/hoadonchitiet/${hd.id}" id="linkIdHD">Hóa
                        đơn ${i.count} </a>

                    <a class="nav_link active" href="/ban-hang/hoadonchitiet/${hd.id}" id="linkIdHD">Hóa đơn ${i.count} </a>

                    <a href="/ban-hang/remove/${hd.id}"><img class="imgRemove" src="/images/remove.jpg"
                                                             width="12px"></a>
                </div>
            </c:forEach>
            <a href="/ban-hang/createInvoice"><img src="/images/plus.png" style="margin-top: 8px"></a>
        </nav>
    </div>
    <p>Giỏ hàng chi tiết</p>
    <table class="table table-bordered">
        <thead class="table table-primary">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Thành tiền</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hdct" items="${dsHoaDonCT}" varStatus="i">
            <form:form action="/ban-hang/update-cart/${hdct.id}" method="post">
                <input type="hidden" name="id" value="${hdct.id}">
                <tr>
                    <td>${i.count}</td>
                    <td>${hdct.qlSanPham.sanPham.tenSP}</td>
                    <td><input type="number" class="form-control"
                               min="1"
                               name="soLuong"
                               value="${hdct.soLuong}"
                               onblur="this.form.submit()"
                               style="width:100px;"></td>

                    <td><fmt:formatNumber value="${hdct.donGia}" type="number" groupingUsed="false"/></td>
                    <td><fmt:formatNumber value="${hdct.soLuong * hdct.donGia}" type="number"
                                          groupingUsed="false"/></td>

                    <td><fmt:formatNumber value="${hdct.donGia}" type="number" groupingUsed="false" /> </td>
                    <td><fmt:formatNumber value="${hdct.soLuong * hdct.donGia}" type="number" groupingUsed="false" /> </td>

                    <td><a href="/ban-hang/removeHoaDonChiTiet/${hdct.id}"><img src="/images/delete.png"> </a></td>
                </tr>
            </form:form>
        </c:forEach>
        </tbody>
    </table>

    <p style="text-align: left;color: red">Tổng tiền: <fmt:formatNumber value="${sum}" type="number"
                                                                        groupingUsed="false"/> đ</p>

    <p style="text-align: left;color: red">Tổng tiền: <fmt:formatNumber value="${sum}" type="number" groupingUsed="false" /> đ</p>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>

<script src="https://unpkg.com/html-5"></script>
<script>
    function getMoneyChange() {
        var change = document.getElementById('change').value;
        document.getElementById('tienThua').innerHTML = change - ${sum};
        let checkMoney = change = ${sum};
    }

<script>
    var html5QrcodeScanner = new Html5QrcodeScanner(
        "qr-reader", { fps: 10, qrbox: 250 });
   function getMoneyChange(moneyChange){
       let change = moneyChange;
   }

</script>
</body>
</html>
