package vistacontrolador;

import java.text.DecimalFormat;

import Modelo.Conversor2;

public class PruebasConversor {

	public static void main(String[] args) {
		
		Conversor2 conversor2=new Conversor2();
		double resultado;
		for(int i=10;i<120;i+=10){
			resultado=conversor2.millaskm((double)i);
			DecimalFormat formatoKm=new DecimalFormat("##00.00");
			DecimalFormat formatoMillas=new DecimalFormat("000");
			formatoKm.format(resultado);
			formatoMillas.format(i);
			System.out.println(i+" Millas---> "+resultado+" Km");
		}
		
		for(int i=10;i<120;i+=10){
			resultado=conversor2.kmmillas((double)i);
			DecimalFormat formatoKm=new DecimalFormat("##00.00");
			DecimalFormat formatoMillas=new DecimalFormat("000");
			formatoMillas.format(resultado);
			formatoKm.format(i);
			System.out.println(i+" Km---> "+resultado+" Millas");
		}
	}   

}
