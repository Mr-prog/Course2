
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="ru">
    <jsp:useBean id="results" class="area.model.ResultsTable" scope="application" />
    <c:forEach var="record" items="${results.records}">
        <tr>
            <td>
                <c:out value="${record.startTime}" />
            </td>
            <td>
                <c:out value="${record.executionTimeNano}" />
            </td>
            <td>
                <c:out value="${record.r}" />
            </td>
            <td>
                <c:out value="${record.x}" />
            </td>
            <td>
                <c:out value="${record.y}" />
            </td>
            <td>
                <c:out value="${record.result}" />
            </td>
        </tr>
    </c:forEach>
    </html>