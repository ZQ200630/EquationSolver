<%@ page import="com.zq.entity.Fraction" %><%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/5/11
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Result</title>
</head>
<body>
<h1 class="center-block text-center">Result</h1>
<table class="table-bordered table-striped col-lg-2 col-lg-offset-5 col-sm-6 col-sm-offset-3">
    <tr>
        <th>$$x_n$$</th>
        <th>$$Value$$</th>
    </tr>
    <%Fraction frac[] = (Fraction[]) request.getAttribute("res");%>
    <%for(int a = 1; a <= Integer.valueOf(request.getParameter("count")); a++){ %>
    <tr>
        <td>$$x_<%=a%>$$</td>
        <%if (frac[a-1].getBottom() == 1) {%>
            <td>$$<%=frac[a-1].getTop()%>$$</td>
        <%}else{%>
            <td>$$\frac{<%=frac[a-1].getTop()%>}{<%=frac[a-1].getBottom()%>}$$</td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>


