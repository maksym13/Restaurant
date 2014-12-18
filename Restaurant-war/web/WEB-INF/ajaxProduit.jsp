<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


            <c:forEach var="i" items="${produit}">
                <c:if test="${i.isFinished}">
                <input type="button" value="Plat pret" name="doIt" onclick="javascript:goProduit(${i.idUnique})" />${i.idUnique}
                <input type="button" value="RAZ" name="doZero" onclick="javascript:goZero(${i.idUnique})"/>
                </c:if>
                <c:if test="${!i.isFinished&&i.isStarted}">
                <input type="button" value="En cour" name="doIt" onclick="javascript:goProduit(${i.idUnique})" />${i.idUnique}
                </c:if>
                <c:if test="${!i.isStarted}">
                <input type="button" value="Commande" name="doIt" onclick="javascript:goProduit(${i.idUnique})" />${i.idUnique}
                </c:if>
                <br>
            </c:forEach> 

