<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Courses</title></head>
<body>
<h2>Available Courses</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Instructor</th><th>Credits</th><th>Action</th></tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>${course.credits}</td>
            <td>
                <form method="post" action="register/${course.id}">
                    <input type="submit" value="Register" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
