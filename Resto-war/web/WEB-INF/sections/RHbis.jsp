<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<fieldset>            
        <legend>Ressource Humaine</legend>  
        <div id="tabs">
        <!--<div class="ui-tabs-vertical ui-helper-clearfix">-->
            <ul>
                <li><a href="#tabs-1">Liste user</a></li>
                <li><a href="#tabs-2">Ajouter Un User</a></li>
            </ul>
            <div id="tabs-1">
                <h2>Liste Users</h2>
                <p>  <table id="users" class="ui-widget ui-widget-content">
                    <thead>
                        <tr class="ui-widget-header ">
                            <th>Nom</th>
                            <th>Ressource Humaine</th>
                            <th>Caissier</th>
                            <th>Chef</th>
                            <th>Serveur</th>
                            <th>D&eacute;sactiver un User</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="i" items="${listeUser}">
                            <tr>
                                <td>${i.nom}</td>
                                <td>${i.rh}</td>
                                <td>${i.caissier}</td>
                                <td>${i.chef}</td>
                                <td>${i.serveur}</td>
                                <td><a href="Controller?remove=true&Pin=${i.pin}">X</a></td>
                                <br>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table></p>

            </div>
        <div id="tabs-2">
                    <h2>Ajouter un User</h2>
            <fieldset> 
                <!--<legend>Ajouter un Employe</legend>-->    
            <!--<form class="selfCSS" ACTION='Controller?' METHOD='POST'>-->
            <form action='Controller?' method='POST'>
                <p><label id="Nom">Nom:
                    <input type="text" placeholder="Nom" id="Nom" name="Nom" value="" /></label>
                    <label id="Pin">Pin:</label>
                    <input type="password" placeholder="Pin" name="Pin" value="" size="5"/></p>

                <p>RH <input type="checkbox" name="RH" value="true"  />
                    Caissier <input type="checkbox" name="Caissier" value="true"  />
                    Chef <input type="checkbox" name="Chef" value="true"  />   
                    Serveur <input type="checkbox" name="Serveur" value="true" /></p>           
                <INPUT id="" TYPE='SUBMIT' NAME='doIt2' VALUE='Valider' />
            </form>
                </fieldset>
            </div>
        </div>                 
    </form>    
</fieldset> 

