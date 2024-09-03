package juego;

import java.util.Scanner;

public class tablero {
	
	private int dim;
	private ficha[][] tabla;
	private ficha f=new ficha();
	public tablero (int dim) {
		this.dim=dim;
		this.tabla= new ficha[dim][dim];
	}
	
	public void DibujarTableroinicial() {
		for(int i=0; i<this.dim;i++) {
			for(int p=0;p<this.dim;p++) {
				this.tabla[i][p]=this.f;
			}}
		DibujarTablero();
	}
	
	public void DibujarTablero() {
		for(int i=0; i<this.dim;i++) {
			for(int p=0;p<this.dim;p++) {
				System.out.print(this.tabla[i][p].getColor()+" ");
			}
			System.out.println();
		}
	}
	
	public int celdavacia(int col) {
		
		
		int celda;
		for(celda=(this.dim-1);(celda>0)&&(this.tabla[celda][col]!=this.f);celda--) {
				
		}
		
		return celda;
	}
	
	public void colocarficha(int col,ficha color) {
		Scanner sc;
		int cel = celdavacia(col);
		if(this.tabla[cel][col]!=this.f) {
			sc = new Scanner(System.in);
			while(this.tabla[cel][col]!=this.f){
				do {
				System.out.println("Ingrese otra columna");
				col= sc.nextInt();}while(col>this.dim-1);
				cel = celdavacia(col);
			}
		}
		this.tabla[cel][col]=color;
	}
	
	public boolean ganador(ficha jugador){
		
		boolean ganar=false;
		
		//horizontal
		for(int celda=0;(celda<this.dim)&&(ganar==false);celda++) {
			
		for(int i=0;(i<(this.dim-2))&&(ganar==false);i++) {
			
			int contar=0;
			if(tabla[celda][i]==jugador) {
				contar++;
				
			for(int p=i+1;p<(i+3);p++) {
				
				if(tabla[celda][p]==jugador) {
					contar++;
				}
				if(contar==3) {
					ganar=true;
				}
			}}
		}}
		
		//vertical
		for(int celda=0;(celda<this.dim)&&(ganar==false);celda++) {
			
			for(int i=0;(i<(this.dim-2))&&(ganar==false);i++) {
				
				int contar=0;
				if(tabla[i][celda]==jugador) {
					contar++;
					
				for(int p=i+1;p<(i+3);p++) {
					
					if(tabla[p][celda]==jugador) {
						contar++;
					}
					if(contar==3) {
						ganar=true;
					}
				}}
			}}
		
			//diagonal
		for(int celda=0;(celda<this.dim-2)&&(ganar==false);celda++) {
			for(int columna=0;(columna<this.dim-2)&&(ganar==false);columna++) {
				int contar=0;
				int aux=celda+1;
				if(tabla[celda][columna]==jugador) {
					contar++;
					for(int p=columna+1;p<(columna+3);p++) {
						if(tabla[aux][p]==jugador) {
							contar++;
						}
						if(contar==3) {
							ganar=true;
						}
						aux++;
					}
				}
			}
		}
		
		for(int celda=0;(celda<this.dim-2)&&(ganar==false);celda++) {
			for(int columna=this.dim-1;(columna>0)&&(ganar==false);columna--) {
				int contar=0;
				int aux=celda+1;
				if(tabla[celda][columna]==jugador) {
					contar++;
					for(int p=columna-1;(p>0)&&(aux<5);p--) {
						if(tabla[aux][p]==jugador) {
							contar++;
						}
						if(contar==3) {
							ganar=true;
						}
						aux++;
					}
				}
			}
		}
		
		return ganar;
	}
}
