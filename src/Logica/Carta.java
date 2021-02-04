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
public class Carta {
        
    public int Valor;
    public boolean Usada;
    public Carta Siguiente;
    
    public Carta(int valor){
        this.Valor = valor;
        this.Usada = false;
        Siguiente = null;
    }
    
    public void Enlazar(Carta nodo){
        this.Siguiente = nodo;
    }
    
}
