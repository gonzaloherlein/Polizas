package ar.edu.unlam.pb2.recuperatorio;

import java.util.Objects;

public class Poliza {
	private Integer nroPoliza;
	private Boolean fueRobado;
	private Boolean tuvoAlgunAccidente;

	public Poliza(Integer nroPoliza) {
		this.nroPoliza = nroPoliza;
		this.fueRobado = false;
		this.tuvoAlgunAccidente = false;
	}

	public Integer getNroPoliza() {
		return nroPoliza;
	}

	public void setNroPoliza(Integer nroPoliza) {
		this.nroPoliza = nroPoliza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroPoliza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Poliza other = (Poliza) obj;
		return Objects.equals(nroPoliza, other.nroPoliza);
	}

	public Boolean getTuvoAlgunAccidente() {
		return tuvoAlgunAccidente;
	}

	public void setTuvoAlgunAccidente(Boolean tuvoAlgunAccidente) {
		this.tuvoAlgunAccidente = tuvoAlgunAccidente;
	}

	public Boolean getFueRobado() {
		return fueRobado;
	}

	public void setFueRobado(Boolean fueRobado) {
		this.fueRobado = fueRobado;
	}

	public Boolean fueRobado() {
		return this.fueRobado;
	}

	public boolean tuvoAlgunAccidente() {
		return this.tuvoAlgunAccidente;
	}
	
	
	
	
}
