/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-13 16:31:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class registerForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/ddj04/Documents/workspace-sts-3.9.17.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ch2/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1651981538315L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.net.URLDecoder");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css\" />\r\n");
      out.write("    <style>\r\n");
      out.write("        * { box-sizing:border-box; }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            width:400px;\r\n");
      out.write("            height:600px;\r\n");
      out.write("            display : flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items:center;\r\n");
      out.write("            position : absolute;\r\n");
      out.write("            top:50%;\r\n");
      out.write("            left:50%;\r\n");
      out.write("            transform: translate(-50%, -50%) ;\r\n");
      out.write("            border: 1px solid rgb(89,117,196);\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-field {\r\n");
      out.write("            width: 300px;\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            border : 1px solid rgb(89,117,196);\r\n");
      out.write("            border-radius:5px;\r\n");
      out.write("            padding: 0 10px;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        label {\r\n");
      out.write("            width:300px;\r\n");
      out.write("            height:30px;\r\n");
      out.write("            margin-top :4px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: rgb(89,117,196);\r\n");
      out.write("            color : white;\r\n");
      out.write("            width:300px;\r\n");
      out.write("            height:50px;\r\n");
      out.write("            font-size: 17px;\r\n");
      out.write("            border : none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            margin : 20px 0 30px 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .title {\r\n");
      out.write("            font-size : 50px;\r\n");
      out.write("            margin: 40px 0 30px 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .msg {\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            text-align:center;\r\n");
      out.write("            font-size:16px;\r\n");
      out.write("            color:red;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .sns-chk {\r\n");
      out.write("            margin-top : 5px; \"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <title>Register</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>		\r\n");
      out.write("   <form action =\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" method=\"POST\" onsubmit=\"return formCheck(this)\">\r\n");
      out.write("    <div class=\"title\">Register</div>\r\n");
      out.write("    <div id=\"msg\" class=\"msg\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${URLDecoder.decode(param.msg, \"utf-8\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </div> \r\n");
      out.write("    <label for=\"\">아이디</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"id\" placeholder=\"8~12자리의 영대소문자와 숫자 조합\">\r\n");
      out.write("    <label for=\"\">비밀번호</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"pwd\" placeholder=\"8~12자리의 영대소문자와 숫자 조합\">\r\n");
      out.write("    <label for=\"\">이름</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"name\" placeholder=\"홍길동\">\r\n");
      out.write("    <label for=\"\">이메일</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"email\" placeholder=\"example@fastcampus.co.kr\"> \r\n");
      out.write("    <label for=\"\">생일</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"birth\" placeholder=\"2020/12/31\">\r\n");
      out.write("    <label for=\"\">취미</label>\r\n");
      out.write("    <input class=\"input-field\" type=\"text\" name=\"hobby\">\r\n");
      out.write("    <div class=\"sns-chk\">\r\n");
      out.write("        <label><input type=\"checkbox\" name=\"sns\" value=\"facebook\"/>페이스북</label>\r\n");
      out.write("        <label><input type=\"checkbox\" name=\"sns\" value=\"kakaotalk\"/>카카오톡</label>\r\n");
      out.write("        <label><input type=\"checkbox\" name=\"sns\" value=\"instagram\"/>인스타그램</label>\r\n");
      out.write("    </div>\r\n");
      out.write("    <button>회원 가입</button>\r\n");
      out.write("   </form> \r\n");
      out.write("   <script>\r\n");
      out.write("       function formCheck(frm) {\r\n");
      out.write("            var msg ='';\r\n");
      out.write("\r\n");
      out.write("            if(frm.id.value.length<3) {\r\n");
      out.write("                setMessage('id의 길이는 3이상이어야 합니다.', frm.id);\r\n");
      out.write("                return false;\r\n");
      out.write("            }if(frm.pwd.value.length<3) {\r\n");
      out.write("                setMessage('password의 길이는 3이상이어야 합니다.', frm.pwd);\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("           return true;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       function setMessage(msg, element){\r\n");
      out.write("            document.getElementById(\"msg\").innerHTML = `<i class=\"fa fa-exclamation-circle\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${msg}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'</i>`;\r\n");
      out.write("\r\n");
      out.write("            if(element) {\r\n");
      out.write("                element.select();\r\n");
      out.write("            }\r\n");
      out.write("       }\r\n");
      out.write("   </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/registerForm.jsp(67,31) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/login/login");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/registerForm.jsp(73,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/register/save");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }
}
