<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UUID生成</title>
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
            $("#UUID").on("click", function () {
                uuid();
            })
        });

        function uuid(){
            $.ajax({
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded',
                url: 'tool/uuid.do',
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
    <h1>UUID生成</h1>
    <button class="size" id="UUID">生成</button>
    <br>
    <br>
    <br>
    <h2>UUID：</h2> <br>
    <br>
    <br>
    <label id="result" style="font-size: 30px"></label>
</div>
</body>
</html>