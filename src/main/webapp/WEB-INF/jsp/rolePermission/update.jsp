<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>分配角色</title>
</head>
<body>
<div class="pd-20">
    <form action="updateAdminUserRole.do">
        <input type="hidden" name="adminUserId" value="${adminUserId }" />
        <table class="table table-border table-bordered table-bg table-hover" >
            <thead>
                <tr>
                    <th>选中</th>
                    <th>角色名称</th>
                    <th>角色描述</th>
                </tr>
            </thead>
            <tbody>
                    
              
                    
            </tbody>
        </table>
        <br>
        <input class="btn btn-primary radius" type="submit" value="分配角色" />
        <input class="btn btn-default radius" type="button" value="关闭" onclick="location.href='list.do'" style="margin-left: 30px;" />
    </form>
</div>
</body>
</html>