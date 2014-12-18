<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


            <c:forEach var="i" items="${item}">
                <c:if test="${!i.isActive}">
                <input type="button" value="Dispo" name="doIt" onclick="javascript:goItem('${i.nomProduit}')" />${i.nomProduit}    
                </c:if>
                <c:if test="${i.isActive}">    
                <input type="button" value="nonDispo" name="doIt" onclick="javascript:goItem('${i.nomProduit}')" />${i.nomProduit}             
                </c:if>
                <br>
                
            </c:forEach>
