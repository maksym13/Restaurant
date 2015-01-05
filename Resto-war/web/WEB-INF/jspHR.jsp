<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <!--<body>--> 

    <FORM ACTION='Controller?' METHOD='POST'>
        <%--<FORM class="selfCSS" ACTION='Controller?' METHOD='POST'>--%>    
        <fieldset>  
            <legend>Ressource Humaine</legend>                        
            <title>jQuery UI Tabs - Vertical Tabs functionality</title>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
            <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script type="text/javascript" src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
            <link rel="stylesheet" href="/resources/demos/style.css">
            <script>
                $(function () {
                    $("#tabs").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
                    $("#tabs li").removeClass("ui-corner-top").addClass("ui-corner-left");
                });
            </script>
            <style>
                .ui-tabs-vertical { width: 55em; }
                .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
                .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
                .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
                .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
                .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
            </style>
            </head>
            <body>
                <div id="tabs">
                    <ul>
                        <li><a href="#tabs-1">Liste user</a></li>
                        <li><a href="#tabs-2"></a></li>
                        <li><a href="#tabs-3">Ajouter Un User</a></li>
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
                        <button name= 'doIt2' id="create-user">Create new user </button>

                    </div>
                    <div id="tabs-2">
                        <h2>C</h2>
                        <p></p>
                    </div>
                    <div id="tabs-3">
                        <h2>Ajouter un User</h2>
                        <fieldset>  
                            <legend>Ajouter un Employe</legend>    
                            <p><label id="Nom">Nom:
                                    <input type="text" placeholder="Nom" id="Nom" name="Nom" value="" /></label>
                                <label id="Pin">Pin:</label>
                                <input type="password" placeholder="Pin" name="Pin" value="" size="5"/></p>

                            <p>RH <input type="checkbox" name="RH" value="true"  />
                                Caissier <input type="checkbox" name="Caissier" value="true"  />
                                Chef <input type="checkbox" name="Chef" value="true"  />   
                                Serveur <input type="checkbox" name="Serveur" value="true" /></p>           
                            <INPUT id="" TYPE='SUBMIT' NAME='doIt2' VALUE='Valider' />       
                        </fieldset>

                    </div>
                </div>
            </body>


            <!--</body>--> 
            </html>
