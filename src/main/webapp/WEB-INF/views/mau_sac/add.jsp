<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<%@page language="java" pageEncoding="UTF-8" %>
<head>
    <title>Bảng Màu Sắc </title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<body>
<div class="container">
    <h1 style="text-align: center">Thêm Bảng Màu Sắc Giày</h1>
    <div class="row">

            <sf:form method="post" modelAttribute="ms" action="/mau-sac/add" >
                <div>
                    <label> Mã</label>
                    <sf:input path="ma"/>
                    <sf:errors path="ma" />
                </div>
                <br>
                <div>
                    <label> Tên</label>
                    <sf:input path="ten"/>
                    <sf:errors path="ten" />
                </div>
                <br>
                <sf:radiobutton path="tt" value="1"/>Còn Hoạt Động

                <sf:radiobutton path="tt" value="0"/>K Hoạt Động
                <br>
                <button type="submit" class="btn btn-primary" onclick="confirm('Bạn có chắc chắn muốn thêm không ?')" >ADĐ</button>
            </sf:form>

    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>