<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<style>

    tr:nth-child(2n+1) {
        background-color: #FFC7C2;
    }

    tr:nth-child(2n) {
        background-color: white;
    }

    .row1 {
        color: white;
    }
    .btn{
        background-color: #FF6969;
        border: none;
        width: 80px;
        height: 30px;
    }

</style>
<div class="container">

    <h2 STYLE="text-align: center">QUẢN LÝ LOẠI GIÀY</h2>
    <form:form modelAttribute="searchForm">
        <div style="display: flex">
            <form:input path="keyword"></form:input>
            <button formaction="/loai-giay/list" class="btn btn-success" style="margin-left: 10px">Tìm</button>
        </div>
    </form:form>
    <a href="/loai-giay/form"><img src="https://cdn-icons-png.flaticon.com/512/2661/2661440.png"
            width="30px"></a>
    <table class="table">
        <tr class="row1" style="background-color:#FF6969 ">
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Mã</th>
            <th scope="col">Loại Giày</th>
            <th scope="col">Action</th>
        </tr>
        <c:forEach items="${page.content}" var="item" varStatus="i">
            <tr>
                <td scope="col">${i.index + 1}</td>
                <td scope="col">${item.id}</td>
                <td scope="col">${item.ma}</td>
                <td scope="col">${item.tentheloai}</td>
                <td scope="col" class="action">
                    <a href="/loai-giay/edit/${item.id}"><img src="https://cdn-icons-png.flaticon.com/512/1827/1827951.png" width="24px"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="text-center" style="margin-left: 430px; margin-top: 30px">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/loai-giay/list?p=0&keyword=${param.keyword}">Previous</a></li>
                <li class="page-item"><a class="page-link" href="/loai-giay/list?p=${page.number-1}&keyword=${param.keyword}"><<</a></li>
                <li class="page-item"><a class="page-link" href="/loai-giay/list?p=${page.number+1}&keyword=${param.keyword}">>></a></li>
                <li class="page-item"><a class="page-link" href="/loai-giay/list?p=${page.totalPages-1}&keyword=${param.keyword}">Next</a></li>
            </ul>
        </nav>
    </div>
</div>