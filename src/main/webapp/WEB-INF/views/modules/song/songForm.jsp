<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>歌曲管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function(error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/song/list">歌曲列表</a></li>
    <li class="active"><a href="${ctx}/song/form?id=${song.id}">歌曲单表<${not empty song.id?'修改':'添加'}>查看</a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="song" action="${ctx}/song/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">歌名：</label>
        <div class="controls">
            <input id="songName" name="songName" value="${song.songName}"  htmlEscape="false" maxlength="64" class="input-xlarge ">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">歌手：</label>
      <select id="singer" name="singer"  required input-medium>
      <c:forEach items="${fns:getDictList('singer')}" var="dictor" >
          <option value="${dictor.value}">${dictor.label}</option>
      </c:forEach>
      </select>


    </div>

    <div class="control-group">
        <label class="control-label">作曲：</label>
        <div class="controls">
            <input id="composer" name="composer" value="${song.composer}"  htmlEscape="false" maxlength="255" class="input-xlarge ">
        </div>
    </div>
    </div>

    <div class="control-group">
        <label class="control-label">作词：</label>
        <div class="controls">
            <form:input path="lyricist" htmlEscape="false" maxlength="255" class="input-xlarge "/>
        </div>
    </div>
    </div>

    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:input path="remarks" htmlEscape="false" maxlength="255" class="input-xlarge "/>
        </div>
    </div>
    </div>

    <div class="form-actions">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
            &nbsp;
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>
