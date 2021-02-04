
package Logica;



public class Juego {
    
    public Jugador PrimerJugador;
    public Jugador UltimoJugador;
    public int Ronda;
    public int RondasParaVictoria;
    public String Status;
    public Jugador Repartidor;
    public Jugador TurnoJugador;
    public Jugador RepartirJugador;
    
    Jugador ActualTemp;
    
    Baraja Mazo;
    
    
    
    //Iniciar un nuevo juego! 
    public Juego(String[] NombresJugadores , int RondasVictoria , UsuariosRegistrados ActualUser){
            
        for (int i = 0; i < NombresJugadores.length; i++) {
            if(i == 0){
                PrimerJugador = new Jugador(NombresJugadores[i] , "Jugador");
                ActualTemp = PrimerJugador;
                
                
                
            }else if(i == NombresJugadores.length-1){
                UltimoJugador = new Jugador(NombresJugadores[i] , "Ia");
                ActualTemp.EnlazarJugador(UltimoJugador);
                UltimoJugador.EnlazarJugador(PrimerJugador);
                ActualTemp = UltimoJugador;
            }else{
                Jugador Nuevo = new Jugador(NombresJugadores[i], "Ia");
                ActualTemp.EnlazarJugador(Nuevo);
                ActualTemp = Nuevo;
            }
        }//End for
        
        Repartidor = PrimerJugador;
        TurnoJugador = PrimerJugador;
        RepartirJugador = PrimerJugador;
        
        Ronda = 1;
        
        RondasParaVictoria = RondasVictoria;
        
        this.Mazo = new Baraja();
        
        
        
    }//End Constructor
    
    
    
    public void AvanzarJugador(){
        TurnoJugador = TurnoJugador.SiguienteJugador;
    }
    
    public void AvanzarRonda(){
        Ronda = Ronda + 1;
    }
    
    public void RepartirCarta(){
        int cont = 0;
        boolean flag = true;
        //Obtenemos una carta al azar
        int valorDado = (int) Math.floor(Math.random()*53+1);
        
        Jugador Aux = PrimerJugador;
        
        while(cont < 1){
            valorDado = (int) Math.floor(Math.random()*53+1);
            
            if(NoReprtirCarta(valorDado)){
                Aux.CartaActual = valorDado;
                Aux = Aux.SiguienteJugador;
                
            }
            
            if(Aux == PrimerJugador){
                cont++;
            }
        }
    }
    
    public void CambiarCarta(){
        int valorDado;
        Jugador Aux = TurnoJugador;
        while(true){
            valorDado = (int) Math.floor(Math.random()*53+1);
            
            if(NoReprtirCarta(valorDado)){
                Aux.CartaActual = valorDado;
                break;
            }
            
        }
    }
    
    public boolean NoReprtirCarta(int Valor){
        int cont = 0;
        Jugador Aux = PrimerJugador;
        while(cont < 1){
            
            if(Valor == Aux.CartaActual){
                return false;
            }
            Aux = Aux.SiguienteJugador;
            if(Aux == PrimerJugador){
                cont++;
            }
        }
        return true;
    }
    
    public Jugador BuscarGanador(int NumeroJugadores){
        int cont = 0;
        Jugador Aux = PrimerJugador;
        Jugador Ganador = null;
        int valorGanador = 0;
        
        for (int i = 0; i < NumeroJugadores; i++) {
             //System.out.println(Aux.NombreUsuario + "  " + Aux.CartaActual);
            
            if(Aux.CartaActual > valorGanador){
                valorGanador = Aux.CartaActual;
                Ganador = Aux;
            }
            
            Aux = Aux.SiguienteJugador;
        }
        //System.out.println("El ganador de la ronda es: "+Ganador.NombreUsuario);
        return Ganador;
    }
    
    public void AumentarRondaGanador(Jugador ganador){
       ganador.RondasGanadas++;
    }
    
    public void AvanzarRepatidor(){
        this.Repartidor = Repartidor.SiguienteJugador;
    }
    
}
