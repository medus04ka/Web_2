<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tbody id="results">
<c:if test="${not empty sessionScope.results}">
    <c:forEach var="result" items="${sessionScope.results}">
         <c:if test="${result.error == null}">
        <tr>
            <td>${result.x != null ? result.x : 'undefined'}</td>
            <td>${result.y != null ? result.y : 'undefined'}</td>
            <td>${result.r != null ? result.r : 'undefined'}</td>
            <td>${result.serverTime != null ? result.serverTime : 'undefined'}</td>
            <td>${result.executeTime != null ? result.executeTime : 'undefined'}</td>
            <td>${result.data != null ? (result.data ? 'ЕСТЬ ПРОБИТИЕ' : 'УВЫ, НЕ ПРОБИЛ((') : 'undefined'}</td>
        </tr>
        </c:if>
    </c:forEach>
</c:if>
</tbody>
