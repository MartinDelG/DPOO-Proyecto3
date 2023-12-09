package pruebas;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import Logica.AdminGeneral;
import Logica.Aplicacion;




public class pruebasCarga {
	Aplicacion app = new Aplicacion(); 
	
	@Test
	@DisplayName("prueba adminGeneral")
	public void pruebaCargarAdminGeneral() {
	app.cargarAdminGeneral("archivosPrueba/adminGeneral.txt");
	AdminGeneral adminCargado = app.getAdmin("l.yamal");
	AdminGeneral adminEsperado = new AdminGeneral("Lamine", "Yamal", LocalDate.parse("2005-07-13"), "Espaniol", "l.yamal", "Yamal");
	assertEquals(adminCargado.getNombre(), adminEsperado.getNombre());
	}
	 @Rule
	    public ExpectedException expectedException = ExpectedException.none();

    @Test
    @DisplayName("prueba FALLA adminGeneral")
    public void CargarAdminGeneralThrowsException() {

        expectedException.expect(Exception.class);
     
        app.cargarAdminGeneral("archivosPrueba/adminGeneralFalla.txt");
    }
    //-----------------------------
    @Test
	@DisplayName("prueba adminLoc")
	public void pruebaCargarAdminloc() {
	app.cargarAdminsLocales("archivosPrueba/AdminLocal.txt");
	String  adminBuscado= "a.llinas";
	assertTrue(app.Adminlocales.containsKey(adminBuscado));
	}
	

    @Test
    public void CargarAdminLocThrowsException() {

        expectedException.expect(Exception.class);
     
        app.cargarAdminsLocales("archivosPrueba/AdminLocalFalla.txt");
    }
    //------------------------------------
    @Test
	@DisplayName("prueba Categoria")
	public void pruebaCargarCategorias() {
	app.cargarCategorias("archivosPrueba/Categorias.txt");
	String  catBuscada= "atv";
	assertTrue(app.categorias.containsKey(catBuscada));
	}
	

    @Test
    public void CargarCategoriasThrowsException() {

        expectedException.expect(Exception.class);
     
        app.cargarCategorias("archivosPrueba/CategoriasFalla.txt");
    }
     
	//-----------------------------------------
    @Test
	@DisplayName("prueba clinetes")
	public void pruebacargarClientes() {
	app.cargarClientes("archivosPrueba/Clientes.txt");
	String  catBuscada= "p.guardiola";
	assertTrue(app.Clientes.containsKey(catBuscada));
	}
	

    @Test
    public void CargarCargarClientes() {

        expectedException.expect(Exception.class);
     
        app.cargarClientes("archivosPrueba/ClientesFalla.txt");
    }
  //-----------------------------------------
    @Test
	@DisplayName("prueba empleados")
	public void pruebacargarEmpleados() {
	app.cargarEmpleados("archivosPrueba/Empleados.txt");
	String  catBuscada= "c.ronaldo";
	assertTrue(app.Empleados.containsKey(catBuscada));
	}
	

    @Test
    public void CargarcargarEmpleados() {

        expectedException.expect(Exception.class);
     
        app.cargarEmpleados("archivosPrueba/EmpleadosFalla.txt");
    }
    //-----------------------------------------
    @Test
	@DisplayName("prueba sedes")
	public void pruebacargarSedes() {
	app.cargarSedes("archivosPrueba/Sedes.txt");
	String  catBuscada= "Bogota";
	assertTrue(app.sedes.containsKey(catBuscada));
	}
	

    @Test
    public void CargarcargarSedes() {

        expectedException.expect(Exception.class);
     
        app.cargarSedes("archivosPrueba/SedesFalla.txt");
    }
    
}
