<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- bibliotheque core --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  <%-- encodage --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier!</h1>
        <jsp:include page="/jspCarte.jsp" flush="false" />
        <hr>
        <c:if test="${pasDeDessert}">pas de desserts </c:if>
        
        <c:forEach var="i" items="${collectionDItems}">
            <%--
            <c:if test="${i.categorie == "dessert"}"  >
                lol
            </c:if>
            --%>
        </c:forEach>
    </body>
</html>
