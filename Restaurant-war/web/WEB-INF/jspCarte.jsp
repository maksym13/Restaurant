<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carte des items</title>
    </head>
    <body>
        <h1> Carte des items</h1>

        <a href="pourLesTests?section=entree">Entree</a><br>
        <a href="pourLesTests?section=plat">Plats</a><br>
        <a href="pourLesTests?section=dessert">Desserts</a><br>
        <a href="pourLesTests?section=vin">Vins</a><br>
        <a href="pourLesTests?section=fromage">Fromages</a><br>


        <%-- type : ${type} --%>
        
        <br>
        <c:forEach var="i" items="${collectionDItems}">

            <c:if test="${i.categorie == type}">

                <IMG src="${i.imagePath}"><br>
                <a href="pourLesTests?section=${i.nomItem}">${i.nomItem}</a>&nbsp;&nbsp;${i.prixHT} &euro;<br>
                         
            </c:if>
        </c:forEach>       
        <%--
            <a href="pourLesTests?section=carte">${i.nomItem}</a><br> 
            <c:if  test=" ${i.categorie == typePlat}" > 
            <a href="pourLesTests?section=carte">${i.nomItem}</a><br>
        --%>
    </body>
</html>
