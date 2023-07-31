<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<link rel="stylesheet" href="index.css">--%>
<%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"--%>
<%--      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"--%>
<%--        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<div >--%>
<%--    <jsp:include page="navbar.jsp"></jsp:include>--%>
<%--</div>--%>
<link rel="stylesheet" type="text/css" href="../../../styles/bootstrap4/bootstrap.min.css">
<link href="../../../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="/styles/responsive.css">

<div class="super_container">
    <!-- Header -->

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

    <div class="fs_menu_overlay"></div>
    <div class="hamburger_menu">
        <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
        <div class="hamburger_menu_content text-right">
            <ul class="menu_top_nav">
                <li class="menu_item has-children">
                    <a href="#">
                        usd
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="menu_selection">
                        <li><a href="#">cad</a></li>
                        <li><a href="#">aud</a></li>
                        <li><a href="#">eur</a></li>
                        <li><a href="#">gbp</a></li>
                    </ul>
                </li>
                <li class="menu_item has-children">
                    <a href="#">
                        English
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="menu_selection">
                        <li><a href="#">French</a></li>
                        <li><a href="#">Italian</a></li>
                        <li><a href="#">German</a></li>
                        <li><a href="#">Spanish</a></li>
                    </ul>
                </li>
                <li class="menu_item has-children">
                    <a href="#">
                        My Account
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="menu_selection">
                        <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                        <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                    </ul>
                </li>
                <li class="menu_item"><a href="#">home</a></li>
                <li class="menu_item"><a href="#">shop</a></li>
                <li class="menu_item"><a href="#">promotion</a></li>
                <li class="menu_item"><a href="#">pages</a></li>
                <li class="menu_item"><a href="#">blog</a></li>
                <li class="menu_item"><a href="#">contact</a></li>
            </ul>
        </div>
    </div>

    <!-- Slider -->

    <div class="main_slider">
        <img src="/images/banner_giay2.jpg" style="width: 100%">
    </div>

    <!-- Banner -->

    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="banner_item align-items-center" style="background-image:url(/images/banner_giaynu.png)">
                        <div class="banner_category">
                            <a href="/home/category">Giày Nữ</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="banner_item align-items-center"
                         style="background-image:url(/images/banner_giaynam.jpg)">
                        <div class="banner_category">
                            <a href="/home/category">Giày Nam</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- New Arrivals -->

    <div class="new_arrivals">
        <div class="container">
            <div class="row">
                <div class="col text-center">
                    <div class="section_title new_arrivals_title">
                        <h2>New Arrivals</h2>
                    </div>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col text-center">
                    <div class="new_arrivals_sorting">
                        <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">
                            <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked"
                                data-filter="*">
                                Tất cả
                            </li>
                            <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                                data-filter=".men">
                                Nam
                            </li>
                            <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                                data-filter=".women">
                               Nữ
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="product-grid"
                 data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

                <!-- Product 1 -->

               <a href="/home/detail">
                   <div class="product-item men">
                       <div class="product discount product_filter">
                           <div class="product_image">
                               <img src="../../../images/product_1.png" alt="">
                           </div>
                           <div class="favorite favorite_left"></div>
                           <div class="product_info">
                               <h6 class="product_name"><a href="single.html">Fujifilm X100T 16 MP Digital Camera
                                   (Silver)</a></h6>
                               <div class="product_price">$520.00<span>$590.00</span></div>
                           </div>
                       </div>
                       <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                   </div>
               </a>

                <!-- Product 2 -->

                <div class="product-item women">
                    <div class="product product_filter">
                        <div class="product_image">
                            <img src="/images/banner_giaynu.png" alt="">
                        </div>
                        <div class="favorite"></div>
                        <div class="product_info">
                            <h6 class="product_name"><a href="single.html">Samsung CF591 Series Curved 27-Inch
                                FHD Monitor</a></h6>
                            <div class="product_price">$610.00</div>
                        </div>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                </div>

                <!-- Product 3 -->

                <div class="product-item women">
                    <div class="product product_filter">
                        <div class="product_image">
                            <img src="../../../images/product_3.png" alt="">
                        </div>
                        <div class="favorite"></div>
                        <div class="product_info">
                            <h6 class="product_name"><a href="single.html">Blue Yeti USB Microphone Blackout
                                Edition</a></h6>
                            <div class="product_price">$120.00</div>
                        </div>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                </div>

                <!-- Product 4 -->

                <div class="product-item women">
                    <div class="product product_filter">
                        <div class="product_image">
                            <img src="../../../images/product_4.png" alt="">
                        </div>
                        <div class="favorite favorite_left"></div>
                        <div class="product_info">
                            <h6 class="product_name"><a href="single.html">DYMO LabelWriter 450 Turbo Thermal
                                Label Printer</a></h6>
                            <div class="product_price">$410.00</div>
                        </div>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                </div>

                <!-- Product 5 -->

                <div class="product-item women men">
                    <div class="product product_filter">
                        <div class="product_image">
                            <img src="/images/product_5.png" alt="">
                        </div>
                        <div class="favorite"></div>
                        <div class="product_info">
                            <h6 class="product_name"><a href="single.html">Pryma Headphones, Rose Gold &
                                Grey</a></h6>
                            <div class="product_price">$180.00</div>
                        </div>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                </div>


            </div>
        </div>
    </div>
</div>
</div>

<!-- Best Sellers -->

<div class="best_sellers">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <div class="section_title new_arrivals_title">
                    <h2>Best Sellers</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="product_slider_container">
                    <div class="owl-carousel owl-theme product_slider">

                        <!-- Slide 1 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item">
                                <div class="product discount">
                                    <div class="product_image">
                                        <img src="/images/product_1.png" alt="">
                                    </div>
                                    <div class="favorite favorite_left"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Fujifilm X100T 16 MP Digital
                                            Camera (Silver)</a></h6>
                                        <div class="product_price">$520.00<span>$590.00</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 2 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item women">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="" alt="">
                                    </div>
                                    <div class="favorite"></div>

                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Samsung CF591 Series Curved
                                            27-Inch FHD Monitor</a></h6>
                                        <div class="product_price">$610.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 3 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item women">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="../../../images/product_3.png" alt="">
                                    </div>
                                    <div class="favorite"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Blue Yeti USB Microphone
                                            Blackout Edition</a></h6>
                                        <div class="product_price">$120.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 4 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item accessories">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="../../../images/product_4.png" alt="">
                                    </div>
                                    <div class="favorite favorite_left"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">DYMO LabelWriter 450 Turbo
                                            Thermal Label Printer</a></h6>
                                        <div class="product_price">$410.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 5 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item women men">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="../../../images/product_5.png" alt="">
                                    </div>
                                    <div class="favorite"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Pryma Headphones, Rose Gold &
                                            Grey</a></h6>
                                        <div class="product_price">$180.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 6 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item accessories">
                                <div class="product discount">
                                    <div class="product_image">
                                        <img src="images/product_6.png" alt="">
                                    </div>
                                    <div class="favorite favorite_left"></div>
                                    <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
                                        <span>-$20</span></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Fujifilm X100T 16 MP Digital
                                            Camera (Silver)</a></h6>
                                        <div class="product_price">$520.00<span>$590.00</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 7 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item women">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="images/product_7.png" alt="">
                                    </div>
                                    <div class="favorite"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Samsung CF591 Series Curved
                                            27-Inch FHD Monitor</a></h6>
                                        <div class="product_price">$610.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 8 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item accessories">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="images/product_8.png" alt="">
                                    </div>
                                    <div class="favorite"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Blue Yeti USB Microphone
                                            Blackout Edition</a></h6>
                                        <div class="product_price">$120.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 9 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item men">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="images/product_9.png" alt="">
                                    </div>
                                    <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
                                        <span>sale</span></div>
                                    <div class="favorite favorite_left"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">DYMO LabelWriter 450 Turbo
                                            Thermal Label Printer</a></h6>
                                        <div class="product_price">$410.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 10 -->

                        <div class="owl-item product_slider_item">
                            <div class="product-item men">
                                <div class="product">
                                    <div class="product_image">
                                        <img src="images/product_10.png" alt="">
                                    </div>
                                    <div class="favorite"></div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a href="single.html">Pryma Headphones, Rose Gold &
                                            Grey</a></h6>
                                        <div class="product_price">$180.00</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Slider Navigation -->

                    <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                        <i class="fa fa-chevron-left" aria-hidden="true"></i>
                    </div>
                    <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                        <i class="fa fa-chevron-right" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Benefit -->

<div class="benefit">
    <div class="container">
        <div class="row benefit_row">
            <div class="col-lg-3 benefit_col">
                <div class="benefit_item d-flex flex-row align-items-center">
                    <div class="benefit_icon"><i class="fa fa-truck" aria-hidden="true"></i></div>
                    <div class="benefit_content">
                        <h6>free shipping</h6>
                        <p>Suffered Alteration in Some Form</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 benefit_col">
                <div class="benefit_item d-flex flex-row align-items-center">
                    <div class="benefit_icon"><i class="fa fa-money" aria-hidden="true"></i></div>
                    <div class="benefit_content">
                        <h6>cach on delivery</h6>
                        <p>The Internet Tend To Repeat</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 benefit_col">
                <div class="benefit_item d-flex flex-row align-items-center">
                    <div class="benefit_icon"><i class="fa fa-undo" aria-hidden="true"></i></div>
                    <div class="benefit_content">
                        <h6>45 days return</h6>
                        <p>Making it Look Like Readable</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 benefit_col">
                <div class="benefit_item d-flex flex-row align-items-center">
                    <div class="benefit_icon"><i class="fa fa-clock-o" aria-hidden="true"></i></div>
                    <div class="benefit_content">
                        <h6>opening all week</h6>
                        <p>8AM - 09PM</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Blogs -->

<div class="blogs">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <div class="section_title">
                    <h2>Latest Blogs</h2>
                </div>
            </div>
        </div>
        <div class="row blogs_container">
            <div class="col-lg-4 blog_item_col">
                <div class="blog_item">
                    <div class="blog_background" style="background-image:url(../../../images/blog_1.jpg)"></div>
                    <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                        <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                        <span class="blog_meta">by admin | dec 01, 2017</span>
                        <a class="blog_more" href="#">Read more</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 blog_item_col">
                <div class="blog_item">
                    <div class="blog_background" style="background-image:url(../../../images/blog_2.jpg)"></div>
                    <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                        <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                        <span class="blog_meta">by admin | dec 01, 2017</span>
                        <a class="blog_more" href="#">Read more</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 blog_item_col">
                <div class="blog_item">
                    <div class="blog_background" style="background-image:url(../../../images/blog_3.jpg)"></div>
                    <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                        <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                        <span class="blog_meta">by admin | dec 01, 2017</span>
                        <a class="blog_more" href="#">Read more</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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

</div>

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
<script>
    var tabLinks = document.querySelectorAll(".tablinks");
    var tabContent = document.querySelectorAll(".tabcontent");

    tabLinks.forEach(function (el) {
        el.addEventListener("click", openTabs);
    });

    function openTabs(el) {
        var btn = el.currentTarget; // lắng nghe sự kiện và hiển thị các element
        var electronic = btn.dataset.electronic; // lấy giá trị trong data-electronic

        tabContent.forEach(function (el) {
            el.classList.remove("active");
        }); //lặp qua các tab content để remove class active

        tabLinks.forEach(function (el) {
            el.classList.remove("active");
        }); //lặp qua các tab links để remove class active

        document.querySelector("#" + electronic).classList.add("active");
        // trả về phần tử đầu tiên có id="" được add class active

        btn.classList.add("active");
        // các button mà chúng ta click vào sẽ được add class active
    }
</script>
