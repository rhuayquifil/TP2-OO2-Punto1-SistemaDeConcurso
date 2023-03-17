package main;

import java.time.LocalDate;

import Exceptions.ConcursoExceptions;
import Modelo.Concurso;
import Modelo.Participante;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo");
		Participante segundoParticipante = new Participante(30337938, "mama");
//		System.out.println(primerParticipante);
		
		LocalDate fecha_inicio_inscripcion = LocalDate.of(2023, 3, 16);
		LocalDate fecha_fin_inscripcion = LocalDate.of(2023, 4, 20);
		
		Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion);
//		System.out.println(miConcurso);
		
		try {
			miConcurso.inscribirParticipante(primerParticipante);
			miConcurso.inscribirParticipante(primerParticipante);
//			System.out.println(miConcurso.verPuntajeAcumulado(segundoParticipante));
		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		}
		System.out.println(miConcurso);
	}

}
