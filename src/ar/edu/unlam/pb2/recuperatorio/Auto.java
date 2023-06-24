package ar.edu.unlam.pb2.recuperatorio;

public class Auto extends Bien{
		private String marca;
		private String modelo;
		private Integer año;
		private Double sumaAsegurada;
		
		public Auto(String marca, String modelo, Integer año, Double sumaAsegurada) {
			this.marca = marca;
			this.modelo = modelo;
			this.año = año;
			this.sumaAsegurada = sumaAsegurada;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public Integer getAño() {
			return año;
		}

		public void setAño(Integer año) {
			this.año = año;
		}

		public Double getSumaAsegurada() {
			return sumaAsegurada;
		}

		public void setSumaAsegurada(Double sumaAsegurada) {
			this.sumaAsegurada = sumaAsegurada;
		}
		
		
}
