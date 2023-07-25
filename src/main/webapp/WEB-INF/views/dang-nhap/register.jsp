<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<br>
<br>

<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
    <title>
        Official Signup Form Flat Responsive widget Template :: w3layouts
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta
            name="keywords"
            content="Official Signup Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
    />
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- fonts -->
    <link
            href="//fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
            rel="stylesheet"
    />
    <link href="//fonts.googleapis.com/css?family=Monoton" rel="stylesheet"/>
    <!-- /fonts -->
    <!-- css -->
    <link
            href="css/font-awesome.min.css"
            rel="stylesheet"
            type="text/css"
            media="all"
    />
    <link href="css/login.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- /css -->
</head>
<body>
<h1 class="w3ls">Official Signup Form</h1>
<div class="content-w3ls">
    <div class="content-agile1">

    </div>
    <div class="content-agile2">

        <p style="color: red; font-family: Raleway; font-size: 20px;text-align: center">${messageConfirmPass}</p>
        <form:form class="form-register" action="/register" method="post" modelAttribute="taikhoan" >
            <div class="form-control w3layouts">
                <form:input path="username" placeholder="Username" id="firstname"/>
            </div>

            <div class="form-control agileinfo">
                <form:input
                        type="password"
                        path="password"
                        placeholder="Password"
                        id="password1"
                        name="password"
                />
            </div>

            <div class="form-control agileinfo">
                <input
                        type="password"
                        placeholder="Confirm Password"
                        id="password2"
                        name="confirmpassword"
                />
            </div>


            <p id="message"></p>

            <input type="submit" class="register" value="Register" onclick="confirmPassword()"/>
        </form:form>



        <div class="sign-in-now">
            <a  href="/login">Sign in now</a>
        </div>

        <p class="wthree w3l">Fast Signup With Your Favourite Social Profile</p>
        <ul class="social-agileinfo wthree2">
            <li>
                <a href="#"><i class="fa fa-facebook"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-youtube"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-twitter"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-google-plus"></i></a>
            </li>
        </ul>
    </div>
    <div class="clear"></div>
</div>

</body>
</html>


