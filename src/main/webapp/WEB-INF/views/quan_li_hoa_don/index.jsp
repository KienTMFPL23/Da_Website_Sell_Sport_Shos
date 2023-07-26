<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Hoá Đơn</title>
</head>
<style>

</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h3>Quản Lý Hóa đơn</h3>
        </div>
    </div>
</div>
<div class="container">
  <form th:action="/hoa-don/hien-thi">
      <div class="row">

          <div class="col-lg-3">
              <label>Mã Hóa đơn</label>

              <div class="col">
                  <input type="text" class="form-control" placeholder="Nhập tên hoặc mã cần tìm" name="maHD"
                         value="${mahd}" >
              </div>

          </div>


          <div class="col-lg-3">
              <label>Tên Khách Hàng</label>
              <div class="col">
                  <input type="text" class="form-control" placeholder="Nhập tên hoặc mã cần tìm" name="tenNguoiNhan"
                         value="${tenNguoiNhan}" >
              </div>
          </div>


          <div class="col-lg-3">
              <label>Ngày Bắt đầu</label>
              <div class="col">
                  <input type="date" name="ngayDau" value="${ngayTao}"/>
              </div>
          </div>
          <div class="col-lg-3">
              <label>Ngày Kết Thúc</label>
              <div class="col">
                  <input type="date" name="ngayKet" value="${ngayThanhToan}"/>
              </div>
          </div>

      </div>
      <button type="submit">Search </button>
      <button type="button" class="btn btn-primary" value="clear" onclick="clearFilter()">clear</button>

  </form>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Mã HĐ</th>
                    <th scope="col">Nhân Viên</th>
                    <th scope="col">Ngày Tạo</th>
                    <th scope="col">Ngày Thanh Toán</th>
                    <th scope="col">Tên Khách Hàng</th>
                    <th scope="col">Trạng Thái</th>
                </tr>
                </thead>
                <tbody>
               <c:forEach items="${hd.content}" var="hd" varStatus="stt">
                   <tr>
                       <th scope="row">${stt.index +1}</th>
                       <td>${hd.maHD}</td>
                       <td>${hd.nguoiDung.ten}</td>
                       <td>${hd.ngayTao}</td>
                       <td>${hd.ngayThanhToan}</td>
                       <td>${hd.nguoiDung.ten}</td>
                       <td>${hd.trangThai}</td>
                   </tr>
               </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div>
    <c:if test="${hd.number + 1 > 1}">
        <a href="?page=${hd.number}&keyword=${param.keyword}&priceRange=${param.priceRange}">
            Previous
        </a>
    </c:if>
    <span>${hd.number + 1} / ${hd.totalPages}</span>
    <c:if test="${hd.number + 1 < hd.totalPages}">
        <a href="?page=${hd.number + 2}&keyword=${param.keyword}&priceRange=${param.priceRange}">
            Next
        </a>
    </c:if>
</div>
<script type="text/javascript">
    function clearFilter(){
        window.location='/hoa-don/hien-thi';
    }
</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>