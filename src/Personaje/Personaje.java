package Personaje;


public abstract class Personaje { // Clase abstracta Personaje

	protected String nombre;
	protected int vida;
	protected int misiles_ronda;
	protected String tipoPersonaje;
	
	public Personaje() {
		
	}
	
	public Personaje(String nombre, int vida , int misiles_ronda, String tipoPersonaje) {
		this.nombre = nombre;
		this.vida = vida;
		this.misiles_ronda = misiles_ronda;
		this.tipoPersonaje = tipoPersonaje;
	}

	public String getNombre(){
		return nombre;
	}

	public int getVida(){
		return vida;
	}

	public int getMisiles_ronda(){
		return misiles_ronda;
	}

	public String getTipoPersonaje(){
		return tipoPersonaje;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setVida(int vida){
		this.vida = vida; 
	}

	public void setMisiles_ronda(int misiles_ronda){
		this.misiles_ronda = misiles_ronda;
	}

	public void setTipoPersonaje(String tipoPersonaje){
		this.tipoPersonaje = tipoPersonaje;
	}
	
	public void restaMisiles(int misilesAtaque){
		misiles_ronda -= misilesAtaque;
	}
	
	public String curacion(int misilesCura){
		
		vida += misilesCura/2; // Sumamos la vida 
		misiles_ronda -= misilesCura;

		return nombre + " se a curado con " + misilesCura +" pociones\n"; // Devolvemos la accion realizada 
	}
	
	public abstract String ataque(int misilesAtaque, Personaje atacado);
}
