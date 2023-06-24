package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.recuperatorio.Auto;
import ar.edu.unlam.pb2.recuperatorio.Bien;
import ar.edu.unlam.pb2.recuperatorio.CompaniaDeSeguro;
import ar.edu.unlam.pb2.recuperatorio.Persona;
import ar.edu.unlam.pb2.recuperatorio.Poliza;
import ar.edu.unlam.pb2.recuperatorio.PolizaAccidentesPersonales;
import ar.edu.unlam.pb2.recuperatorio.PolizaCombinadoFamiliar;
import ar.edu.unlam.pb2.recuperatorio.PolizaDeAuto;
import ar.edu.unlam.pb2.recuperatorio.SegurosDeVida;
import ar.edu.unlam.pb2.recuperatorio.SegurosGenerales;
import ar.edu.unlam.pb2.recuperatorio.TipoDeBeneficiario;
import ar.edu.unlam.pb2.recuperatorio.Vivienda;

public class Recuperatorio {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Bien auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBienAsegurado(auto);
	
		assertEquals(NUMERO_DE_POLIZA, ((PolizaDeAuto) poliza).getNroPoliza());
		assertEquals(auto, ((PolizaDeAuto) poliza).getBien());
		assertEquals(asegurado, ((PolizaDeAuto) poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaDeAuto) poliza).getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
	
		assertEquals((Integer) 2, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, ((PolizaAccidentesPersonales) poliza).getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;
		
		Bien casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona hija = new Persona("Maia", 65445231, 4);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		poliza.agregarBienAsegurado(casa);
	
		assertEquals((Integer)3, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0));
		
		
		assertEquals((Integer)4, libra.obtenerLaCantidadDePolizasEmitidas());
	}

	
	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(libra.getPoliza(1).fueRobado());
		
	}
	
	@Test 
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistente {
		Integer numeroDePoliza = 2;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		
		libra.denunciarSiniestro(2);
		
		assertTrue(libra.getPoliza(2).tuvoAlgunAccidente());
		
	}
	
	
	@Test (expected = PolizaInexistente.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistente{
		Integer numeroDePoliza1 = 1;
		Integer numeroDePoliza2 = 2;
		Integer numeroDePoliza3 = 3;

		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		Poliza poliza1 = new PolizaDeAuto(numeroDePoliza1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0);
		Poliza poliza2 = new PolizaDeAuto(numeroDePoliza2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0);
		Poliza poliza3 = new PolizaAccidentesPersonales(numeroDePoliza3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0);
		
		libra.agregarPoliza(poliza1);
		libra.agregarPoliza(poliza2);
		libra.agregarPoliza(poliza3);

		
		assertTrue(libra.denunciarSiniestro(4));
	}
	

}
