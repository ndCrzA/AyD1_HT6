package Proceso;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import Objetos.Carrera;
import Objetos.Horario;
import Objetos.RegistroAcademico;

@ExtendWith(MockitoExtension.class)
public class HT6_200915606 {
			
	@Test
	public void validarCarnetTest() {
		RegistroAcademico r = mock(RegistroAcademico.class); 
		when(r.cheequearCarnet()).thenReturn(true);
		assertTrue("Carnet Invalido", r.cheequearCarnet());		
		
		RegistroAcademico reg = new RegistroAcademico(1900,"15606");//false		
		assertFalse("Carnet Valido", reg.cheequearCarnet());
	} 
	
	
	@Test
	public void validarCarrera() {
		Carrera c = mock(Carrera.class);
		Exception e = null;
		try {
			when(c.procesarCarrera()).thenThrow(new Exception("Carrera no valida"));
			c.procesarCarrera();
		} catch (Exception e1) {
			e = e1;
		}
		assertNotNull(e);
	}
	
	
	@Test
	public void generarHorario() throws Exception {
		RegistroAcademico r = mock(RegistroAcademico.class);		
		when(r.cheequearCarnet()).thenReturn(true);
		when(r.getAño()).thenReturn(2009);
		
		Carrera c = mock(Carrera.class);
		when(c.procesarCarrera()).thenReturn(1);		
		
		AsignarHorario aH = new AsignarHorario();
		Horario h = aH.generarHorario(c, r);
		assertNotNull("Horario Nulo", h);				
	}

}
