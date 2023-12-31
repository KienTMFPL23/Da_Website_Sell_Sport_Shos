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

    .container {
        padding-top: 30px;
        background-color: #DCF3E7;
    }

    #inputSearch {
        border: none;
        width: 250px;
        border-radius: 10px;
    }

    #search {
        display: flex;
        margin-left: 40px;
    }

    #search button {
        border-radius: 0;
        background-color: #1EBB1A;
        border: none;
        color: white;
        font-family: Regular;
        font-size: 20px;
        margin-left: 30px;
    }

    #search input::placeholder {
        color: #C9BC9A;
        font-family: Regular;
        font-size: 22px;
    }

    #btnAdd {
        background-color: #2EC32B;
        position: relative;
        margin-right: 50px;
    }

    #btnAdd a {
        text-decoration: none;
        color: white;
        font-family: Regular;
        font-size: 20px;
        padding-top: 5px;
        position: absolute;
        left: 0;
        right: 0;
    }

    .row {
        display: flex;
        justify-content: space-between;
    }

    .form-label {
        width: 80px;
        background-color: #D9D9D9;
        font-family: Regular;
        font-weight: bold;
        text-align: center;
    }

    .row-select-one {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }

    select {
        border: none;
    }

    .row-select-second {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }

    .table {
        background-color: white;
        font-family: Regular;
        margin-top: 30px;
    }

    .text-center {
        font-family: Regular;

    }

    .text-center a {
        text-decoration: none;
        color: black;
        margin-bottom: 20px;

    }
</style>

<div class="container">
    <form:form modelAttribute="searchForm" cssClass="text-center" action="/quan-ly-san-pham/search">
        <div class="row">
            <div class="col-6 col-md-6 col-sm-6" id="search">
                <form:input path="keyword" class="form-control" id="inputSearch" placeholder="Tìm kiếm"/>
                <button class="btn btn-warning" type="submit">Search</button>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3" id="btnAdd">
                <label class="form-label" style="color: #2EC32B"><a href="/san-pham/hien-thi"/>
                    <img src="../images/plus.png">
                    Add</a></label>
                </br>
            </div>
        </div>
    </form:form>
    </br>
    <div class="row" style="padding-bottom: 30px">
        <div class="col-2 col-md-2 col-sm-2">
            <form:form modelAttribute="lg" action="/quan-ly-san-pham/search-by-loaigiay">
                <label class="form-label">Loại giầy: </label>
                <form:select path="idLG" class="form-control" onchange="submit()">
                    <form:option value="">Tất cả</form:option>
                    <form:options items="${listLoaiGiay}" itemLabel="tentheloai" itemValue="id"/>
                </form:select>
            </form:form>
        </div>

        <div class="col-2 col-md-2 col-sm-2">
            <form:form modelAttribute="searchChatLieu" action="/quan-ly-san-pham/search-by-chatlieu">
                <label class="form-label">Chất liệu: </label>
                <form:select path="idChatLieu" class="form-control" onchange="submit()">
                    <form:option value="">Tất cả</form:option>
                    <form:options items="${listChatLieu}" itemLabel="ten" itemValue="id"/>
                </form:select>
            </form:form>
        </div>

        <div class="col-2 col-md-2 col-sm-2">
            <form:form action="/quan-ly-san-pham/search-by-degiay" modelAttribute="searchDG">
                <label class="form-label">Đế giày: </label>
                <form:select path="idDe" class="form-control" onchange="submit()">
                    <form:option value="">Tất cả</form:option>
                    <form:options items="${listDeGiay}" itemLabel="loaide" itemValue="id"/>
                </form:select>
            </form:form>
        </div>
        <div class="col-2 col-md-2 col-sm-2">
            <form:form action="/quan-ly-san-pham/search-by-kichco" modelAttribute="searchKC">

                <label class="form-label">Kích cỡ: </label>
                <form:select path="idKC" class="form-control" onchange="submit()">
                    <form:option value="">Tất cả</form:option>
                    <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
                </form:select>

            </form:form>
        </div>
        <div class="col-2 col-md-2 col-sm-2">
            <form:form action="/quan-ly-san-pham/search-by-mausac" modelAttribute="searchFormByMau">

                <label class="form-label">Màu sắc:</label>
                <form:select path="idMau" class="form-control" onchange="this.form.submit()">
                    <form:option value="">Tất cả</form:option>
                    <form:options items="${listMau}" itemLabel="ten" itemValue="id"/>
                </form:select>

            </form:form>
        </div>
        </br>

        <div class="col-2 col-md-2 col-sm-2">
            <form:form action="/quan-ly-san-pham/sort" modelAttribute="sortForm">
                <label class="form-label">Sắp xếp:</label>
                <form:select path="key" onchange="submit()" class="form-control">
                    <option value="0">---</option>
                    <form:option value="dongia">Đơn giá</form:option>
                    <form:option value="sl">Số lượng</form:option>
                </form:select>
            </form:form>
        </div>
    </div>
</div>
<table class="table">

    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
        <th>Trạng Thái</th>
        <th>Hình ảnh</th>
        <th>Chi tiết</th>
        <%--            <th>Action</th>--%>
    </tr>

    <tbody>
    <c:forEach items="${page.content}" var="sp" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${sp.sanPham.tenSP}</td>
            <td>${sp.donGia}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.trangThai==1?"Hoạt động":"Không hoạt động"}</td>
            <td>${sp.hinhAnh}
                <img src="/image/${sp.hinhAnh}" height="70px;" width="70px;">
            </td>
            <td>${sp.moTaCT}</td>
            <td>
                <a href="/quan-ly-san-pham/view-update/${sp.id}" class="btn btn-warning"><i
                        class="bi bi-pencil-square"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <nav aria-label="Page navigation text-center">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="/admin/quan-ly-san-pham?p=0">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/admin/quan-ly-san-pham?p=${page.number-1}"><<</a></li>
            <li class="page-item"><a class="page-link" href="/admin/quan-ly-san-pham?p=${page.number+1}">>></a></li>
            <li class="page-item"><a class="page-link"
                                     href="/admin/quan-ly-san-pham?p=${page.totalPages-1}">Next</a></li>
        </ul>
    </nav>
</div>
</div>
<script>
    function submitForm() {
        document.getElementById('searchMauSac').submit();
    }
</script>