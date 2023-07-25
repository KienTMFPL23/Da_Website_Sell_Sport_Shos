<%@ page language="java" pageEncoding="UTF-8" %>
<style>
    .navbar {
        display: flex;
    }

    .search {
        width: 350px;
        height: 40px;
        background-color: #D9D9D9;
        display: flex;
        justify-content: space-between;
        border-radius: 19px;
    }

    .search input {
        width: 314px;
        background-color: transparent;
        border: none;
        border-radius: 19px;
    }

    .search input::placeholder {
        padding-left: 20px;
    }

    .search input:checked {
        outline: none;
    }

    .search button {
        border: none;
        background-color: transparent;
        border-radius: 19px;
    }

    .hotline {
        background-color: #D9D9D9;
        width: 175px;
        height: 55px;
        display: flex;
        color: #E51E1E;
        font-weight: bold;
        justify-content: space-around;
        border-radius: 29px;
        border: 1px solid #E51E1E;
    }

    .navbar-menu {
        background-color: #E51E1E;
        height: 50px;
    }

    .menu ul {
        display: flex;
        justify-content: space-evenly;
    }

    ul li {
        list-style: none;
    }

    .nav-item a {
        color: white;
    }

    .dropdown-menu a {
        color: black;
    }

    .body-left {
        width: 300px;
        height: 333px;
        background-color: #F5F5F5;
        margin-top: 50px;
    }

    .vertical-line {
        width: 1px;
        background-color: black;
        height: 260px
    }

    .dmsp {
        position: relative;
    }

    .dmsp img {
        position: absolute;
        right: 0;
    }

    .dmsp-line {
        width: 30px;
        background-color: black;
        height: 1px;
        margin-top: 15px;
        margin-right: 5px
    }

    .body-right {
        width: 1000px;
    }

    .sanphammoi {
        width: 1000px;
        height: 369px;
        background-color: #F5F5F5;
    }

    .sanphambanchay {
        width: 1000px;
        height: 369px;
    }

    .col-3 button {
        height: 30px;
        width: 120px;
        border-radius: 5px;
        border: none;
        background-color: #D9D9D9;
        font-weight: 500;
        font-size: 15px;
        padding-bottom: 10px;
    }

    .footer {
        background-color: #847D7D;
    }
    .col-md-4 span{
        font-size: 13px;
    }
</style>
<div class="navbar">
    <div class="logo">
        <img src="/images/logo.jpg" width="150px">
    </div>
    <div class="search">
        <input placeholder="Tìm kiếm...">
        <button><img src="/images/search.png"></button>
    </div>
    <div style="display: flex;width: 390px;justify-content: space-between;margin-right: 30px">
        <div class="hotline">
            <label>HOTLINE<p> 0987654321</p></label>
            <img src="/images/24-hours.png" width="35px" height="35px" style="margin-top: 10px">
        </div>
        <img src="/images/user.png" style="width: 55px">
        <img src="/images/cart.png" style="width: 55px">
    </div>
</div>
<div class="menu">
    <nav class="navbar-menu">
        <ul class="nav-item">
            <li>
                <a class="nav-link">TRANG CHỦ</a>
            </li>
            <li>
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    SẢN PHẨM
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li>
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    GIÀY THỂ THAO
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link">LIÊN HỆ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link">GIỚI THIỆU</a>
            </li>
            <li class="nav-item">
                <a class="nav-link">TIN TỨC</a>
            </li>
        </ul>
    </nav>
</div>
<div class="banner">
    <img src="/images/slide_giay 1.png" width="1349px">
</div>
<div class="body" style="display: flex;justify-content: space-around ">
    <div class="body-left">
        <p style="text-align: center;font-weight: bold;font-size: 22px;padding-top: 10px">DANH MỤC SẢN PHẨM</p>
        <div style="width: 250px;margin: 0 auto;display: flex">
            <div class="vertical-line"></div>
            <div style="width: 249px;font-weight: bold;font-size: 20px">
                <div class="dmsp" style="display: flex;margin-top: 20px">
                    <div class="dmsp-line"></div>
                    Sandal
                    <img src="/images/next.png">
                </div>
                <div class="dmsp" style="display: flex;margin-top: 20px">
                    <div class="dmsp-line"
                    ></div>
                    Chạy bộ
                    <img src="/images/next.png">
                </div>
                <div class="dmsp" style="display: flex;margin-top: 20px">
                    <div class="dmsp-line"
                    ></div>
                    Đá bóng
                    <img src="/images/next.png">
                </div>
                <div class="dmsp" style="display: flex;margin-top: 20px">
                    <div class="dmsp-line"></div>
                    Thời trang
                    <img src="/images/next.png">
                </div>
                <div class="dmsp" style="display: flex;margin-top: 20px">
                    <div class="dmsp-line"></div>
                    Nike Air Max
                    <img src="/images/next.png">
                </div>
            </div>
        </div>
    </div>
    <div class="body-right">
        <h4 style="text-align: center;font-weight: bold;margin-top: 10px">SẢN PHẨM MỚI</h4>
        <hr width="700px" color="black">
        <hr width="700px" color="black">
        <div class="sanphammoi">
            <div class="col-3" style="padding-top: 10px">
                <img width="100%" height="256px"
                     src="https://kenh14cdn.com/2020/7/8/sneakerbeatt980786952386496440807699102621998261586840n-15941830338201855570678.jpg">
                <p style="text-align: center;font-size: 13px;font-weight: bold;padding-left: 10px;padding-right: 10px;margin-top: 10px">
                    Giày Nike Air Force 1 07 Low
                    Brown Beige White Orange Like</p>
                <div style="text-align: center">
                    <button>Thêm giỏ hàng</button>
                    <a><img width="30px" height="30px" src="/images/Eye.png"
                            style="background-color: #847D7D;border-radius: 5px;margin-left: 10px"></a>
                </div>
            </div>
        </div>
        <h4 style="text-align: center;font-weight: bold;margin-top: 20px;margin-bottom: 30px">SẢN PHẨM BÁN CHẠY</h4>
        <div class="sanphambanchay">
            <div class="col-3" style="padding-top: 10px">
                <img width="100%" height="256px"
                     src="https://kenh14cdn.com/2020/7/8/sneakerbeatt980786952386496440807699102621998261586840n-15941830338201855570678.jpg">
                <p style="text-align: center;font-size: 13px;font-weight: bold;padding-left: 10px;padding-right: 10px;margin-top: 10px">
                    Giày Nike Air Force 1 07 Low
                    Brown Beige White Orange Like</p>
                <div style="text-align: center">
                    <button>Thêm giỏ hàng</button>
                    <a><img width="30px" height="30px" src="/images/Eye.png"
                            style="background-color: #847D7D;border-radius: 5px;margin-left: 10px"></a>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class=" footer">
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3" style="padding-top: 50px;color: white">
                <div class="col-md-4 col-lg-3 col-xl-3 mb-md-0 mb-4">
                    <!-- Links -->
                    <div style="display: flex;margin-top: 20px">
                        <img src="/images/Home Address.png" width="40px" height="35px">
                        <span>Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</span>
                    </div>
                    <div style="display: flex;margin-left: 10px;margin-top: 20px"
                    ><svg xmlns="http://www.w3.org/2000/svg"  width="25" color="black"
                          height="25" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                        <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                    </svg>
                        <span  style="margin-left: 10px">0987654321</span>
                    </div>
                    <div style="display: flex;margin-left: 10px;margin-top: 20px">
                        <svg color="black" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                        </svg>
                       <span  style="margin-left: 10px"> caodangfpt@fpt.edu.vn</span>
                    </div>
                </div>
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4" style="font-size: 20px;font-weight: bold">Về chúng tôi</h6>
                    <p>
                        <a href="#!" class="text-reset">Trang chủ</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Giới thiệu</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Sản phẩm</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Tin tức</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4" style="font-size: 20px;font-weight: bold">Cửa hàng</h6>
                    <p>
                        <a href="#!" class="text-reset">Trang chủ</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Giới thiệu</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Sản phẩm</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Tin tức</a>
                    </p>
                </div>
            </div>
        </div>
    </section>
</footer>
