package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <title>FotOK</title>\n");
      out.write("    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"./css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"theme.css\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("    <link rel=\"shortcut icon\" href=\"./favicon.ico\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("   \n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">FotOK</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("          <ul class=\"nav navbar-nav\">\n");
      out.write("            <li class=\"active\"><a href=\"./menu.jsp\">Inici</a></li>\n");
      out.write("            <li><a href=\"./registrarImagen.jsp\">Registrar Imatge</a></li>\n");
      out.write("            <li><a href=\"./webresources/generic/list\">Llista les imatges</a></li>\n");
      out.write("            <li><a href=\"./buscarImagen.jsp\">Busca una imatge</a></li>\n");
      out.write("            <li>\n");
      out.write("                <form class=\"form-signin\" action=\"logout\" method=\"POST\"></form> \n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container theme-showcase\" role=\"main\">\n");
      out.write("\n");
      out.write("      <!-- Main jumbotron for a primary marketing message or call to action -->\n");
      out.write("      <div class=\"jumbotron\">\n");
      out.write("        <h1>Hola!</h1>\n");
      out.write("        <p>Benvingut a <strong>FotOK</strong>,</p>\n");
      out.write("        <p>La WebApp per fotògrafs professionals i aficionats.</p>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      \n");
      out.write("      <div class=\"page-header\">\n");
      out.write("        <h1>Què pots fer?</h1>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <div class=\"row\">\n");
      out.write("        \n");
      out.write("          <div class=\"list-group\">\n");
      out.write("            <a href=\"./registrarImagen.jsp\" class=\"list-group-item active\">\n");
      out.write("              Registra una imatge\n");
      out.write("            </a>\n");
      out.write("          \n");
      out.write("            <a href=\"./webresources/generic/list\" class=\"list-group-item\">Llista les imatges</a>\n");
      out.write("            <a href=\"./buscarImagen.jsp\" class=\"list-group-item\">Busca imatges</a>\n");
      out.write(" \n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("    </div> <!-- /container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript\n");
      out.write("    ================================================== -->\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("    <script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery.min.js\"><\\/script>')</script>\n");
      out.write("    <script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"./js/docs.min.js\"></script>\n");
      out.write("    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n");
      out.write("    <script src=\"./js/ie10-viewport-bug-workaround.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
