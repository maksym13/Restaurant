<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<SCRIPT language="JavaScript">
    <!--
    function getxmlhttp() {
        xmlhttp= null;
        if( window.XMLHttpRequest) { // Mozilla
            xmlhttp= new XMLHttpRequest();
        } else {
            if( window.ActiveXObject) { // IE
                try { xmlhttp= new ActiveXObject( "Msxml2.XMLHTTP");
                } catch (e) { xmlhttp= new ActiveXObject( "Microsoft.XMLHTTP");
                }
            } else {
                alert( "Votre navigateur ne supporte pas XMLHttpRequest");
            }
        }
        return xmlhttp;
    }

    function afficherItem() {
        url = "AJAXTest?section=item";
         alert( url);
        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpAfficherItem;
        xmlhttp.open("GET",url,true);
		//                 xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xmlhttp.send(null);
    }

    function xmlhttpAfficherItem() {
        if (xmlhttp.readyState===4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status===200) { // if "OK"
                s= xmlhttp.responseText;
//                alert( "("+s+")");
                d = document.getElementById("idItem");
                d.innerHTML = s;
            } else {
                alert("Problem retrieving XML data");
            }
        }
    }
    
    function afficherProduit()
    {
        url = "AJAXTest?section=produit";
        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpAfficherProduit;
        xmlhttp.open("GET",url,true);
        xmlhttp.send(null);      
    }
    
    function xmlhttpAfficherProduit() {
        if (xmlhttp.readyState===4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status===200) { // if "OK"
                s= xmlhttp.responseText;
                alert( "("+s+")");
                d = document.getElementById("idProduit");
                d.innerHTML = s;
            } else {
                alert("Problem retrieving XML data");
            }
        }
    }
    
    function goProduit(s) {
        url = "AJAXTest?section=statutProduit&produit=" + s;
        alert( url);

        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpEtatProduit;
        xmlhttp.open("GET",url,true);
                //                 xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xmlhttp.send(null);
    }

    function xmlhttpEtatProduit() {
        if (xmlhttp.readyState===4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status===200) { // if "OK"
                s= xmlhttp.responseText;
    //                alert( "("+s+")");
                d = document.getElementById("idProduit");
                d.innerHTML = s;
            } else {
                alert("Problem retrieving XML data");
            }
        }
    }
   function goItem(s) {
        url = "AJAXTest?section=statutItem&item=" + s;
        alert( url);

        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpDispoItem;
        xmlhttp.open("GET",url,true);
                //                 xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xmlhttp.send(null);
    }

    function xmlhttpDispoItem() {
        if (xmlhttp.readyState===4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status===200) { // if "OK"
                s= xmlhttp.responseText;
    //                alert( "("+s+")");
                d = document.getElementById("idItem");
                d.innerHTML = s;
            } else {
                alert("Problem retrieving XML data");
            }
        }
    }
    function goZero(s){
        url = "AJAXTest?section=razProduit&produit="+s;
        
        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpRAZ;
        xmlhttp.open("GET",url,true);
        
        xmlhttp.send(null);
    }
    function xmlhttpRAZ(){
        if (xmlhttp.readyState===4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status===200) { // if "OK"
                s= xmlhttp.responseText;
    //                alert( "("+s+")");
                d = document.getElementById("idProduit");
                d.innerHTML = s;
            } else {
                alert("Problem retrieving XML data");
            }
        }
    }
    -->
</SCRIPT>
   </head>
    <body>
        <h1>Hello Chef!</h1>

        <table border="1" width="100%">
            <tbody>
                <tr>
                    <td width="20%">&nbsp;</td>
                    <td width="20%">Service</td>
                    <td width="20%">Carte</td>
                        
                    
                </tr>
                <tr>
                    <td>
                        <input type="button" value="SERVICE" name="doService" onclick="javascript:afficherProduit()"/><br>
                        <input type="button" value="CARTE" name="doCarte" onclick="javascript:afficherItem()"/>
                    </td>
                    <td id="idProduit">
                    <!--<td>-->
                        <%--<jsp:include page="/AJAXTest?section=ajaxItem" flush="false" />--%>
                    </td>
                    <td id="idItem">
                        <%--<jsp:include page="/AJAXTest?section=produit" flush="false" />--%>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </tbody>
        </table>

    <center><%=new Date()%></center>

</body>
</html>
