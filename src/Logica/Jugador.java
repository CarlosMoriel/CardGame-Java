

package Logica;


public class Jugador {
    
    public String NombreUsuario;
    public Jugador SiguienteJugador;
    public int CartaActual;
    public int RondasGanadas;
    public String Tipo;
    
    public Jugador(String Nombre , String Tipo){
        this.NombreUsuario = Nombre;
        this.SiguienteJugador = null;
        this.CartaActual = 0;
        this.RondasGanadas = 0;
        this.Tipo = Tipo;
    }
    
    public void EnlazarJugador(Jugador JugadorAEnlazar){
        this.SiguienteJugador = JugadorAEnlazar;
    }
   
    public void AsignarCarta(int NumCarta){
        this.CartaActual = NumCarta;
    }
    
}
