<%--
  Created by IntelliJ IDEA.
  User: kosukehotta
  Date: 2022/06/01
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>カテゴリ登録ページ</title>
</head>
<body>
<h3>カテゴリ新規作成画面</h3>
<span class="label label-danger">${Error}</span>
<form action="/category/insert" method="post">
    <div class="form-group">
        <label>カテゴリ名</label>
        <input type="text" class="form-control"  data-cke-saved-name="name" name="name"><br>
        <%--<label for="title">氏名</label>
        <input type="text" class="form-control"  data-cke-saved-name="name" name="name"><br>
        <label for="title">メールアドレス</label>
        <input type="email" class="form-control"  data-cke-saved-name="email" name="email" id="title"><br>
        <label for="title">パスワード</label>
        <input type="text" class="form-control"  data-cke-saved-name="pass" name="pass">--%>
    </div>
    <button type="submit">登録</button>
</form>
</body>
</html>
