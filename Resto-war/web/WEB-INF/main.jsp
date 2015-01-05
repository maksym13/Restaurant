
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d accueil</title>
        
        <script type="text/javascript">            
            var authServer = ${sessionScope.user.serveur};
            
            function showButtons()
                {                    
                    document.getElementById("serveur").style.display = ${sessionScope.user.serveur} ? "inline" : "none";
                    document.getElementById("chef").style.display = ${sessionScope.user.chef} ? "inline" : "none";
                    document.getElementById("rh").style.display = ${sessionScope.user.rh} ? "inline" : "none";                    
                    document.getElementById("caissier").style.display = ${sessionScope.user.caissier} ? "inline" : "none";
//                        
                    //utilssateur se logg et pwd OK
                    //verification du niveau d autorisation
                    //affichage du boutton si autoriser
                }
        </script> 
    </head>
    <body onload="showButtons();">
        <h1>Welcome</h1>
        
        <input id="deconnexion" type="submit" value="Deconnexion" />
        <input id="serveur" type="submit" value="Serveur"/>
        <input id="chef" type="submit" value="Chef" />
        <input id="rh" type="submit" value="RH" />
        <input id="caissier" type="submit" value="Caissier" />
        <br>
        <hr>
        
        <jsp:include page="./welcome.jsp" flush="false"/>
        
        
    </body>
</html>
