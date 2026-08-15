package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@WebServlet("/reporte")
public class ReporteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReporteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReporteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("aplicacion/pdf");
        
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\"");
        
        try{
                //crear el pdf
                Document documento = new Document();
                
                OutputStream out = response.getOutputStream();
                
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                //titulo
                documento.add(new Paragraph("REPORTE DE PERSONAS"));
                documento.add(new Paragraph("                   "));
                
                //tabla 
                PdfPTable tabla = new PdfPTable(3);
                
                tabla.addCell("ID");
                tabla.addCell("NOMBRE");
                tabla.addCell("CORREO");
                
                //datos
                tabla.addCell("1");
                tabla.addCell("Enmanuel");
                tabla.addCell("senma@gmail.com");
                
                tabla.addCell("2");
                tabla.addCell("David");
                tabla.addCell("fdavid@gmail.com");
                
                tabla.addCell("3");
                tabla.addCell("Carlos");
                tabla.addCell("mcarlos@gmail.com");
                
                documento.add(tabla);
                
                documento.close();
                
                out.close();
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
