<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MD5/(SHA-1,SHA-256)加密</title>
    <style>
        div{
            text-align: center;
        }
        .size{
            width: 100px;
            height: 25px;
        }
    </style>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#MD5").on("click", function () {
                md5();
            });
            $("#SHA-1").on("click", function () {
                sha1();
            });
            $("#SHA-256").on("click", function () {
                sha256();
            });
        });

        function md5(){
            var origin = $("#origin").val();
            $.ajax({
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded',
                url: 'tool/encode.do',
                data: {
                    "origin": origin,
                    "algorithm":"MD5"
                },
                dataType: 'json',
                success: function (data) {
                    show(data);
                },
                error: function (XMLHttpRequest) {
                    alert("HTTP错误： " + XMLHttpRequest.status);
                }
            });
        }
        function sha1(){
            var origin = $("#origin").val();
            $.ajax({
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded',
                url: 'tool/encode.do',
                data: {
                    "origin": origin,
                    "algorithm":"SHA-1"
                },
                dataType: 'json',
                success: function (data) {
                    show(data);
                },
                error: function (XMLHttpRequest) {
                    alert("HTTP错误： " + XMLHttpRequest.status);
                }
            });
        }
        function sha256(){
            var origin = $("#origin").val();
            $.ajax({
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded',
                url: 'tool/encode.do',
                data: {
                    "origin": origin,
                    "algorithm":"SHA-256"
                },
                dataType: 'json',
                success: function (data) {
                    show(data);
                },
                error: function (XMLHttpRequest) {
                    alert("HTTP错误： " + XMLHttpRequest.status);
                }
            });
        }
        
        function show(data) {
            if (data.status == 0){
                $("#result").text(data.data);
            } else{
                alert(data.msg);
            }
        }
    </script>
</head>
<body>
<div>
    <h1>MD5/(SHA-1,SHA-256)加密</h1>
    <div>
        <label>输入框：</label>
        <input type="text" name="origin" width="100%" size="100px" id="origin">
    </div>
    <br>
    <br>
    <button class="size" id="MD5">MD5</button> &nbsp;&nbsp;
    <button class="size" id="SHA-1">SHA-1</button> &nbsp;&nbsp;
    <button class="size" id="SHA-256">SHA-256</button> &nbsp;&nbsp;
    <br>
    <br>
    <br>
    <h2>加密结果：</h2> <br>
    <br>
    <br>
    <label id="result" style="font-size: 30px"></label>
</div>
</body>
</html>