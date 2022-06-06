package pucese.edu.ec;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Factura
 * variables: nombre, apellido, subtotal, porcentajeiba
 * desarrollador por: JSH
 */
@WebServlet("/factura")
public class Factura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Factura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//declaracion variables
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String subtotal = request.getParameter("subtotal");
		String porcentajeIva = request.getParameter("iva");
		
		//operaciones de la factura
		double doubleSubTotal = Double.parseDouble(subtotal);
		int intPorcentajeIva = Integer.parseInt(porcentajeIva);
		double montoIva = (doubleSubTotal * intPorcentajeIva ) / 100;
		double total = doubleSubTotal + montoIva;
		
		
		//terminamos las operaciones de la facuta
		
		
		//como ultimo paso se requiere mostrar la informacion
		//imprimir directamente desde el servlet
		//imprimir en una pagina html
		//impirmir desde el servlet + una pagina web
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html> <head><title> ")
		.append("resumen de la factura")
		.append("</title> </head>")
		.append("<body><h1>FACTURA</h1>")
		.append("<p>Cliente nombre: ").append(nombre).append("</p>")
		.append("<p>Cliente apellido: ").append(apellido).append("</p>")
		.append("<table>")
		.append("<tr><td>Subtotal:</td><td>").append(doubleSubTotal).append("</td></tr>")
		.append("<tr><td>montoIva:</td><td>").append(montoIva).append("</td></tr>")	
		.append("<tr><td>total:</td><td>").append(total).append("</td></tr>")
		.append("</table></body></html>");
		
		//imprimir la cadena que construye la pagina html
		out.print(sb.toString());
		out.flush();
		
	}

}
