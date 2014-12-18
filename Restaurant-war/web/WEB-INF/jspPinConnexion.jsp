<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="css/form.css" />
    </head>
    <body>
                       <h1>Staff accueil</h1>
                       <FORM class="selfCSS" ACTION='Controller?' METHOD='POST'>
            <fieldset>  
                       <legend>Identification</legend>
                Pin :  <INPUT TYPE='PASSWORD' NAME='pin' /><br>
                       <INPUT TYPE='SUBMIT' NAME='doIt' VALUE='Valider' />
                       <FONT COLOR='RED'>${msg}</FONT>
            </fieldset>
        </FORM>
    </body>
</html>
