
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  double X_value, Y_value , R_value;
  String X_string, Y_string, R_string, url;
 
  X_string = request.getParameter("X");
  Y_string = request.getParameter("Y");
  try {
   X_value = Double.parseDouble(X_string);
   Y_value = Double.parseDouble(Y_string);
  }
  catch (NumberFormatException e) {
   response.sendError(400, "Wrong or missing operands!");
   return;
  }
  url = request.getRequestURL().toString();
  if (url.endsWith("add") || url.endsWith("ADD") || url.endsWith("Add")) { R_value = X_value + Y_value; }
  else if (url.endsWith("sub") || url.endsWith("SUB") || url.endsWith("Sub")) { R_value = X_value - Y_value; }
  else if (url.endsWith("mul") || url.endsWith("MUL") || url.endsWith("Mul")) { R_value = X_value * Y_value; }
  else if (url.endsWith("div") || url.endsWith("DIV") || url.endsWith("Div")) {
   if (Y_value != 0.0) { R_value = X_value / Y_value; }
   else { 
    response.sendError(400, "Division by zero!");
    return;
   }
  }
  else {
   response.sendError(400, "Wrong operation!");
   return;
  }

  R_string = Double.toString(R_value);
  response.setContentType("text/xml;charset=UTF-8");
  PrintWriter out = response.getWriter();
  try {
   out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.println("<result>"); out.println(R_string); out.println("</result>");
  }
  finally { out.close(); }
  response.setStatus(200); // OK
 }

 public String getServletInfo() {
  return "Calculator";
 }
}
