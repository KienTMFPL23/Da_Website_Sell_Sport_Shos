<%@ page language="java" pageEncoding="UTF-8" %>

<link rel="stylesheet" type="text/css" href="../../../styles/bootstrap4/bootstrap.min.css">
<link href="../../../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="/styles/responsive.css">

<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
      rel="stylesheet">

<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="/css/style.css" rel="stylesheet">

<header class="header trans_300">

    <!-- Top Navigation -->

    <div class="top_nav">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="top_nav_left">free shipping on all u.s orders over $50</div>
                </div>
                <div class="col-md-6 text-right">
                    <div class="top_nav_right">
                        <ul class="top_nav_menu">
                            <!-- Currency / Language / My Account -->
                            <li class="currency">
                                <a href="#">
                                    usd
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="currency_selection">
                                    <li><a href="#">cad</a></li>
                                    <li><a href="#">aud</a></li>
                                    <li><a href="#">eur</a></li>
                                    <li><a href="#">gbp</a></li>
                                </ul>
                            </li>
                            <li class="language">
                                <a href="#">
                                    English
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="language_selection">
                                    <li><a href="#">French</a></li>
                                    <li><a href="#">Italian</a></li>
                                    <li><a href="#">German</a></li>
                                    <li><a href="#">Spanish</a></li>
                                </ul>
                            </li>
                            <li class="account">
                                <a href="#">
                                    My Account
                                    <i class="fa fa-angle-down"></i>
                                </a>
                                <ul class="account_selection">
                                    <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                    <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Main Navigation -->

    <div class="main_nav_container">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-right">
                    <div class="logo_container">

                        <img src="/images/logo.jpg" width="100px">
                        <a href="#">otimous<span>shop</span></a>
                    </div>
                    <nav class="navbar">
                        <ul class="navbar_menu">
                            <li><a href="#">home</a></li>
                            <li><a href="#">shop</a></li>
                            <li><a href="#">promotion</a></li>
                            <li><a href="#">pages</a></li>
                            <li><a href="#">blog</a></li>
                            <li><a href="contact.html">contact</a></li>
                        </ul>
                        <ul class="navbar_user">
                            <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                            <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                            <li class="checkout">
                                <a href="#">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <span id="checkout_items" class="checkout_items">2</span>
                                </a>
                            </li>
                        </ul>
                        <div class="hamburger_container">
                            <i class="fa fa-bars" aria-hidden="true"></i>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>

</header>
<!-- Topbar End -->


<!-- Page Header Start -->
<div class="container-fluid bg-secondary mb-5" style="margin-top: 100px">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px;background-color: white" >
        <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="">Home</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0">Shopping Cart</p>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Cart Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <div class="col-lg-8 table-responsive mb-5">
            <table class="table table-bordered text-center mb-0">
                <thead class="bg-secondary text-dark">
                <tr>
                    <th>Products</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
                </thead>
                <tbody class="align-middle">
                <tr>
                    <td class="align-middle"><img src="img/product-1.jpg" alt="" style="width: 50px;"> Colorful Stylish
                        Shirt
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle"><img src="img/product-2.jpg" alt="" style="width: 50px;"> Colorful Stylish
                        Shirt
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle"><img src="img/product-3.jpg" alt="" style="width: 50px;"> Colorful Stylish
                        Shirt
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle"><img src="img/product-4.jpg" alt="" style="width: 50px;"> Colorful Stylish
                        Shirt
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle"><img src="img/product-5.jpg" alt="" style="width: 50px;"> Colorful Stylish
                        Shirt
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">$150</td>
                    <td class="align-middle">
                        <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-lg-4">
            <form class="mb-5" action="">
                <div class="input-group">
                    <input type="text" class="form-control p-4" placeholder="Coupon Code">
                    <div class="input-group-append">
                        <button class="btn btn-primary">Apply Coupon</button>
                    </div>
                </div>
            </form>
            <div class="card border-secondary mb-5">
                <div class="card-header bg-secondary border-0">
                    <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                </div>
                <div class="card-body">
                    <div class="d-flex justify-content-between mb-3 pt-1">
                        <h6 class="font-weight-medium">Subtotal</h6>
                        <h6 class="font-weight-medium">$150</h6>
                    </div>
                    <div class="d-flex justify-content-between">
                        <h6 class="font-weight-medium">Shipping</h6>
                        <h6 class="font-weight-medium">$10</h6>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <div class="d-flex justify-content-between mt-2">
                        <h5 class="font-weight-bold">Total</h5>
                        <h5 class="font-weight-bold">$160</h5>
                    </div>
                    <button class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->


<button class="btn btn-block btn-primary my-3 py-3" style="width: 200px;margin-left: 800px;font-size: 25px;">Buy</button>

<!-- Newsletter -->

<div class="newsletter">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center">
                    <h4>Newsletter</h4>
                    <p>Subscribe to our newsletter and get 20% off your first purchase</p>
                </div>
            </div>
            <div class="col-lg-6">
                <form action="post">
                    <div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
                        <input id="newsletter_email" type="email" placeholder="Your email" required="required"
                               data-error="Valid email is required.">
                        <button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300"
                                value="Submit">subscribe
                        </button>
                    </div>
                </form>
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
                        <span style="color: black">Trịnh Văn Bô, Nam Từ Liêm, Hà Nội</span>
                    </div>
                    <div style="display: flex;margin-left: 10px;margin-top: 20px"
                    >
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" color="black"
                             height="25" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                            <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                        </svg>
                        <span style="margin-left: 10px; color: black">0987654321</span>
                    </div>
                    <div style="display: flex;margin-left: 10px;margin-top: 20px">
                        <svg color="black" xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                             fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
                        </svg>
                        <span style="margin-left: 10px;color: black"> caodangfpt@fpt.edu.vn</span>
                    </div>
                </div>
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4" style="font-size: 20px;font-weight: bold">Về chúng
                        tôi</h6>
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


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="/lib/easing/easing.min.js"></script>
<script src="/lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="/mail/jqBootstrapValidation.min.js"></script>
<script src="/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="/js/main.js"></script>

<script type="text/javascript"
        src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
        src="/styles/bootstrap4/popper.js"></script>
<script type="text/javascript"
        src="/styles/bootstrap4/bootstrap.min.js"></script>
<script type="text/javascript"
        src="/plugins/Isotope/isotope.pkgd.min.js"></script>
<script type="text/javascript"
        src="/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script type="text/javascript"
        src="/plugins/easing/easing.js"></script>
<script type="text/javascript" src="/js/custom.js"></script>