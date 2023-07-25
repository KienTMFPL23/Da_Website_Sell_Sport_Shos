<%@ page pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .container {
        background-color: #F2ECF1;
        height: auto;
        font-size: Regular;
    }

    .row {
        /*height: 90px;*/
        padding-top: 50px;
        display: flex;
        justify-content: space-between;
    }

    .item {
        width: 21%;
        height: 90px;
        background-color: #E51E1E;
        border-radius: 15px;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .item img {
        width: 80px;
        height: 52px;
    }

    .item3 img, .item2 img {
        width: 50px;
    }

    .item1 {
        background-color: #34B6D3;
    }

    .item2 {
        background-color: #FF6969;
    }

    .item3 {
        background-color: #3970B0;
    }

    .item4 {
        background-color: #00BA8D;
    }

    .title {
        color: white;
        font-size: 25px;
        float: right;
    }

    .content {
        float: right;
        color: white;
        font-size: 13px;
    }
    /* Tab Links */
    .tabs{
        margin-top: 30px;
        display:flex;
        background-color: #ECECEC;
        border-radius: 15px;
    }
    .tablinks {
        border: none;
        outline: none;
        cursor: pointer;
        width: 100%;
        padding: 1rem;
        font-size: 14px;
        font-weight:600;
        transition: 0.2s ease;


    }

    .tablinks:hover{
        background:white;
        color:black;
    }
    /* Tab active */
    .tablinks.active {
        background:white;
        color:black;
        border-top-left-radius: 15px;
        border-bottom-left-radius: 15px;
    }

    /* tab content */
    .tabcontent {
        display: none;
    }
    /* Text*/
    .tabcontent p {
        color: #333;
        font-size: 16px;
    }
    /* tab content active */
    .tabcontent.active {
        display: block;
    }
    .combobox{
        display: flex;
        margin-top: 30px;
        margin-bottom: 30px;
        font-weight: 600;
        /*display: flex;*/
        /*justify-content: space-between;*/
    }
    .cbb4,.cbb2,.cbb3{
        margin-left: 50px;
    }
    .cbb select,input{
        color: #A3A3A3;
        width: 150px;
        height: 30px;
        border: none;
    }
    .combobox button{
        width: 150px;
        height: 40px;
        border: none;
        background-color: #34B6D3;
        color: white;
        font-weight: 400;
        font-size: 20px;
        border-radius: 5px;
        margin-top: 30px;
        margin-left: 150px;
    }
</style>
<div class="container">
    <div class="row">
        <div class="item item1">
            <img src="/images/image 34.png">
            <div>
                <p class="title">12000</p>
                <p class="content">Sản phẩm đã bán</p>
            </div>
        </div>
        <div class="item item2">
            <img src="/images/users.png">
            <div>
                <p class="title">12000</p>
                <p class="content">Khách mua hàng</p>
            </div>
        </div>
        <div class="item item3">
            <img src="/images/cart alt_.png" width="70px">
            <div>
                <p class="title">12000</p>
                <p class="content">Khách mua hàng</p>
            </div>
        </div>
        <div class="item item4">
            <img src="/images/image 34.png">
            <div>
                <p class="title">12000</p>
                <p class="content">Sản phẩm bán chạy</p>
            </div>
        </div>
    </div>
    <!-- Tab links -->
    <div class="tabs">
        <button class="tablinks active" data-electronic="sanphamdaban">Sản phẩm đã bán</button>
        <button class="tablinks" data-electronic="banchaynhat">Sản phẩm bán chạy nhất</button>
        <button class="tablinks" data-electronic="slkhachmuahang">Số lượng khách mua hàng</button>
        <button class="tablinks" data-electronic="khachhangtiemnang">Khách hàng tiềm năng</button>
        <button class="tablinks" style="border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;" data-electronic="bankemnhat">Sản phẩm bán kém nhất</button>
    </div>

    <!-- Tab content -->
    <div class="wrapper_tabcontent">
        <div id="sanphamdaban" class="tabcontent active">
            <div class="combobox">
                <div class="cbb cbb1">
                    <p>Ngày bắt đầu</p>
                    <input type="date">
                </div>
                <div class="cbb cbb2">
                    <p>Ngày kết thúc</p>
                    <input type="date">
                </div>
                <div class="cbb cbb3">
                    <p>Lọc theo</p>
                    <select>
                        <option>Hôm nay</option>
                        <option>Hôm qua</option>
                        <option>Hôm qua</option>
                    </select>

                </div>
                <div class="cbb cbb4">
                    <p>Lọc theo</p>
                    <select>
                        <option>NV001</option>
                        <option>NV002</option>
                        <option>NV003</option>
                    </select>
                </div>
                <button>Tìm kiếm</button>
            </div>
            sanphamdaban
        </div>

        <div id="banchaynhat" class="tabcontent">
            <div class="combobox">
                <div class="cbb cbb1">
                    <p>Ngày bắt đầu</p>
                    <input type="date">
                </div>
                <div class="cbb cbb2">
                    <p>Ngày kết thúc</p>
                    <input type="date">
                </div>
                <div class="cbb cbb3">
                    <p>Lọc theo</p>
                    <select>
                        <option>Hôm nay</option>
                    </select>
                </div>
                <div class="cbb cbb4">
                    <p>Lọc theo</p>
                    <select>
                        <option>NV001</option>
                        <option>NV002</option>
                        <option>NV003</option>
                    </select>
                </div>
            </div>
            banchaynhat
        </div>

        <div id="slkhachmuahang" class="tabcontent">
            <div class="combobox">
                <div class="cbb cbb1">
                    <p>Ngày bắt đầu</p>
                    <input type="date">
                </div>
                <div class="cbb cbb2">
                    <p>Ngày kết thúc</p>
                    <input type="date">
                </div>
                <div class="cbb cbb3">
                    <p>Lọc theo</p>
                    <select>
                        <option>Hôm nay</option>
                    </select>
                </div>
                <div class="cbb cbb4">
                    <p>Lọc theo</p>
                    <select>
                        <option>NV001</option>
                        <option>NV002</option>
                        <option>NV003</option>
                    </select>
                </div>
            </div>
            khách mua hàng
        </div>
        <div id="khachhangtiemnang" class="tabcontent">
            <div class="combobox">
                <div class="cbb cbb1">
                    <p>Ngày bắt đầu</p>
                    <input type="date">
                </div>
                <div class="cbb cbb2">
                    <p>Ngày kết thúc</p>
                    <input type="date">
                </div>
                <div class="cbb cbb3">
                    <p>Lọc theo</p>
                    <select>
                        <option>Hôm nay</option>
                    </select>
                </div>
                <div class="cbb cbb4">
                    <p>Lọc theo</p>
                    <select>
                        <option>NV001</option>
                        <option>NV002</option>
                        <option>NV003</option>
                    </select>
                </div>
            </div>
            khách hàng tiềm năng
        </div>
        <div id="bankemnhat" class="tabcontent">
            <div class="combobox">
                <div class="cbb cbb1">
                    <p>Ngày bắt đầu</p>
                    <input type="date">
                </div>
                <div class="cbb cbb2">
                    <p>Ngày kết thúc</p>
                    <input type="date">
                </div>
                <div class="cbb cbb3">
                    <p>Lọc theo</p>
                    <select>
                        <option>Hôm nay</option>
                    </select>
                </div>
                <div class="cbb cbb4">
                    <p>Lọc theo</p>
                    <select>
                        <option>NV001</option>
                        <option>NV002</option>
                        <option>NV003</option>
                    </select>
                </div>
            </div>
            bán kém nhất
        </div>
    </div>
</div>
<script>
    var tabLinks = document.querySelectorAll(".tablinks");
    var tabContent =document.querySelectorAll(".tabcontent");

    tabLinks.forEach(function(el) {
        el.addEventListener("click", openTabs);
    });


    function openTabs(el) {
        var btn = el.currentTarget; // lắng nghe sự kiện và hiển thị các element
        var electronic = btn.dataset.electronic; // lấy giá trị trong data-electronic

        tabContent.forEach(function(el) {
            el.classList.remove("active");
        }); //lặp qua các tab content để remove class active

        tabLinks.forEach(function(el) {
            el.classList.remove("active");
        }); //lặp qua các tab links để remove class active

        document.querySelector("#" + electronic).classList.add("active");
        // trả về phần tử đầu tiên có id="" được add class active

        btn.classList.add("active");
        // các button mà chúng ta click vào sẽ được add class active
    }
</script>