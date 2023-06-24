package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosDeVida, SegurosGenerales {


	private Persona asegurado;
	private Double sumaAsegurada;
	private Double prima;
	private Set<Bien> bien;
	private Map<Persona, TipoDeBeneficiario> personas;
	
	public PolizaCombinadoFamiliar(Integer nroPoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(nroPoliza);
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.bien = new HashSet<Bien>();
		this.personas = new HashMap<Persona, TipoDeBeneficiario>();
	}



	public Integer getNroPoliza() {
		return super.getNroPoliza();
	}


	public void setNroPoliza(Integer nroPoliza) {
		super.setNroPoliza(nroPoliza);
	}


	public Persona getAsegurado() {
		return asegurado;
	}


	public void setAsegurado(Persona asegurado) {
		this.asegurado = asegurado;
	}


	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}


	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}


	public Double getPrima() {
		return prima;
	}


	public void setPrima(Double prima) {
		this.prima = prima;
	}
	
	
	
	@Override
	public void agregarBienAsegurado(Bien bien) {
		this.bien.add(bien);
	}

	@Override
	public void agregarBeneficiario(Persona hijo, TipoDeBeneficiario tipoDeBeneficiario) {
		this.personas.put(hijo, tipoDeBeneficiario);

	}

	@Override
	public Integer obtenerCantidadDeBeneficiarios() {
		return this.personas.size();
	}

	@Override
	public Double getPremio() {
		return getPrima() + 10000;
	
	}

	@Override
	public Bien getBien() {
		for (Bien bien : bien) {
			return bien;
		}
		return null;
	}



}
