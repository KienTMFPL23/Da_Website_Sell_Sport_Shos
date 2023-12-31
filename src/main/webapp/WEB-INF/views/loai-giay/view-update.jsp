<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<style>
    .form {
        width: 500px;
        height: 300px;
        background-color: #F89A86;
        color: white;
        margin: 0 auto;
        margin-top: 150px;
    }

    input {
        margin-right: 10px;
        width: 390px;
        border-radius: 10px;
        border: none;
        height: 30px;

    }

    .input {
        display: flex;
        justify-content: space-between;
        margin-top: 30px;
    }

    .input p {
        margin-left: 10px;
    }

    h3 {
        text-align: center;
    }

    .btn {


    }
    #but{
        margin-left: 210px;
        width: 80px;
        margin-top: 30px;
        border-radius: 10px;
        background-color: #FFE8A3;
    }

</style>
<div class="container">
    <div class="form">

        <form:form modelAttribute="lg">
            <h3> Sửa loại giày</h3>
            <div class="input" style="">
                <p>Mã:</p> <form:input path="ma"></form:input>
            </div>
            <form:errors path="ma"></form:errors>
            <div style="margin-left: 10px;color: red">${errorMa}</div>
            <div class="input">
                <p>Loại giày:</p> <form:input path="tentheloai"></form:input>
            </div>
            <form:errors path="tentheloai"></form:errors>
            <div style="margin-left: 10px;color: red">${errorTen}</div>
            <div class="button1">
                <button formaction="/admin/loai-giay/update/${id}" type="submit" id="but" class="btn">SUBMIT</button>
            </div>
        </form:form>
    </div>
</div>