package Logica;

public abstract class PasarelaPago {
	private Aplicacion app;
	public PasarelaPago(Aplicacion app) {
		// TODO Auto-generated constructor stub
		this.app = app;
	}
	public  int pagar(String logIn, String numTarj, String cvv) {
		Cliente cliente = app.getCliente(logIn);
		String numTarjReal = cliente.getMediosPago().getNumero();
		String cvvTarjReal = cliente.getMediosPago().getCvv();
		boolean bloqueada = cliente.getMediosPago().isEstadoTarjeta();
		
		if (bloqueada == false) {
			escribirLog(false, logIn);
			return 0;
			
		}
		
		else if (!cvvTarjReal.equals(cvv) || !numTarjReal.equals(numTarj)) {
			escribirLog(false, logIn);
			return 1;
		}
		else {
			escribirLog(true, logIn);
			cliente.getMediosPago().setEstadoTarjeta(false);
			return 2;
		}
		
	}
	protected abstract void escribirLog(boolean exitoso, String logIn);
}
