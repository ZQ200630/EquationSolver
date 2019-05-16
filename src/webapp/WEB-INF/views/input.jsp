<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/5/10
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input</title>
    <script type="text/x-mathjax-config">
                MathJax.Hub.Config({"HTML-CSS": { preferredFont: "TeX", availableFonts: ["STIX","TeX"], linebreaks: { automatic:true }, EqnChunk: (MathJax.Hub.Browser.isMobile ? 10 : 50) },
                                    tex2jax: { inlineMath: [ ["$", "$"], ["\\\\(","\\\\)"] ], displayMath: [ ["$$","$$"], ["\\[", "\\]"] ], processEscapes: true, ignoreClass: "tex2jax_ignore|dno" },
                                    TeX: {  noUndefined: { attributes: { mathcolor: "red", mathbackground: "#FFEEEE", mathsize: "90%" } } },
                                    messageStyle: "none"
                });
         </script>
    <script type="text/javascript" src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML" ></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/AdminLTE.css">
    <link rel="stylesheet" href="css/_all-skins.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/ionicons.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
        $(function () {
            $("#back").click(function () {
                location.href="/test1"
            })
        })
    </script>
    <link rel="dns-prefetch" href="//cdn.bootcss.com" />
    <link rel="dns-prefetch" href="//cdn.mathjax.org" />
    <style>
        input{
            border: 1px solid #ccc;
            padding: 7px 0px;
            border-radius: 3px;
            padding-left:5px;
            width: 50px;
            height: 30px;
            margin-bottom: 10px;
        }
        form{
            margin-top: 40px;
        }
    </style>
</head>
<body>
<div class="text-center">
<form name="form" id="form" action="calculate" method="post">
    <input type="hidden" name="count" value="${count}">
<%for(int i = 1; i <= Integer.valueOf(request.getParameter("count")); i++){ %>
<div>
    <%for(int j = 1; j <= Integer.valueOf(request.getParameter("count")); j++){%>
    <%if(j == Integer.valueOf(request.getParameter("count"))){ %>
    <input type="text" name="x<%=String.valueOf(i)%><%=String.valueOf(j)%>"> $x_{<%=j%>}$ =
    <%break;}%>
    <input type="text" name="x<%=String.valueOf(i)%><%=String.valueOf(j)%>"> $x_{<%=j%>}$ +
    <%}%>
    <input type="text" name="y<%=String.valueOf(i)%>">
</div>
<%}%>
    <input type="submit" value="提交" id="submit">
    <input type="button" value="返回" id="back">
</form>
</div>
</body>
</html>
