package test;

import modelo.Notificacion;

public class FakeEmailRegistroNotificacion implements Notificacion {

	private String resultado;
	private String username;
	private String password;
	private String hostAddress;

	public FakeEmailRegistroNotificacion(String username, String password, String hostAddress) {
		super();
		this.resultado = "";
		this.username = username;
		this.password = password;
		this.hostAddress = hostAddress;
	}

	@Override
	public void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje) {

		resultado = correoDestinatario;

	}

	String resultado() {
		return resultado;
	}

	// esto tendria unas variables de instancia y si produce algo guardarlo y crear
	// metodos para poder ver la variables
}
