<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/5/10
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/AdminLTE.css">
    <link rel="stylesheet" href="css/_all-skins.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/ionicons.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript" src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML" ></script>
    <script>
        $(function () {
            $("#option").change(function () {
                location.href="input?count=" + $("#option option:selected").val()
            })
        })
    </script>
</head>
<body style="text-align: center">
<h1>请输入你要求的方程阶数</h1>
<form >
    <select  name="count" id="option" class="form-control center-block" style="width: 200px">
        <option value='' disabled selected style='display:none;'>Please Choose</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </select>
</form>
</body>
</html>
