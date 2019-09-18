package edu.eci.cvds.juego;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "guessBean")
@SessionScoped
public class Juego{
	private int numero=(int)(Math.random() * 1000 + 1);
	private int intentos=0;
	private int premio=100000;
	private String estado="En juego";
	private int numeroIngresado=0;
	private ArrayList<Integer> intentosRealizados = new ArrayList<Integer>();
	
	public Juego(){
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public int getIntentos(){
		return this.intentos;
	}
	
	public int getPremio(){
		return this.premio;
	}
	
	public String getEstado(){
		return this.estado;
	}
	
	public int getNumeroIngresado(){
		return this.numeroIngresado;
	}
	
	public ArrayList<Integer> getIntentosRealizados(){
		return this.intentosRealizados;
	}
	
	public void setNumero(int n){
		this.numero = n;
	}
	
	public void setIntentos(int n){
		this.intentos = n;
	}
	
	public void setEstado(String s){
		this.estado = s;
	}
	
	public void setPremio(int n){
		if (n >= 0){
			this.premio = n;
		}
	}
	
	public void setNumeroIngresado(int n){
		this.numeroIngresado = n;
	}
	
	public void setIntentosRealizados(ArrayList<Integer> l){
		this.intentosRealizados = l;
	}
	
	public void guess(){
		if (estado.equals("En juego")){
			intentosRealizados.add(numeroIngresado);
			if (numeroIngresado == getNumero()){
				setEstado("Gano");
			}
			else{
				setIntentos(intentos + 1);
				setPremio(premio - 10000);
			}
		}
	}
	
	public void restart(){
		intentosRealizados.clear();
		setPremio(100000);
		setEstado("En juego");
		setIntentos(0);
		setNumero((int)(Math.random() * 1000 + 1));
		setNumeroIngresado(0);
	}
}