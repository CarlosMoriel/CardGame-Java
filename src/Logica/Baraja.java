/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Carlollos Pc
 */
public class Baraja {
   
    Carta Inicio;
    Carta EnlaceAux;
    Carta Aux;
    
    public Baraja(){
        
        Inicio = new Carta(1);
        EnlaceAux = Inicio;
        for (int i = 2; i <= 52; i++) {
            Carta Nueva = new Carta(i);
            EnlaceAux.Enlazar(Nueva);
            EnlaceAux = Nueva;
        }
        
    }
    
    public boolean EsUnRey(int Valor){
        
        if(Valor >= 58){
            return true;
        }else{
            return false;
        }
       
    }
    
    public boolean ElementoUsado(int Valor){
        
        Aux = Inicio;
        for (int i = 0; i < 52; i++) {
            if(Aux.Valor == Valor){
                if(Aux.Usada){
                    return false;
                }else{
                    return true;
                }
            }else{
                Aux = Aux.Siguiente;
            }
        }
        return false;
        
    }
}
