<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chất liệu</title>
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <h3 style="text-align: center">Thêm /Sửa Chất Liệu</h3>
            <sf:form class="was-validated" method="post" modelAttribute="vm" action="${action}">
                <div>
                    <label>Mã</label>
                    <sf:input path="ma" />
                    <sf:errors path="ma" />
                </div>
                <div>
                    <label>Tên</label>
                    <sf:input path="ten" />
                    <sf:errors path="ten" />
                </div>
                <div>
                    <label>Trạng Thái</label>
                    <sf:radiobutton path="trangThai" value="1" checked="true"/>HĐ
                    <sf:radiobutton path="trangThai" value="0"/>Ngưng HĐ
                </div>
                <div class="mb-3">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </sf:form>
        </div>
    </div>
</div>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>