<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<c:set var = "count" value = "0"/>
<c:forEach items = "${tasks}" var = "item">
    <c:if test="${count != item.categoryId}">
        <c:forEach items = "${categories}" var = "category">
            <c:if test="${category.id == item.categoryId}">
                <h3>${category.name}</h3>
                <a href="/task/obl">締め切り順に並び替える</a> <a href="/task/obc">未完了順に並び替える</a> <a href="/task/obd">カテゴリ順に並び替える</a> <br>
            </c:if>
        </c:forEach>
        <c:set var = "count" value="${item.categoryId}"/>
    </c:if>
    <div class = "task">
        <input type="radio" name = "did" value="${item.id}">
        <label for="${item.id}">${item.name}</label>
        <c:if test="${not empty item.deadline}"><p>期限：${SimpleDateFormat("yyyy-MM-dd").format(item.deadline.getTime())}</p></c:if>
        <c:if test="${empty item.deadline}"><p>期限：--------</p></c:if>
        <c:if test="${not empty item.memo}"><p>詳細：${item.memo}</p></c:if>
        <c:if test="${empty item.memo}"><p>詳細：--------</p></c:if>
<%--        <c:if test="${not empty item.completed}"><p>完了:${item.completed}</p>p></c:if>--%>
        <p>達成状況：${item.compleated?"完了":"未完了"}</p>
        <p><a href="/task/update?taskid=${item.id}">変更</a></p>
    </div>
    <br>
</c:forEach>