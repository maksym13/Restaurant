<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link type="text/css" rel="stylesheet" href="form.css" />
    <body> 
        
         <FORM ACTION='Controller?' METHOD='POST'>
        <%--<FORM class="selfCSS" ACTION='Controller?' METHOD='POST'>--%>    
                        <fieldset>  
                       <legend>Ressource Humaine</legend> 
                     
                        
         
  <meta charset="utf-8">
  <title>jQuery UI Tabs - Vertical Tabs functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
    $("#create-user").button ().on("#tabs-3");
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
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                    <c:forEach var="i" items="${listeUser}">
                    ${i.nom}
                    <br>
                    </c:forEach></td>
                    <td><c:forEach var="i" items="${listeUser}">
                    ${i.rh}
                    <br>
                    </c:forEach></td>
                    <td><c:forEach var="i" items="${listeUser}">
                    ${i.caissier}
                    <br>
                    </c:forEach></td>
                    <td><c:forEach var="i" items="${listeUser}">
                    ${i.chef}
                    <br>
                    </c:forEach></td>
                    <td><c:forEach var="i" items="${listeUser}">
                    ${i.serveur}
                    <br>
                    </c:forEach></td>
                    </tr>
                    </tbody>
                    </table></p>
                    <button onclick="#tabs-3" id="create-user">Create new user</button>
  </div>
  <div id="tabs-2">
    <h2>C</h2>
    <p></p>
  </div>
  <div id="tabs-3">
    <h2>Ajouter un User</h2>
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>
  
 
</body>              
    </body> 
</html>
