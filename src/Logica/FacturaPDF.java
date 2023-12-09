package Logica;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class FacturaPDF {
	private String ID;
	private String LogIn;
	private String vehiculo;
	private String entrega;
	private String recojida;
	private String horaeEntrega;
	private String Seguros;
	private String conductoresLogIn;
	private String total;
	public FacturaPDF(String ID,String LogIn,String vehiculo,String entrega, 
			String recojida, String horaeEntrega,String Seguros,
			String conductoresLogIn,String total) {
		this.ID = ID;
		this.LogIn = LogIn;
		this.vehiculo =vehiculo;
		this.entrega = entrega;
		this.recojida =recojida;
		this.horaeEntrega =horaeEntrega;
		this.Seguros = Seguros;
		this.conductoresLogIn = conductoresLogIn;
		this.total = total;
		// TODO Auto-generated constructor stub
	}
	public void facturar() throws MalformedURLException {
		String path = "facturas/FACTURA"+this.ID+".pdf";
		try {
			PdfWriter pdfwriter = new PdfWriter(path);
			PdfDocument pdfDocument = new PdfDocument(pdfwriter);
			pdfDocument.setDefaultPageSize(PageSize.A4);
			Document document = new Document(pdfDocument);
			
			
			document.setTextAlignment(TextAlignment.CENTER);
			Paragraph titulo = new Paragraph("Factura Alquiler");
			titulo.setBold();
			document.add(titulo);
			Paragraph enter = new Paragraph("\n");
			
			document.setTextAlignment(TextAlignment.LEFT);
			document.add(enter);
			//ID
			Paragraph tID = new Paragraph("ID: 				"+this.ID);
			
			document.add(tID);
			
			//logIn
			Paragraph tlogIn = new Paragraph("LogIn: 		"+this.LogIn);
			
			document.add(tlogIn);
			
			//Tipo de vehiculo
			Paragraph tvehiculo = new Paragraph("vehiculo: 			"+this.vehiculo);
			
			document.add(tvehiculo);
			
			//Sede entrega
			Paragraph tentrega = new Paragraph("entrega: 			"+this.entrega );
			
			document.add(tentrega);
			
			//fecha recogida
			Paragraph trecogida = new Paragraph("recogida:			 "+this.recojida );
			
			document.add(trecogida);
			
			//hora entrega
			Paragraph thora_entrega = new Paragraph("hora entrega:			 "+this.horaeEntrega);
			
			document.add(thora_entrega);
			
			//seguros
			Paragraph tseguros = new Paragraph("seguros: 			"+this.Seguros);
			
			document.add(tseguros);
			
			//conductores add
			Paragraph tconductores = new Paragraph("conductores LogIn: "+this.conductoresLogIn);
			
			document.add(tconductores);
			
			//costo Total
			Paragraph tTotal = new Paragraph("Total: 			"+this.total);
			
			document.add(tTotal);
			
			//imagen firma gerente 
			String firmaGerente = "facturas/firmaGerente.jpg";
			ImageData imageData = ImageDataFactory.create(firmaGerente);
			Image image = new Image(imageData);
			/*
			float x = (pdfDocument.getDefaultPageSize().getWidth())/4;
			float y = (pdfDocument.getDefaultPageSize().getHeight())/4;
			image.setFixedPosition(x, y);
			document.add(image);
			document.close();
			*/
			Paragraph FirmaGerente1 = new Paragraph("Firma del gerente:");
			document.setTextAlignment(TextAlignment.LEFT);
			document.setFontSize(12);
			FirmaGerente1.setBold();
            document.add(FirmaGerente1);
            
			float newWidth = 400; 
            float newHeight = 200; 
            image.scaleToFit(newWidth, newHeight);

            
            float x = 50; 
            float y = pdfDocument.getDefaultPageSize().getHeight() - 580; 
            image.setFixedPosition(x, y);
            

            document.add(image);


            document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 public static void main(String[] args) throws MalformedURLException {
	        FacturaPDF facturaPDF = new FacturaPDF();
	        facturaPDF.facturar();
	        System.out.println("PDF!");
	    }
	    */
}
