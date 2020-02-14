<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ветрина магазина</title>
</head>
<body>
    <h1>Каталог Автомобилей</h1>
    <ul>
        <form method = post>
            <li>
                <input type = "text" name = "name" value  = "Название">
                <input type = "text" name = "brand" value  = "Брэнд">
                <input type = "text" name = "cost" value  = "стоимость">
                <button type = "submit" name = "button" value = "add">Добавить</button>
            </li>
        </form>
        <jsp:useBean id="resultSet" scope="request" class="java.util.ArrayList"/>
        <c:forEach items = "${resultSet}" var = "node">
            <form method = "POST">
                <li>
                    <input type = "text" name = "name" value  = "${node[0]}">
                    <input type = "text" name = "brand" value  = "${node[1]}">
                    <input type = "text" name = "cost" value  = "${node[2]}">
                    <input type = "hidden" name = "id" value  = "${node[3]}">
                    <button type = "submit" name = "button" value = "delete">Удалить</button>
                    <button type = "submit" name = "button" value = "change">Изменить</button>
                </li>
            </form>
        </c:forEach>
    </ul>
</body>
</html>
