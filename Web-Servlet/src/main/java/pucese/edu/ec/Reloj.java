package pucese.edu.ec;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reloj
 * autor: jaime sayago
 * descripcion: serblet para un reloj
 * variables:
 * metodos utilizados:
 * y otros
 * informacion reñevante de la clase que se construye
 */

//comentario una linea

/* comentario 
 * bloque
 */
@WebServlet("/reloj")
public class Reloj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reloj() {
        super();
        // TODO Auto-generated constructor stub
        
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// utilizar un objeto calendario
			Calendar calendar = GregorianCalendar.getInstance(); //variable con la fecha de hoy
		//imprimir la codificacion en la pantalla
			PrintWriter out = response.getWriter(); //impirmir en la vista la informacion
		//obtener los parametros desde la web o url
			String formato = request.getParameter("formato");
			String hora;
			
			if("12".equals(formato)) {
				//formato del reloj
				hora = String.format("%s: %s: %s: %s",
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE),
						calendar.get(Calendar.SECOND),
						calendar.get(Calendar.AM_PM ) == 0 ? "am" : "pm"
						);
			}else {
			
					 hora = String.format("%s: %s: %s",
					calendar.get(Calendar.HOUR_OF_DAY),
					calendar.get(Calendar.MINUTE),
					calendar.get(Calendar.SECOND));
			}
			out.print(hora); //imprimir en la vista la hora
			out.flush(); //forzar la salida
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
