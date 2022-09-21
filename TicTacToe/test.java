package tttmodell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;



public class test  {


@Test
		void test() {
			//----------------------------
			// Arrange
			TTTModell dasSpiel = new TTTModell();
			
			System.out.println("----- Am Anfang -----");
			System.out.println();
			dasSpiel.visualisieren();
			System.out.println();
			
			//----------------------------
			// Act
			dasSpiel.spielereins(0,1);
			dasSpiel.spielerzwei(0,2);
			
			System.out.println("----- Noch nicht beendet -----");
			System.out.println();
			dasSpiel.visualisieren();
			System.out.println();
			
			//----------------------------
			// Assert
		//	assertFalse(dasSpiel.gewinnErmitteln());
			
			//----------------------------
			// Act
			dasSpiel.spielereins(1,1);
			dasSpiel.spielerzwei(2,2);
			dasSpiel.spielereins(2,1);
		
			
			System.out.println("----- Am Ende -----");
			System.out.println();
			dasSpiel.visualisieren();
			System.out.println();
			
			//----------------------------
			// Assert
			assertTrue(dasSpiel.gewinnErmitteln());
		}

	}