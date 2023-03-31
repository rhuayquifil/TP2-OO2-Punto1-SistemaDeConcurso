package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import exceptions.BaseDeDatosExceptions;
import exceptions.ConcursoExceptions;
import exceptions.GuardaDatoExceptions;

public class Concurso {

	private int id;
	private String nombre;
	private LocalDate inicio_inscripcion;
	private LocalDate fin_inscripcion;
	private Set<Cupo> lista_participante;
	private GuardaDato copiador;
	private Notificacion notificacion;

	public Concurso(int id, String nombre, LocalDate inicio_inscripcion, LocalDate fin_inscripcion, GuardaDato copiador,
			Notificacion notificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.inicio_inscripcion = inicio_inscripcion;
		this.fin_inscripcion = fin_inscripcion;
		this.lista_participante = new HashSet<Cupo>();
		this.copiador = copiador;
		this.notificacion = notificacion;
	}

	public Concurso(int id, String nombre, LocalDate inicio_inscripcion, LocalDate fin_inscripcion,
			GuardaDato copiador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.inicio_inscripcion = inicio_inscripcion;
		this.fin_inscripcion = fin_inscripcion;
		this.lista_participante = new HashSet<Cupo>();
		this.copiador = copiador;
		this.notificacion = null;
	}

	@Override
	public String toString() {
		return "Concurso [id=" + id + ", inicio_inscripcion=" + inicio_inscripcion + ", fin_inscripcion="
				+ fin_inscripcion + ", lista_participante=" + lista_participante + "]";
	}

	public void inscribirParticipante(Participante nuevo_articipante) throws ConcursoExceptions, IOException {
		LocalDate fecha_actual = LocalDate.now();

		if (!estaInscripto(nuevo_articipante)) {
			if (estaEnRangoDeInscripcion(fecha_actual)) {

				Cupo nuevoCupo = new Cupo(nuevo_articipante);

				if (inscripcionElPrimerDia(fecha_actual)) {
					nuevoCupo.sumarPuntos(10);
				}

				lista_participante.add(nuevoCupo);

				// ACA SE ENVIARIAN LOS MAILSTRAP

				try {

					copiador.copiar(LocalDate.now().toString() + " , " + nuevo_articipante.id() + " , " + this.id);

					// TENES QUE RESOLVER COMO HACER CUANDO NO SE TIENE QUE ENVIAR LA NOTIFICACION

					// PREGUNTA !!!!

//					Notificacion notificacion = new EmailRegistroInscripcion(nuevo_articipante.email());
//					notificacion.enviarCorreo();
					notificacion.enviarCorreo("SistemaDeConcurso@RodrigoHuayquifil.com", nuevo_articipante.email(),
							"Felicidades", "Su inscripcion se realizo con exito");

				} catch (GuardaDatoExceptions | BaseDeDatosExceptions e) {
					throw new ConcursoExceptions("Error al guardar el registro");
				}

			} else {
				throw new ConcursoExceptions(
						"No se pudo inscribir participante. Fuera del las fechas limites de inscripcion");
			}
		} else {
			throw new ConcursoExceptions("Participante ya inscripto");
		}
	}

	public boolean estaInscripto(Participante nuevo_articipante) {
		for (Cupo cupo : lista_participante) {
			if (cupo.perteneceA(nuevo_articipante)) {
				return true;
			}
		}
		return false;
//		return lista_participante.contains(nuevo_articipante);
	}

	private boolean estaEnRangoDeInscripcion(LocalDate fecha_actual) {
		return ((fecha_actual.isAfter(inicio_inscripcion) || inscripcionElPrimerDia(fecha_actual))
				&& (fin_inscripcion.isAfter(fecha_actual) || inscripcionDiaFinal(fecha_actual)));
	}

	private boolean inscripcionElPrimerDia(LocalDate fecha_actual) {
		return (inicio_inscripcion.compareTo(fecha_actual) == 0);
	}

	private boolean inscripcionDiaFinal(LocalDate fecha_actual) {
		return (fin_inscripcion.compareTo(fecha_actual) == 0);
	}

	public int verPuntajeAcumulado(Participante participante) throws ConcursoExceptions {
		if (estaInscripto(participante)) {
			for (Cupo cupo : lista_participante) {
				if (cupo.perteneceA(participante)) {
					return cupo.cantidadPuntos();
				}
			}
		}
		return -1; // si retorna -1 significa que el participante no esta inscripto
	}

	public int id() {
		return this.id;
	}
}