<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Список пользователей</title>
</head>
<body>

<h3>Все пользователи:</h3>(<a href="${pageContext.request.contextPath}/user/add.jsp">Add</a>)
<ol>
  <c:forEach items="${users}" var="user">
    <li>
        ${user.name} ${user.lastName} - ${user.age}
      <a href="${pageContext.request.contextPath}/user?edit=${user.id}">Edit</a>
          | <a href="${pageContext.request.contextPath}/user?delete=${user.id}">Remove</a>
    </li>
  </c:forEach>
</ol>

</body>
</html>