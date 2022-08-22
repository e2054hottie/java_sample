<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>タスク新規作成</title>
    <%@ include file="../common/common.jsp"%>
</head>
<body>
<div class = "header">
    <header>
        <h2>タスク新規登録画面</h2>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="/task/insert" method="post">
        <div class="form-group">
            <label for="title">タスク名</label><br>
            <input type="text" class="form-control" name="name" id="title"><br>
            <label for="title">詳細</label><br>
            <input type="text" class="form-control" name="description" id="description"><br>
            <label for="title">期限日</label><br>
            <input type="date" class="form-control" name="limit" id="limit"><br>
            <label for="title">頻度</label><br>
            <select name="frequency">
                <option value="0">なし</option>
                <option value="1">毎週</option>
            </select><br>
            <label for="title">カテゴリー選択</label><br>
            <select name="categoryId">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.getId()}"><c:out value="${category.getName()}" /></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">送信</button>
    </form>
</div>
</body>
</html>