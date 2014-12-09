package Modelo;

public class Conversor2 {

	public Conversor2() {
		
	}
    public double millaskm(double millas){
    	double resultado=millas*1.609;
    	return resultado;
    }
    public double kmmillas(double km){
    	double resultado=km*0.621;
    	return resultado;
    }

}
