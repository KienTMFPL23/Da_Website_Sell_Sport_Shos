<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page language="java" pageEncoding="UTF-8" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Thông tin đơn hàng</title>--%>
<%--</head>--%>
<%--<style>--%>

<%--</style>--%>
<%--<body>--%>
<%--&lt;%&ndash;<div class="container">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="row">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col-lg-12">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <h3>Hóa đơn chi tiết</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="container" style="padding-top: 30px">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="row">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col-lg-12">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <table class="table table-striped">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <thead class="table table-info">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <th scope="col">STT</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <th scope="col">Tên Sản Phẩm</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <th scope="col">Đơn Giá</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <th scope="col">Số Lượng</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <th scope="col">Thành Tiền</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <c:forEach items="${listHDCT}" var="cthd" varStatus="stt">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <th scope="row">${stt.index +1}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                        <td>${cthd.toString().tenSP}</td>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <td>${cthd.donGia}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <td>${cthd.soLuong}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                        <td>${cthd.TinhTien()}</td>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </table>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-lg-12">--%>
<%--            <h3>Thông tin khách hàng</h3>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="container" style="padding-top: 30px">--%>
<%--    <div class="row">--%>
<%--        <div class="col-lg-12">--%>
<%--            <table class="table table-striped">--%>
<%--                <thead class="table table-info">--%>
<%--                <tr>--%>
<%--                    <th scope="col">STT</th>--%>
<%--                    <th scope="col">Mã Khách Hàng</th>--%>
<%--                    <th scope="col">Tên Khách</th>--%>
<%--                    <th scope="col">Số Điện Thoại</th>--%>
<%--                    <th scope="col">Địa Chỉ</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <c:forEach items="${listKH}" var="kh" varStatus="stt">--%>
<%--                    <tr>--%>
<%--                        <th scope="row">${stt.index +1}</th>--%>
<%--                        <td>${kh.ma}</td>--%>
<%--                        <td>${kh.ten}</td>--%>
<%--                        <td>${kh.sdt}</td>--%>
<%--                        <td>${kh.diachi}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--                </tbody>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--</body>--%>
<%--</html>--%>