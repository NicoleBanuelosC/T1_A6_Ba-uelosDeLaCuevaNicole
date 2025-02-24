
//se va a mandar llamar en la otra clase, para poder realizar las conversiones
// Separar la logica de lo otro

public class ConversorDistancias {
	
	public static double kmMillas (double km) {
		return km * 0.621371;
	}//km millas
	
	public static double kmPies (double km) {
		return km * 3280.84;
	}//km pies
	
	public static double kmPulgadas (double km) {
		return km * 39370.1;
	}//km pulgadas
	
}//public class 
