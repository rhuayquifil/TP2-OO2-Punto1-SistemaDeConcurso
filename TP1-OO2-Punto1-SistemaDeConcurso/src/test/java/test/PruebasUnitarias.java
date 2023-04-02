package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import exceptions.ConcursoExceptions;
import exceptions.PropertiesExceptions;
import modelo.Concurso;
import modelo.Participante;
import properties.DataBaseAlmacenamiento;

class PruebasUnitarias {

//	@Test
	void Un_participante_se_inscribe_en_un_concurso() {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");

		LocalDate fecha = LocalDate.now();

		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-10);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(20);

		try {

//			el test debe correr sin escribir en disco
//			o en la base de datos o enviar el email de forma verdadera

			FakeEmailRegistroNotificacion notificacion = new FakeEmailRegistroNotificacion("524def57d07409",
					"a0f84bcbd4913c", "sandbox.smtp.mailtrap.io");

			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
					new FakeDiscoGuardaDato("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"),
					notificacion);

			miConcurso.inscribirParticipante(primerParticipante);

			assertEquals(true, miConcurso.estaInscripto(primerParticipante));
//			assertEquals(primerParticipante.email(), notificacion.resultado());

		} catch (ConcursoExceptions e) {
			fail("Participante no se inscribio al concurso");
		} catch (FileNotFoundException e) {
			fail("exceptions FileNotFoundException");
		} catch (IOException e) {
			fail("exceptions IOException");
		}
	}

//	@Test
	void Un_participante_se_inscribe_en_un_concurso_el_primer_día_de_abierta_la_inscripción() {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");

		LocalDate fecha_inicio_inscripcion = LocalDate.now();
		LocalDate fecha_fin_inscripcion = fecha_inicio_inscripcion.plusDays(20);

		try {

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\TP1-OO2-Punto1-SistemaDeConcurso\\src\\main\\java\\properties\\database.properties");

			Concurso miConcurso = new Concurso(1, "R.E.H Servicio Tecnico", fecha_inicio_inscripcion,
					fecha_fin_inscripcion,
					new FakeBaseDeDatoGuardaDato(properties,
							"INSERT INTO registro (fecha, id_participante, id_concurso)" + "VALUES (?, ?, ?);"),
					new FakeEmailRegistroNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			miConcurso.inscribirParticipante(primerParticipante);

			assertEquals(10, miConcurso.verPuntajeAcumulado(primerParticipante));

		} catch (ConcursoExceptions e) {
			fail("Participante no se inscribio al concurso" + e.getMessage());
		} catch (FileNotFoundException e) {
			fail("exceptions FileNotFoundException");
		} catch (IOException e) {
			fail("exceptions IOException");
		} catch (PropertiesExceptions e) {
			fail("exceptions PropertiesExceptions");
		}
	}

//	@Test
	void Un_participante_intenta_inscribirse_fuera_del_rango_de_inscripción() {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");

		LocalDate fecha = LocalDate.now();

		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-30);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(-2);

		try {

			FakeEmailRegistroNotificacion notificacion = new FakeEmailRegistroNotificacion("524def57d07409",
					"a0f84bcbd4913c", "sandbox.smtp.mailtrap.io");

			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
					new FakeDiscoGuardaDato("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"),
					notificacion);

			miConcurso.inscribirParticipante(primerParticipante);

			fail("fallo, se inscribio el participante");

		} catch (ConcursoExceptions e) {
			assertEquals("No se pudo inscribir participante. Fuera del las fechas limites de inscripcion",
					e.getMessage());
		} catch (FileNotFoundException e) {
			fail("exceptions FileNotFoundException");
		} catch (IOException e) {
			fail("exceptions IOException");
		}
	}
}
