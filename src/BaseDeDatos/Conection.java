/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlollos
 */

public class Conection {
    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet resultado;
    
    public Conection () throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String controlador="com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        
        String URL="jdbc:mysql://localhost:3306/friegate_al_vecino?zeroDateTimeBehavior=convertToNull";
        String usuario="root";
        String contraseña="";
        conexion=DriverManager.getConnection(URL,usuario,contraseña);
    }
    
    public Connection Conectarse(){
        return conexion;
    }
    
    public void CerrarConexion() throws SQLException{
        if(resultado != null)resultado.close();
        if(sentenciaSQL != null)sentenciaSQL.close();    
        if(conexion != null)conexion.close();
        
    }
}
