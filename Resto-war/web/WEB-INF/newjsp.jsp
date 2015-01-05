
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <FORM ACTION='Controller?' METHOD='POST'>
            <h1>Hello World!</h1>
    
            <fieldset>  
    <legend>Ajouter un Employe</legend>    
    <p><label id="Nom">Nom:
    <input type="text" placeholder="Nom" id="Nom" name="Nom" value="" /></label>
    <label id="Pin">Pin:</label>
    <input type="password" placeholder="Pin" name="Pin" value="" size="5"/></p>
    
       <p>RH <input type="hidden" name="RH" value="0"  />
             <input type="checkbox" name="RH" value="1"  />
    Caissier <input type="hidden" name="Caissier" value="0"  />
             <input type="checkbox" name="Caissier" value="1"  />
        Chef <input type="hidden" name="Chef" value="0"  />   
             <input type="checkbox" name="Chef" value="1"  />
     Serveur <input type="hidden" name="Serveur" value="0"  />
             <input type="checkbox" name=Serveur value="1"  /></p>           
             <INPUT TYPE='SUBMIT' NAME='doIt2' VALUE='Valider' />       
            </fieldset>
        </FORM>   
    </body>
</html>
