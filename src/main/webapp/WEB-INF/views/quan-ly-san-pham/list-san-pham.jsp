<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<br>
<br>
<div class="container">
    <div class="mb-3">
        <form:form modelAttribute="searchForm" cssClass="text-center">
            <div class="row">
                <div class="col-1 col-md-1 col-sm-1">
                    <a href="/admin/quan-ly-san-pham" class="btn btn-primary"><i class="bi bi-house-fill"></i></a>
                </div>
                <div class="col-6 col-md-6 col-sm-6">
                    <form:input path="keyword" class="form-control"/>
                </div>
                <div class="col-2 col-md-2 col-sm-2">
                    <button class="btn btn-warning">Search</button>
                </div>
                <div class="col-3 col-md-3 col-sm-3">
                    <a href="/quan-ly-san-pham/view-add" class="btn btn-primary"><i class="bi bi-plus-circle-fill"></i>
                        Thêm mới
                        sản phẩm</a>
                    </br>
                </div>
            </div>
            </br>
            <label class="form-label">Loại giầy: </label>
            <form:select path="keyword">
                <form:option value="">Tất cả</form:option>
                <form:options items="${listLoaiGiay}" itemLabel="tentheloai" itemValue="id"/>
            </form:select>
            <label class="form-label">Màu sắc: </label>
            <form:select path="keyword">
                <form:option value="">Tất cả</form:option>
                <form:options items="${listMau}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <label class="form-label">Chất liệu: </label>
            <form:select path="keyword">
                <form:option value="">Tất cả</form:option>
                <form:options items="${listChatLieu}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <label class="form-label">Kích cỡ: </label>
            <form:select path="keyword">
                <form:option value="">Tất cả</form:option>
                <form:options items="${listKichCo}" itemLabel="size" itemValue="id"/>
            </form:select>
            <label class="form-label">Đế giày: </label>
            <form:select path="keyword">
                <form:option value="">Tất cả</form:option>
                <form:options items="${listDeGiay}" itemLabel="loaide" itemValue="id"/>
            </form:select>
        </form:form>
    </div>
    </br>
    <table class="table table-bordered">
        <thead class="table-danger">
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th><a href="/quan-ly-san-pham/sort" style="color: black;">Đơn giá</a></th>
            <th>Số lượng</th>
            <th>Trạng Thái</th>
            <th>Hình ảnh</th>
            <th>Chi tiết</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.content}" var="sp" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${sp.sanPham.tenSP}</td>
                <td>${sp.donGia}</td>
                <td>${sp.soLuong}</td>
                <td>${sp.trangThai==1?"Hoạt động":"Không hoạt động"}</td>
                <td>${sp.hinhAnh}</td>
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