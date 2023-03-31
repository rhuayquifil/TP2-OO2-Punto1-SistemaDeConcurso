package modelo;

public interface Notificacion {

//	void enviarCorreo();

	void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje);
}
