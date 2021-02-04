/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import BaseDeDatos.Conection;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlollos Pc
 */
public class UsuariosRegistrados {
    
    public int id;
    public String userName;
    public String password;
    public String image;
    public int gamesPlayed;
    public String userType;
    public int gamesWined;

    public UsuariosRegistrados(String[] userArray) throws SQLException {
        
        this.id = Integer.parseInt(userArray[0]);
        this.userName = userArray[1];
        this.password = userArray[2];
        this.image = userArray[3];
        this.gamesPlayed = Integer.parseInt(userArray[4]);
        this.userType = userArray[5];
        this.gamesWined = Integer.parseInt(userArray[6]);
        
    }

    public UsuariosRegistrados(String userName, String password, String image, int gamesPlayed, String userType , int gamesWined) {
        this.userName = userName;
        this.password = password;
        this.image = image;
        this.gamesPlayed = gamesPlayed;
        this.userType = userType;
        this.gamesWined = gamesWined;
    }

    public static ImageIcon obtenerImagen(int idUser) throws SQLException{
        InputStream is = null;
        ImageIcon img = null;
        String sql="SELECT image FROM users WHERE id="+idUser;
        try {
            Conection con = new Conection();
            Statement sentenciaSQL = con.Conectarse().createStatement();
            ResultSet rs=sentenciaSQL.executeQuery(sql);
            if(rs.next()){
                is=rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                img = new ImageIcon(bi);
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }

        return img;
    }
    
    
    
}
