<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Student Details</h2>

<c:if test="${student != null}">
    <div style="background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);">
        <div style="margin-bottom: 15px;">
            <strong>ID:</strong> ${student.id}
        </div>
        <div style="margin-bottom: 15px;">
            <strong>Name:</strong> ${student.name}
        </div>
        <div style="margin-bottom: 15px;">
            <strong>Email:</strong> ${student.email}
        </div>
        <div style="margin-bottom: 15px;">
            <strong>Course:</strong> ${student.course}
        </div>
        <div style="margin-bottom: 15px;">
            <strong>Registration Date:</strong>
            ${student.registrationDate}
        </div>
    </div>

    <div style="margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/student/edit?id=${student.id}" class="btn">Edit</a>
        <a href="${pageContext.request.contextPath}/students" class="btn">Back to List</a>
    </div>

    <h3 style="margin-top: 30px;">Grades</h3>

    <c:if test="${empty grades}">
        <p>No grades found for this student.</p>
    </c:if>
    <c:forEach var="grade" items="${grades}">
        <p><strong>${grade.subject}:</strong> ${grade.grade}</p>
    </c:forEach>

    <h3 style="margin-top: 30px;">Add Grade</h3>
    <form action="${pageContext.request.contextPath}/grade/add" method="post">
        <input type="hidden" name="studentId" value="${student.id}" />

        <div class="form-group">
            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required />
        </div>

        <div class="form-group">
            <label for="grade">Grade:</label>
            <input type="text" id="grade" name="grade" required />
        </div>

        <button type="submit" class="btn">Add Grade</button>
    </form>
</c:if>

<c:if test="${student == null}">
    <div style="background: #ffe6e6; padding: 20px; border-radius: 5px;">
        <p>Student not found.</p>
    </div>
    <div style="margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/students" class="btn">Back to List</a>
    </div>
</c:if>

<%@ include file="footer.jsp" %>
