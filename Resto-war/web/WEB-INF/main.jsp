<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d accueil</title>
        
        <!--<title>jQuery UI Tabs - Vertical Tabs functionality</title>-->
        <link type="text/css" rel="stylesheet" href="form.css" />                
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"> 
        <link rel="stylesheet" href="/resources/demos/style.css">                    
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <!--<script type="text/javascript" src="main.js"></script>--> 
        
        
    <script>      
//            $("#rh").click(function(){
//            $(document).ready(
            $(function (){
            $("#tabs").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
            $("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
        });
//    });
    </script>
    
        <script type="text/javascript">            
            var authServer = ${sessionScope.user.serveur};
            
            function getxmlhttp() 
                {
                    xmlhttp= null;
                    if( window.XMLHttpRequest) { // Mozilla
                        xmlhttp= new XMLHttpRequest();
                    } else {
                            if (window.ActiveXObject) { // IE
                                try {
                                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                                } catch (e) {
                                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                                }
                            } else {
                                alert("Votre navigateur ne supporte pas XMLHttpRequest");
                            }
                        }
                        return xmlhttp;
                    }
            
            function showButtons()
                {                    
                    document.getElementById("serveur").style.display 
                            = ${sessionScope.user.serveur} ? "inline" : "none";
                    
                    document.getElementById("chef").style.display 
                            = ${sessionScope.user.chef} ? "inline" : "none";
                    
                    document.getElementById("rh").style.display 
                            = ${sessionScope.user.rh} ? "inline" : "none";  
                    
                    document.getElementById("caissier").style.display 
                            = ${sessionScope.user.caissier} ? "inline" : "none";
                    
                    
//                        
                    //utilssateur se logg et pwd OK
                    //verification du niveau d autorisation
                    //affichage du boutton si autoriser
                }
                
            function afficherSection() 
                {   
                    url = "Controller?section=RH";
                             alert( url);
                    xmlhttp= getxmlhttp();
                    xmlhttp.onreadystatechange=AfficherItem;
                    xmlhttp.open("GET", url, true);
                    xmlhttp.send(null);
                }

            function AfficherItem()
                {
                   if (xmlhttp.readyState == 4) { // if xmlhttp shows "loaded"
                       if (xmlhttp.status == 200) { // if "OK"
                           // alert("Hello");
                           s = xmlhttp.responseText;
                           d = document.getElementById("fenetre");
                           d.innerHTML = s;
                           
 /*                          
$("#rh").click(function(){
$(document).ready(
            $(function (){
            $("#tabs").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
            $("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
        });
});
*/                           
                           
                        } else {
                           alert("Problem retrieving XML data");
                        }
                    }
                }
               
        </script> 
    </head>
    
    <body onload="showButtons();">
        
        <h1>Welcome</h1>
        <form action="Controller" method="POST">
        <input id="deconnexion" type="submit" value="D&eacute;connexion" name="Controller?doIt3"/>
        <input id="serveur" type="button" value="Serveur"/>
        <input id="chef" type="button" value="Chef" />
        <input id="rh" type="button" value="RH" onclick="afficherSection()"/>
        <input id="caissier" type="button" value="Caissier" />
        <br>
        <hr>
        </form>
    <div id = "fenetre">
        <jsp:include page="./welcome.jsp" flush="false"/>
    </div>
                    
    </body>
    
</html>
