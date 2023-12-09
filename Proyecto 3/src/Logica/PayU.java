package Logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class PayU extends PasarelaPago {

	public PayU(Aplicacion app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void escribirLog(boolean exitoso, String logIn) {
		// TODO Auto-generated method stub
		
		   String textoAAgregar = "";
		   if (exitoso == true) {
			   textoAAgregar = "\n"+" transaccion con el logIn"+logIn+"existosa!";
		   }
		   else {
			   textoAAgregar = "\n"+" transaccion con el logIn"+logIn+"fallida!";
		   }
		    try {
	            
	            FileWriter fileWriter = new FileWriter("Datattt/PayU.txt", true);

	            
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            
	            bufferedWriter.write(textoAAgregar);
	            //bufferedWriter.newLine(); 
	            bufferedWriter.close();
	            fileWriter.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
