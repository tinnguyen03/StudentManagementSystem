<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Student List</h2>

<form action="${pageContext.request.contextPath}/students" method="get" style="margin-bottom: 1rem;">
    <input type="hidden" name="action" value="search" />
    <input type="text" name="keyword" placeholder="Search by ID, name or email" style="padding: 0.5rem; width: 300px;" />
    <button type="submit" class="btn">Search</button>
</form>

<c:if test="${students.size() == 0}">
    <p>No students found.</p>
</c:if>

<c:if test="${students.size() > 0}">
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.course}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/student/view?id=${student.id}" class="btn">View</a>
                        <a href="${pageContext.request.contextPath}/student/edit?id=${student.id}" class="btn">Edit</a>
                        <a href="${pageContext.request.contextPath}/student/delete?id=${student.id}" class="btn"
                           onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="${pageContext.request.contextPath}/student/new" class="btn">Add New Student</a>

<%@ include file="footer.jsp" %>
