package main;

import java.time.LocalDate;

import exceptions.ConcursoExceptions;
import modelo.Concurso;
import modelo.Participante;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo");

//		System.out.println(primerParticipante);

		LocalDate fecha = LocalDate.now();
		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-8);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(2);

		System.out.println(fecha_inicio_inscripcion + " " + fecha_fin_inscripcion);

		Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion);
//		System.out.println(miConcurso);

		try {
			miConcurso.inscribirParticipante(primerParticipante);
//			miConcurso.inscribirParticipante(primerParticipante);
//			System.out.println(miConcurso.verPuntajeAcumulado(segundoParticipante));
		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		}
		System.out.println(miConcurso);
	}

}
