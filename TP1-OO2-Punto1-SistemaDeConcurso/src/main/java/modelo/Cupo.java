package modelo;

import java.util.Objects;

public class Cupo {

	private Participante participante;
	private int puntosParticipante;
	
	public Cupo(Participante participante) {
		super();
		this.participante = participante;
		this.puntosParticipante = 0;
	}

	@Override
	public String toString() {
		return "Cupo [participante=" + participante + ", puntosParticipante=" + puntosParticipante + "]";
	}

	public void sumarPuntos(int puntos) {
		if(puntos > 0) {
			this.puntosParticipante += puntos;
		}
	}

	public boolean perteneceA(Participante esteParticipante) {
		return (this.participante.equals(esteParticipante));
	}
	
	public int cantidadPuntos() {
		return puntosParticipante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(participante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupo other = (Cupo) obj;
		return Objects.equals(participante, other.participante);
	}
}
