package pruebasReserva;

import static org.junit.Assert.assertFalse;
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
import Logica.Cliente;

public class preubasReserva {
	Aplicacion app = new Aplicacion(); 
	Cliente cnt; 

    //-----------------------------
    @Test
	@DisplayName("prueba crear reserva (Exito) COPIAR Y PEGAR LOS ARCHIVOS BACK UP PARA PODER HACER DE NUEVO LAS PRUEBAS")
	public void pruebacrearReserva1() {
	/*
	 * la idea es que copien los txt de la carpeta copar a datattt de nuevo 
	 * por que en esos archivos es donde se escribe en los metodos
	 */
	app.cargarAdminGeneral("Datattt/adminGeneral.txt");
	app.cargarAdminsLocales("Datattt/AdminLocal.txt");
	app.cargarCategorias("Datattt/Categorias.txt");
	app.cargarClientes("Datattt/Clientes.txt");
	app.cargarEmpleados("Datattt/Empleados.txt");
	app.cargarSedes("Datattt/Sedes.txt");
	app.cargarSeguro("Datattt/Seguros.txt");
	app.cargarVehiculos("Datattt/Vehiculos.txt");
	app.cargarTemporada("Datattt/temp.txt");
	app.cargarReservas("Datattt/reservas.txt");
	
	Cliente zidane = app.getCliente("z.zidane");
	
	 
	assertTrue(zidane.crearReserva(app, "automovil", "Bogota", "Bogota", "2023-10-22", "2023-10-24", "10:00:00",  "", ""));
	}
    @Test
	@DisplayName("prueba crear reserva (falla) COPIAR Y PEGAR LOS ARCHIVOS BACK UP PARA PODER HACER DE NUEVO LAS PRUEBAS")
    public void pruebacrearReserva2() {
    	/*
    	 * la idea es que copien los txt de la carpeta copar a datattt de nuevo 
    	 * por que en esos archivos es donde se escribe en los metodos
    	 */
    	app.cargarAdminGeneral("Datattt/adminGeneral.txt");
    	app.cargarAdminsLocales("Datattt/AdminLocal.txt");
    	app.cargarCategorias("Datattt/Categorias.txt");
    	app.cargarClientes("Datattt/Clientes.txt");
    	app.cargarEmpleados("Datattt/Empleados.txt");
    	app.cargarSedes("Datattt/Sedes.txt");
    	app.cargarSeguro("Datattt/Seguros.txt");
    	app.cargarVehiculos("Datattt/Vehiculos.txt");
    	app.cargarTemporada("Datattt/temp.txt");
    	app.cargarReservas("Datattt/reservas.txt");
    	
    	Cliente pep = app.getCliente("p.guardiola");
    	
    	
    	assertFalse(pep.crearReserva(app, "atv", "Bogota", "Bogota", "2023-10-22", "2023-10-28", "10:00:00",  "", ""));
    	}
}
