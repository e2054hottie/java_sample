<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
<head>
    <title>タスク編集</title>
    <%@ include file="../common/common.jsp"%>
</head>
<body>
<div class = "header">
    <header>
        <h2>タスク変更画面</h2>
        <%@ include file="../common/header.jsp"%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="/task/update?taskid=${currenttask.id}" method="post">
        <div class="form-group">
            <label for="title">タスク名</label><br>
            <input type="text" class="form-control" name="name" id="title" value="${currenttask.name}"><br>
            <label for="title">詳細</label><br>
            <input type="text" class="form-control" name="memo" id="description" value="${currenttask.memo}"><br>
            <label for="title">期限日</label><br>
            <input type="date" class="form-control" name="dead_line" id="limit" value="${SimpleDateFormat("yyyy-MM-dd").format(currenttask.deadline.getTime())}"><br>
            <label for="title">カテゴリー</label><br>
            <select name="categoryId" value="${currenttask.categoryId}">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}"><c:out value="${category.name}" /></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">送信</button>
    </form>
    <p><a href ="/task/delete?taskid=${currenttask.id}">削除</a></p>
</div>
</body>
</html>