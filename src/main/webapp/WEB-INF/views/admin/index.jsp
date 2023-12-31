<%@ page pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Sidenav Light - SB Admin</title>
    <link href="/css/dashboard.css" rel="stylesheet"/>
    <link href="/images/logo.jpg" rel="icon"/>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-light">
    <!-- Navbar Brand-->
    <img src="/images/logo.jpg" style="width: 80px; height: 80px">
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
            class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
<%--        <div class="input-group">--%>
<%--            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."--%>
<%--                   aria-describedby="btnNavbarSearch"/>--%>
<%--            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>--%>
<%--        </div>--%>
    </form>
    <!-- Navbar-->
    <b style="color: black">${username}</b>
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">

            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false"><i class='fas fa-user-alt'  style='font-size:24px;color: black'></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li>${userLogged.username}</li>
                <li><a class="dropdown-item" href="#!">Settings</a></li>
                <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <li><a class="dropdown-item" href="/logout">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <a class="nav-link" href="/admin/thong-ke">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-line"></i></div>
                        Thống kê
                    </a>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts"
                       aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Quản lý sản phẩm
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/admin/quan-ly-san-pham">Sản phẩm</a>

                            <a class="nav-link" href="/admin/kich-co">Kích cỡ</a>
                            <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>


                            <a class="nav-link" href="/admin/loai-giay">Loại giày</a>
                         
                            <a class="nav-link" href="/admin/de-giay">Đế giày</a>

                            <a class="nav-link" href="/chat-lieu/hien-thi">Chất liệu</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
                       aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-user fa-fw"></i></div>
                        Quản lý tài khoản
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/nguoi-dung/hien-thi/nhan-vien">Nhân viên</a>
                            <a class="nav-link" href="/admin/kichco">Khách hàng</a>
                        </nav>
                    </div>
                    <a class="nav-link" href="charts.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-ambulance"></i></div>
                        Quản lý đơn hàng
                    </a>
                    <a class="nav-link" href="/hoa-don/hien-thi">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-money-bill-trend-up"></i></div>
                        Quản lý Hóa đơn
                    </a>
                    <a class="nav-link" href="/ban-hang/counter">
                        <div class="sb-nav-link-icon"><i class="fas fa-cart-plus"></i></div>
                        Bán hàng tại quầy
                    </a>
                </div>
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <jsp:include page="${view}"/>
            </div>
        </main>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/js/index.js"></script>
</body>
</html>
