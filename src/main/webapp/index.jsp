<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>数独计算器</title>
    <style type="text/css">
        div {
            text-align: center;
            margin: 5px;
        }

        .input {
            width: 30px;
            height: 28px;
            font-size: 20px;
            text-align: center;
        }

        a{
            font-size: 30px;
        }
    </style>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#button").on("click", function () {
                send();
            });
        });

        function send() {
            $.ajax({
                type: 'post',
                contentType: 'application/x-www-form-urlencoded',
                url: 'tool/shuducal.do',
                data: $("form").serialize(),
                dataType: "json",
                success: function (data) {
                    fillData(data);
                },
                error: function (XMLHttpRequest) {
                    alert("HTTP错误： " + XMLHttpRequest.status);
                }
            });
        }

        function fillData(json) {
            if (json.status == 0) {
                alert(json.msg);
                var result = json["data"];
                for (var i = 0; i < 81; i++) {
                    var y = i % 9;
                    var x = (i - y) / 9;
                    $("input[name='shudu[" + i + "]']").val(result[x][y]);
                }
            } else {
                alert(json.msg);
            }
        }

        function display(data) {
            var userJson = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $("#showList").html(userJson);
        }
    </script>
</head>
<body>
<div>
    <h2>数独计算器</h2>
    <form action="tool/shuducal.do" method="post">
        <div>
            <input class="input" type="text" name="shudu[0]">
            <input class="input" type="text" name="shudu[1]">
            <input class="input" type="text" name="shudu[2]">
            &ensp;
            <input class="input" type="text" name="shudu[3]">
            <input class="input" type="text" name="shudu[4]">
            <input class="input" type="text" name="shudu[5]">
            &ensp;
            <input class="input" type="text" name="shudu[6]">
            <input class="input" type="text" name="shudu[7]">
            <input class="input" type="text" name="shudu[8]">
        </div>

        <div>
            <input class="input" type="text" name="shudu[9]">
            <input class="input" type="text" name="shudu[10]">
            <input class="input" type="text" name="shudu[11]">
            &ensp;
            <input class="input" type="text" name="shudu[12]">
            <input class="input" type="text" name="shudu[13]">
            <input class="input" type="text" name="shudu[14]">
            &ensp;
            <input class="input" type="text" name="shudu[15]">
            <input class="input" type="text" name="shudu[16]">
            <input class="input" type="text" name="shudu[17]">
        </div>

        <div>
            <input class="input" type="text" name="shudu[18]">
            <input class="input" type="text" name="shudu[19]">
            <input class="input" type="text" name="shudu[20]">
            &ensp;
            <input class="input" type="text" name="shudu[21]">
            <input class="input" type="text" name="shudu[22]">
            <input class="input" type="text" name="shudu[23]">
            &ensp;
            <input class="input" type="text" name="shudu[24]">
            <input class="input" type="text" name="shudu[25]">
            <input class="input" type="text" name="shudu[26]">
        </div>

        <hr width="18%" color="#FFFFFF" align="center">

        <div>
            <input class="input" type="text" name="shudu[27]">
            <input class="input" type="text" name="shudu[28]">
            <input class="input" type="text" name="shudu[29]">
            &ensp;
            <input class="input" type="text" name="shudu[30]">
            <input class="input" type="text" name="shudu[31]">
            <input class="input" type="text" name="shudu[32]">
            &ensp;
            <input class="input" type="text" name="shudu[33]">
            <input class="input" type="text" name="shudu[34]">
            <input class="input" type="text" name="shudu[35]">
        </div>

        <div>
            <input class="input" type="text" name="shudu[36]">
            <input class="input" type="text" name="shudu[37]">
            <input class="input" type="text" name="shudu[38]">
            &ensp;
            <input class="input" type="text" name="shudu[39]">
            <input class="input" type="text" name="shudu[40]">
            <input class="input" type="text" name="shudu[41]">
            &ensp;
            <input class="input" type="text" name="shudu[42]">
            <input class="input" type="text" name="shudu[43]">
            <input class="input" type="text" name="shudu[44]">
        </div>

        <div>
            <input class="input" type="text" name="shudu[45]">
            <input class="input" type="text" name="shudu[46]">
            <input class="input" type="text" name="shudu[47]">
            &ensp;
            <input class="input" type="text" name="shudu[48]">
            <input class="input" type="text" name="shudu[49]">
            <input class="input" type="text" name="shudu[50]">
            &ensp;
            <input class="input" type="text" name="shudu[51]">
            <input class="input" type="text" name="shudu[52]">
            <input class="input" type="text" name="shudu[53]">
        </div>

        <hr width="18%" color="#FFFFFF" align="center">

        <div>
            <input class="input" type="text" name="shudu[54]">
            <input class="input" type="text" name="shudu[55]">
            <input class="input" type="text" name="shudu[56]">
            &ensp;
            <input class="input" type="text" name="shudu[57]">
            <input class="input" type="text" name="shudu[58]">
            <input class="input" type="text" name="shudu[59]">
            &ensp;
            <input class="input" type="text" name="shudu[60]">
            <input class="input" type="text" name="shudu[61]">
            <input class="input" type="text" name="shudu[62]">
        </div>

        <div>
            <input class="input" type="text" name="shudu[63]">
            <input class="input" type="text" name="shudu[64]">
            <input class="input" type="text" name="shudu[65]">
            &ensp;
            <input class="input" type="text" name="shudu[66]">
            <input class="input" type="text" name="shudu[67]">
            <input class="input" type="text" name="shudu[68]">
            &ensp;
            <input class="input" type="text" name="shudu[69]">
            <input class="input" type="text" name="shudu[70]">
            <input class="input" type="text" name="shudu[71]">
        </div>


        <div>
            <input class="input" type="text" name="shudu[72]">
            <input class="input" type="text" name="shudu[73]">
            <input class="input" type="text" name="shudu[74]">
            &ensp;
            <input class="input" type="text" name="shudu[75]">
            <input class="input" type="text" name="shudu[76]">
            <input class="input" type="text" name="shudu[77]">
            &ensp;
            <input class="input" type="text" name="shudu[78]">
            <input class="input" type="text" name="shudu[79]">
            <input class="input" type="text" name="shudu[80]">
        </div>

        <hr width="18%" color="#FFFFFF" align="center">

        <input type="reset" name="重置">
        &emsp;
        <input type="button" id="button" name="button" value="计算">
    </form>

    <hr width="80%" color="#005566" align="center">

    <h3>其他工具</h3>
    <br>

    <a href="encode.jsp">MD5/(SHA-1,SHA-256)加密</a><br>
    <a href="uuid.jsp">UUID生成</a><br>
</div>

</body>
</html>