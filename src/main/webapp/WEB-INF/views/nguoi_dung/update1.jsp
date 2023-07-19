<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@page language="java" pageEncoding="UTF-8" %>
<head>
    <title>Bảng Người Dùng </title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<body>
<div class="container">
    <div class="form">
        <h1 style="text-align: center">Sửa Người Dùng</h1>
        <div class="row">

            <sf:form method="post" modelAttribute="nd" action="/nguoi-dung/update" >
            <sf:input path="id" type="hidden"/>
                <%--                <div>--%>
                <%--                    <label> Tên tài Khoản :</label>--%>
                <%--                   <c:forEach items="${listTK}" var="tk">--%>
                <%--                       <sf:input path="tk" readonly="true" value="${tk.id}"/>--%>
                <%--                   </c:forEach>--%>

                <%--                </div>--%>
                <%--                <br>--%>
                <%--                <div>--%>
                <%--
                <%--                    <form:select path="tk">--%>
                <%--                        <c:forEach items="${listTK}" var="tk">--%>
                <%--                            <form:option value="${tk.id}">${tk.username}</form:option>--%>
                <%--                        </c:forEach>--%>
                <%--                    </form:select>--%>
                <%--                </div>--%>
            <label>Người Dùng</label>
            <form:select  path="tk" >
                <c:forEach items="${listTK}" var="tk">
                    <form:option value="${tk.id}" >${tk.username}</form:option>
                </c:forEach>
            </form:select>
            <div>
                <label> Mã</label>
                <sf:input path="ma"/>
                <sf:errors path="ma" />
            </div>
            <br>
            <label> Họ</label>
            <sf:input path="ho"/>
            <sf:errors path="ho" />
        </div>
        <br>
        <div>
            <label> Tên đệm</label>
            <sf:input path="tendem"/>
            <sf:errors path="tendem" />
        </div>
        <br>
        <br>
        <div>
            <label> Tên</label>
            <sf:input path="ten"/>
            <sf:errors path="ten" />
        </div>
        <div>
            <label> Giới Tính</label>
            <sf:radiobutton path="gioitinh" value="1"/>Nam

            <sf:radiobutton path="gioitinh" value="0"/>Nữ
        </div>
        <br>
        <div>
            <label> Ngày sinh</label>
            <sf:input type ="date" path="ngaysinh"/>

        </div>
        <br>

        <div>
            <label> Địa Chỉ</label>
            <sf:input path="diachi"/>
            <sf:errors path="diachi" />
        </div>
        <br>
        <div>
            <label> SDT</label>
            <sf:input path="sdt"/>
            <sf:errors path="sdt" />
        </div>
        <div>
            <label> Email</label>
            <sf:input path="email"/>
            <sf:errors path="email" />
        </div>
        <sf:radiobutton path="tt" value="1"/>Còn Hoạt Động

        <sf:radiobutton path="tt" value="0"/>K Hoạt Động
        <br>
        <button type="submit" class="btn btn-primary" onclick="confirm('Bạn có chắc chắn muốn sửa không ?')">UPDATE</button>
        </sf:form>

    </div>
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