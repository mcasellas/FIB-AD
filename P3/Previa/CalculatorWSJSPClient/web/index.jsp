<%-- 
    Document   : index
    Created on : 05-oct-2018, 11:48:54
    Author     : marc.casellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>    <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
	org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
	 // TODO initialize WS operation arguments here
	int i = 3;
	int j = 4;
	// TODO process result here
	int result = port.add(i, j);
	out.println("Result = "+result);
    } catch (Exception ex) {
	out.println("exception" + ex);
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
