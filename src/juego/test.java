package juego;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Usa las reglas de un 4 en rayas, pero puedes decicir la dimension del tablero y para ganar hay que hacer un 3 en rayas
		
		Scanner sc;
		int colocar=0;
		int n=0;
		sc = new Scanner(System.in);
		
		System.out.println("Dimension del tablero");
		n = sc.nextInt();
		tablero array= new tablero(n);
		array.DibujarTableroinicial();
		boolean ganar=false;
		
		String name="";
		String color="";
		
		System.out.println("Nombre del jugador 1");
		name = sc.nextLine();
		System.out.println("Color de la ficha");
		color = sc.nextLine();
		
		ficha jugador1=new ficha(name,color);
		
		System.out.println("Nombre del jugador 2");
		name = sc.nextLine();
		System.out.println("Color de la ficha");
		color = sc.nextLine();
		
		ficha jugador2=new ficha(name,color);
		
		for(int i=0;(i<(n*n))&&(ganar==false);i++) {
			if(i%2==0){
			do {System.out.println("turno 1");
			colocar = sc.nextInt();
			}while(colocar>n-1);
			
			array.colocarficha(colocar, jugador1);
			ganar=array.ganador(jugador1);
			}else {
				do {System.out.println("turno 2");
				colocar = sc.nextInt();
			}while(colocar>n-1);
				array.colocarficha(colocar, jugador2);
				ganar=array.ganador(jugador2);
			}
			array.DibujarTablero();
		}
		if(ganar=array.ganador(jugador1)) {
			System.out.println("gana " + jugador1.getNombre());
		}if(ganar=array.ganador(jugador2)) {
			System.out.println("gana " + jugador2.getNombre());
		}
	}

}
