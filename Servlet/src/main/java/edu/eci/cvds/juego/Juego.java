package edu.eci.cvds.juego;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class Juego{
	private int numero;
	private int intentos=0;
	private int premio=100000;
	private String estado="en juego";
	
	public Juego(){
	}
	
	public int getNumero(){
		return numero;
	}
	
	public int getIntentos(){
		return intentos;
	}
	
	public int getPremio(){
		return premio;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public void setNumero(int n){
		numero = n;
	}
	
	public void setIntentos(int n){
		intentos = n;
	}
	
	public void setEstado(String s){
		estado = s;
	}
	
	public void setPremio(int n){
		premio = n;
	}
	
	public void guess (int n){
		if (n == getNumero()){
			setEstado("gano");
		}
		else{
			setIntentos(intentos + 1);
			setPremio(premio - 10000);
		}
	}
	
	public void restart(){
		setPremio(100000);
		setEstado("en juego");
		setIntentos(0);
	}
}