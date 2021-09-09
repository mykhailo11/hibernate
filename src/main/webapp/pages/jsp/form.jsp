<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<c:forEach var="department" items="${departments}">
    <div><c:out value="${department}"/></div>
</c:forEach>
</body>
</html>