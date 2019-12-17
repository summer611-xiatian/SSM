<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>滴答办公系统-部门列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/media/layui/css/layui.css" media="all">
    <script src="/media/js/jquery.min.js"></script>
    <script type="text/javascript">
        function goPage(select) {
         var pageSize =$(select).val();
            location.href="/getDepart/1/"+pageSize;
        }
        function jumpPage() {
            var number = $("#number").val();
            if(number<=0){
                number=1;
            }else if(!(/(^[1-9]\d*$)/.test(number))){
                alert("输入的页码非法")
                $("#number").val("");
                $("#number").focus();
            }else if(number>${pageUtils.pageCount}){
                    number=${pageUtils.pageCount}
            }
            location.href="/getDepart/"+number+"/${pageUtils.pageSize}";
        }
    </script>
</head>
<body>
<div class="layui-container">
    <table class="layui-table" id="tbdata" lay-filter="tbop">
        <thead>
        <tr>
            <td>序号</td>
            <td>部门名称</td>
            <td>部门人数</td>
            <td>成立日期</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageUtils.records}" var="dept">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.name}</td>
            <td>50</td>
            <td>${dept.createtime}</td>
            <td><a class="layui-btn layui-btn-mini" href="departupdate.html">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-mini"
                   lay-event="del" onclick="deleteCourse(${dept.id});">删除</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">
        <c:if test="${pageUtils.pageIndex!=1}">
        <a href="/getDepart/${pageUtils.pageIndex-1}/${pageUtils.pageSize}"
           class="layui-laypage-prev ${pageUtils.pageIndex==1?'layui-disabled':''}" data-page="0">
            <i class="layui-icon">&lt;</i>
        </a>
        </c:if>
        <c:if test="${pageUtils.pageIndex==1}">
            <a href="#"
               class="layui-laypage-prev ${pageUtils.pageIndex==1?'layui-disabled':''}" data-page="0">
                <i class="layui-icon">&lt;</i>
            </a>
        </c:if>

        <c:forEach begin="${pageUtils.numberStart}" end="${pageUtils.numberEnd}" var="num" step="1">
        <c:if test="${pageUtils.pageIndex==num}">
            <span style="color:greenyellow;font-weight: bold;">${num}</span>
        </c:if>
        <c:if test="${pageUtils.pageIndex!=num}">
        <a href="/getDepart/${num}/${pageUtils.pageSize}">${num}</a>
        </c:if>
        </c:forEach>
        <c:if test="${pageUtils.pageIndex!=pageUtils.pageCount}">
        <a href="/getDepart/${pageUtils.pageIndex+1}/${pageUtils.pageSize}"
           class="layui-laypage-next ${pageUtils.pageIndex==pageUtils.pageCount?'layui-disabled':''}" data-page="2">
        <i class="layui-icon">&gt;</i>
    </a>
        </c:if>
        <c:if test="${pageUtils.pageIndex==pageUtils.pageCount}">
            <a href="#"
               class="layui-laypage-next ${pageUtils.pageIndex==pageUtils.pageCount?'layui-disabled':''}" data-page="2">
                <i class="layui-icon">&gt;</i>
            </a>
        </c:if>

        <span class="layui-laypage-skip">到第
							   <input type="text" id="number" min="1" value="${pageUtils.pageIndex}" class="layui-input">页
								<button type="button" class="layui-laypage-btn" onclick="jumpPage()">确定</button>
							</span>
        <span class="layui-laypage-count">当前${pageUtils.pageIndex}/${pageUtils.pageCount}</span>
        <span class="layui-laypage-limits">
							    <select lay-ignore="" onchange="goPage(this);">
							        <option value="5" ${pageUtils.pageSize==5?"selected":""}>5 条/页</option>
									<option value="10" ${pageUtils.pageSize==10?"selected":""}>10 条/页</option>
									<option value="20" ${pageUtils.pageSize==20?"selected":""}>20 条/页</option>
									<option value="30" ${pageUtils.pageSize==30?"selected":""}>30 条/页</option>
									<option value="40" ${pageUtils.pageSize==40?"selected":""}>40 条/页</option>
							     </select>
							</span>
        <span class="layui-laypage-count">共${pageUtils.totalCount}条</span>
    </div>
</div>
<script src="/media/layui/layui.js"></script>

<script type="text/javascript">
    function deleteCourse(id){
        layui.use('table', function() {
            layer.confirm('是否确认删除部门?',function(index) {
            $.getJSON("/deleteDepart",{"id":id},function (result) {
                if(result.code=200){
                    layer.msg("删除成功", {icon : 6},function () {
                        window.location.reload();
                    });
                }else {
                    layer.msg("删除失败", {icon : 5});
                }
            });

            });
        });
    }
</script>


</body>
</html>
