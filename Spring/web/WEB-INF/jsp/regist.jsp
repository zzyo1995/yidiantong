<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="application/javascript" src="/js/jquery-2.2.4.min.js"></script>
    <title>Register</title>
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
            var json = {
                        uid: 10,
                        uname: "zzyo",
                        upass: "zzyo",
                        email: "zzyo",
                        mac: "zzyo"
                    }; //序列化成JSON
            $.ajax({
                url : "regist",
                type : "post",
                dataType : "json",
                contentType : "application/json; charset=utf-8",
                data : JSON.stringify(data),
                success : function(text) {
                    //window.location.href = "main/frame";enctype='application/json' action="regist"
                }
            });
        }
    </script>
</head>
<body>
<form id="form" name="form" method="post">
    <%--ID:<input type="text" name="uid"><br>--%>
    用户名：<input type="text" name="uname"><br>
    密码：<input type="text" name="upass"><br>
    Email：<input type="text" name="email"><br>
    MAC：<input type="text" name="mac"><br>
    <input type="button" value="提交" onclick="postjson()"/>
</form>

</body>
</html>