package Modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Exceptions.ConcursoExceptions;

public class Concurso {

	private String nombre;
	private LocalDate inicio_inscripcion;
	private LocalDate fin_inscripcion;
	private Set<Cupo> lista_participante;

	public Concurso(String nombre, LocalDate inicio_inscripcion, LocalDate fin_inscripcion) {
		super();
		this.nombre = nombre;
		this.inicio_inscripcion = inicio_inscripcion;
		this.fin_inscripcion = fin_inscripcion;
		this.lista_participante = new HashSet<Cupo>();
	}

	@Override
	public String toString() {
		return "Concurso [nombre=" + nombre + ", inicio_inscripcion=" + inicio_inscripcion + ", fin_inscripcion="
				+ fin_inscripcion + ", lista_participante=" + lista_participante + "]";
	}

	public void inscribirParticipante(Participante nuevo_articipante) throws ConcursoExceptions {
		LocalDate fecha_actual = LocalDate.now();

		if(!estaInscripto(nuevo_articipante)) {
			if (estaEnRangoDeInscripcion(fecha_actual)) {
				
				Cupo nuevoCupo = new Cupo(nuevo_articipante);
				
				if(inscripcionElPrimerDia(fecha_actual)) {
					nuevoCupo.sumarPuntos(10);
				}
				lista_participante.add(nuevoCupo);
			} else {
				throw new ConcursoExceptions("No se pudo inscribir participante. Fuera del las fechas limites de inscripcion");
			}
		} else {
			throw new ConcursoExceptions("Participante ya inscripto");
		}
		
	}


	private boolean estaInscripto(Participante nuevo_articipante) {
		for (Cupo cupo : lista_participante) {
			if(cupo.perteneceA(nuevo_articipante)) {
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
		if(estaInscripto(participante)) {
			for (Cupo cupo : lista_participante) {
				if(cupo.perteneceA(participante)) {
					return cupo.cantidadPuntos();
				}
			}
		}
		throw new ConcursoExceptions("Participante no pertenece al concurso");
	}
}