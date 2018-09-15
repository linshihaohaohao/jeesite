<%--
  Created by IntelliJ IDEA.
  User: lsh
  Date: 2018/9/10
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>歌曲管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {

        });
        function page(n,s){
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/song/list">歌曲列表</a></li>
    <li><a href="${ctx}/song/form">歌曲添加</a></li>
</ul>
<form:form id="searchForm" modelAttribute="song" action="${ctx}/song/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <label>歌名：</label><form:input path="songName" htmlEscape="false" maxlength="50" class="input-small"/>&nbsp;
    <ul class="ul-form">
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>歌名</th>
        <th>歌手</th>
        <th>作曲</th>
        <th>作词</th>
        <th>创建者</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="song">
        <tr>
            <td>${song.songName}</td>
            <td>${fns:getDictLabel(song.singer,'singer','无分类')}</td>
            <td>${song.composer}</td>
            <td>${song.lyricist}</td>
            <td>${song.createBy.no}</td>
            <%--<td><a href="${ctx}/song/form?id=${song.id}"><fmt:formatDate value="${createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></a></td>--%>
            <td><a href="${adminPath}/song/form?id=${song.id}">
                <fmt:formatDate value="${song.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </a></td>
            <td><a href="${ctx}/song/form?id=${song.id}">
                <fmt:formatDate value="${song.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </a></td>
            <td>
                    ${song.remarks}
            </td>
            <td>
                <a href="${ctx}/song/form?id=${song.id}">修改</a>
                <a href="${ctx}/song/delete?id=${song.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
