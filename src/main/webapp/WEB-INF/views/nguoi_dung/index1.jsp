<html>
<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>
        Trang khach hàng
    </title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<body>
<h1 style="text-align: center">Bảng Nhân Viên</h1>
<form th:action="/nguoi-dung/hien-thi/nhan-vien" >
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Nhập tên hoặc sdt cần tìm"  name="key" th:value="${key}" required>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary" value="search">Search</button>
        </div>
        <div class="col-12">
            <button type="button" class="btn btn-primary" value="clear" onclick="clearFilter()">clear</button>
        </div>
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên tk </th>
        <th scope="col">Họ</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Tên</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">SDT</th>
        <th scope="col">Email</th>
        <th scope="col">Role</th>
        <th scope="col">Chức Năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list1.content}" var="nd" varStatus="stt">
        <tr>
            <td>${stt.index+1}</td>
            <td>${nd.tk.username}</td>
            <td>${nd.ma}</td>
            <td>${nd.ho}</td>
            <td>${nd.tendem}</td>
            <td>${nd.ten}</td>
            <td>${nd.gioitinh == true ? "Nam":"Nữ"}</td>
            <td>${nd.ngaysinh}</td>
            <td>${nd.sdt}</td>
            <td>${nd.email}</td>
            <td>${nd.tk.role == true?"Nhân  Viên":"Khách  hàng"}</td>
            <td>
                <a href="/nguoi-dung/view/update/${nd.id}">
                    <box-icon name='edit-alt'></box-icon>
                </a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<div>
    <c:if test="${list.number + 1 > 1}">
        <a href="?page=${list.number}&keyword=${param.keyword}&priceRange=${param.priceRange}">
            Previous
        </a>
    </c:if>
    <span>${list.number + 1} / ${list.totalPages}</span>
    <c:if test="${list.number + 1 < list.totalPages}">
        <a href="?page=${list.number + 2}&keyword=${param.keyword}&priceRange=${param.priceRange}">
            Next
        </a>
    </c:if>
</div>
<br>
<a class="btn btn-success" href="/mau-sac/sort">Sort</a>
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<script type="text/javascript">
    function clearFilter(){
        window.location='/nguoi-dung/hien-thi/nhan-vien';
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>