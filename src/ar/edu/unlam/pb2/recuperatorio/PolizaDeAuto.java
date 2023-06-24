package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashSet;
import java.util.Set;

public class PolizaDeAuto extends Poliza implements SegurosGenerales {
	
			private Persona asegurado;
			private Double sumaAsegurada;
			private Double prima;
			private Set<Bien> bien;

			
			public PolizaDeAuto(Integer nroPoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
				super(nroPoliza);
				this.asegurado = asegurado;
				this.sumaAsegurada = sumaAsegurada;
				this.prima = prima;
				this.bien = new HashSet<Bien>();
			}

			public Integer getNroPoliza() {
				return super.getNroPoliza();
			}


			public void setNroPoliza(Integer nroPoliza) {
				super.setNroPoliza(nroPoliza);;
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
			public void agregarBienAsegurado(Bien auto) {
				this.bien.add(auto);
			}
			
			
			public Double getPremio() {
				return getPrima() + 1000;
			}


			@Override
			public Bien getBien() {
				for (Bien bien2 : this.bien) {
					if(bien2 instanceof Auto) {
						return bien2;
					}
				}
				return null;
			}

}
