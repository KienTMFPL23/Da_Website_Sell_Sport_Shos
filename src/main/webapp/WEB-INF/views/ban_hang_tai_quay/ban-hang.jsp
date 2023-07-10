<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav data-bs-spy="scroll" class="nav navbar-expand-lg " style="background-color: #e3f2fd;">
            <a><label>HD1</label> </a>
            <a href="#"><img src="/images/plus.png" style="margin-top: 8px"></a>
        </nav>
    </div>
    <br>
    <div class="row">
        <div class="col-lg-4">
            <div class="mb-3">
                <form:form method="get" modelAttribute="searchForm">
                    <form class="d-flex" role="search">
                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                        <form:input path="keyword" style="width: 250px"/>
                    </form>
                </form:form>
            </div>
        </div>
        <div class="col-lg-3">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Tìm kiếm nâng cao
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <a href="#" class="btn btn-primary">Quét QR</a>
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
                    <div class="row">
                        <p>Khách hàng: <input class="form-control"><a href="#"><img src="/images/plus.png"></a></p>
                        <p>Nhân viên bán hàng: <input class="form-control"></p>
                        <p>Tổng tiền : 3500$</p>
                        <p>Giảm giá : 3500$</p>
                        <p>Tổng tiền phải thu : 0$</p>
                        <p>Tiền khách đưa: <input class="form-control"></p>
                        <p>Tiền thừa: 0$ </p>
                    </div>
                    <div class="dropdown mt-3">
                        <button class="btn btn-primary">In hóa đơn</button>
                        <button class="btn btn-primary">Thanh toán</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <p>Giỏ hàng chi tiết</p>
    <table class="table table-bordered">
        <thead class="table table-primary">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Thành tiền</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td><input type="number" class="form-control"
                       min="1"
                       name="quantity"
                       value="${item.quantity}"
                       onblur="this.form.submit()"
                       style="width:100px;"></td>
            <td>upto 5000$</td>
            <td>5000$</td>
            <td><a href="#"><img src="/images/delete.png"> </a></td>
        </tr>
        </tbody>
    </table>
    <p style="text-align: left;color: red" >Tổng tiền: upto 3500M</p>
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
</body>
</html>