import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//Base de datos
import BaseDeDatos.Conection;
import Logica.UsuariosRegistrados;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Moriel
 */
public class LoginFrame extends javax.swing.JFrame {

    Conection cn;
    static LinkedList<UsuariosRegistrados> users;
    
    public LoginFrame() throws SQLException {
        initComponents();
        
        //Centrar pantalla
        this.setLocationRelativeTo(null);
        //Titulo del frame
        this.setTitle("Friegate al vecino");
        
        //Establecer el icono del frame
        URL iconURL = getClass().getResource("\\src\\images\\FondoCartas.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        //Conexion a la base de datos
        try {
            this.cn = new Conection();
            this.bdStatus.setText("Estado de la base de datos: Conexion Exitosa");
        }catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            this.bdStatus.setText("Estado de la base de datos: Error en la conexion");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            this.bdStatus.setText("Estado de la base de datos: Error en la conexion");
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            this.bdStatus.setText("Estado de la base de datos: Error en la conexion");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            this.bdStatus.setText("Estado de la base de datos: Error en la conexion");
        }
        
        getUsersRegister(this.cn);

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bdStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(370, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(40, 171, 185));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 97, 135));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 250, 211));
        jLabel1.setText("Login");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(239, 250, 211));
        jLabel3.setText("Friegate al vecino");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        txtUsuario.setToolTipText("Ingrese el nombre de usuario");
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 230, 30));

        txtContrasena.setToolTipText("Ingrese la contraseña de usuario");
        jPanel2.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 230, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(239, 250, 211));
        jLabel5.setText("Usuario");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/cards.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 170));

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogin.setText("Iniciar sesion");
        btnLogin.setToolTipText("Iniciar sesion");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(239, 250, 211));
        jLabel7.setText("Contraseña");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister.setText("Registrate!");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 230, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No tienes cuenta? ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 360, 580));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/infoicon.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        bdStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bdStatus.setForeground(new java.awt.Color(255, 255, 255));
        bdStatus.setText("Estado de la base de datos: ");
        jPanel1.add(bdStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         
        JOptionPane.showMessageDialog(null, ("Informacion del proyecto: \n"
                + "Nombre del alumno: Luis Carlos Moriel Enriquez \n"
                + "Numero de control: 18540525 \n"
                + "Materia: Topicos avanzados de programacion"));
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        boolean flagLogin = false;
        for (UsuariosRegistrados user : users) { //Busca entre todos los usuarios
            if(user.userName.equalsIgnoreCase(txtUsuario.getText()) && user.password.equals(txtContrasena.getText())){//Si coincide busca el tipo de usuario
                
                if( user.userType.equalsIgnoreCase("Normal") ){ //Tipo de usuario normal
                    try { 
                        new MainFrame("Normal" , user.userName , this.users , user).setVisible(true);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.setVisible(false);
                }else if( user.userType.equalsIgnoreCase("Admin") ){ //Tipo de usuario administrador
                    try {
                        new MainFrame("Admin" , user.userName , this.users , user).setVisible(true);
                        this.setVisible(false);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                //Activar la bandera
                flagLogin = true;
                break;
            }
        }
        
        if(!flagLogin){
             JOptionPane.showMessageDialog(null, "Informacion incorrecta intente de nuevo");
        }
        
        
       
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
     
        try {
            RegisterForm register = new RegisterForm(cn);
            register.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error Archivo de Imagen no encontrada: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRegisterActionPerformed

  
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               
                
                try {
                    new LoginFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
      
    public static void getUsersRegister(Conection cn) throws SQLException{
       
        String sql = "SELECT * FROM users";
        ResultSet resul = cn.Conectarse().createStatement().executeQuery(sql);
        ResultSetMetaData resulSetMetaData = resul.getMetaData();
        
        int columLength = resulSetMetaData.getColumnCount();
        
        //Todos los usuarios
        users = new LinkedList();
        
        while (resul.next()) { //mientras la tabla tenga registros
            String [] fila=new String[columLength];
            for(int j=0;j<columLength;j++){
                fila[j]=resul.getString(j+1);
            }
            UsuariosRegistrados newUser = new UsuariosRegistrados(fila);
            users.add(newUser);
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bdStatus;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
