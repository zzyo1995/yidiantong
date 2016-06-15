<%--
  Created by IntelliJ IDEA.
  User: zzyo
  Date: 2016/2/17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Varela+Round">
    <link rel="stylesheet" href="/css/login.css" type="text/css" />
    <script type="application/javascript" src="/js/jquery-2.2.4.min.js"></script>
    <title>Login</title>
    <script type="application/javascript">
        $.fn.serializeObject = function()
        {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

        function postjson() {
            var data = {};
            $("#form").serializeArray().map(function(x){data[x.name] = x.value;});
            /*var json = {
                uid: 10,
                uname: "zzyo",
                upass: "zzyo",
                email: "zzyo",
                mac: "zzyo"
            }; //序列化成JSON*/
            $.ajax({
                url : "login",
                type : "post",
                dataType : "json",
                contentType : "application/json; charset=utf-8",
                data : JSON.stringify(data),
                success : function(text) {
                }
            });
        }
    </script>
</head>
<body height="300dp">
<div id="login">
    <h2><span class="fontawesome-lock"></span>Sign In</h2>
    <form id="form" name="form">
        <fieldset>
            <p><label>Email</label></p>
            <p><input type="username" id="username" name="email" value=""></p>
            <p><label>Password</label></p>
            <p><input type="password" id="password" name="upass" value=""></p>
            <p><input type="button" value="Sign In" onclick="postjson()"></p>
        </fieldset>
    </form>
</div>
</body>
</html>
