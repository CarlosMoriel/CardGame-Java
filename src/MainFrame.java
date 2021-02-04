
import BaseDeDatos.Conection;
import Logica.UsuariosRegistrados;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;



/**
 *
 * @author Carlollos Pc
 */
public class MainFrame extends javax.swing.JFrame {
    
    
     static MainMenuPanel MenuPanel;
     OnePlayer One;
     
     static UserPanel userPanel;
     AdminPanel adminPanel;
     
     String UserName;
     static UsuariosRegistrados userActual;
     
     
     //Datos
     static LinkedList<UsuariosRegistrados> allUsers;
     static String userName;
     
    public MainFrame(String UserType , String UserName, LinkedList<UsuariosRegistrados> allUsers , UsuariosRegistrados userActual) throws ClassNotFoundException, SQLException, FileNotFoundException {
        
        initComponents();
        //Centrar pantalla
        this.setLocationRelativeTo(null);
        
        this.userActual = userActual;
        this.UserName = UserName;
        
        //Titulo del frame
        this.setTitle("Friegate al vecino - Menu Principal");
        
        //Establecer el icono del frame
        URL iconURL = getClass().getResource("\\src\\images\\FondoCartas.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        //Establecer etiqueta de usuario
        this.lblUserType.setText("Tipo de usuario: " + UserType);
        MenuPanel = new MainMenuPanel(this.getContentPane() , UserName , allUsers);
        this.PanelContent.add(MenuPanel);
        
        
        this.One = new OnePlayer(UserName , this , userActual);
        this.PanelContent.add(One);
        this.One.setVisible(false);
        
        //Pantalla de Usuario
        this.userPanel = new UserPanel(userActual , allUsers );
        this.PanelContent.add(this.userPanel);
        this.userPanel.setVisible(false);
        
        //Pantalla administrador
        this.adminPanel = new AdminPanel(userActual);
        this.PanelContent.add(adminPanel);
        this.adminPanel.setVisible(false);
        
        //Detectar el tipo de usuario
        if(UserType.equalsIgnoreCase("Admin")) this.btnAdminUsers.setVisible(true);
        else this.btnAdminUsers.setVisible(false);
        
        //Datos globales
        this.allUsers = allUsers;
        this.userName = UserName;
        
    }

    public static void getInfoUsersAgain() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        try{
            Conection cn = new Conection();

            String sql = "SELECT * FROM users";
            ResultSet resul = cn.Conectarse().createStatement().executeQuery(sql);
            ResultSetMetaData resulSetMetaData = resul.getMetaData();

            int columLength = resulSetMetaData.getColumnCount();

            //Todos los usuarios
            LinkedList<UsuariosRegistrados> users = new LinkedList();

            while (resul.next()) { //mientras la tabla tenga registros
                String [] fila=new String[columLength];
                for(int j=0;j<columLength;j++){
                    fila[j]=resul.getString(j+1);
                }
                UsuariosRegistrados newUser = new UsuariosRegistrados(fila);
                users.add(newUser);

            } 
            
            allUsers = users;
            userPanel = new UserPanel(userActual , allUsers);
            userPanel.setVisible(false);
            
            MenuPanel.setVisible(true);
            
        }catch(Exception e){
            
        }
        
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContent = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblUserType = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JLabel();
        btnJugar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPorfile = new javax.swing.JLabel();
        btnAdminUsers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContent.setBackground(new java.awt.Color(255, 255, 255));
        PanelContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(PanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 660, 660));

        jPanel2.setBackground(new java.awt.Color(40, 171, 185));

        jPanel1.setBackground(new java.awt.Color(40, 171, 185));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserType.setForeground(new java.awt.Color(239, 250, 211));
        lblUserType.setText("Tipo de usuario:");
        jPanel1.add(lblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/cards.png"))); // NOI18N

        btnMainMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMainMenu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMainMenu.setForeground(new java.awt.Color(239, 250, 211));
        btnMainMenu.setText("             Menu Principal");
        btnMainMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMainMenuMouseClicked(evt);
            }
        });

        btnJugar.setBackground(new java.awt.Color(255, 255, 255));
        btnJugar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnJugar.setForeground(new java.awt.Color(239, 250, 211));
        btnJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/manaje.png"))); // NOI18N
        btnJugar.setText("          Jugar");
        btnJugar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJugarMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/logout.png"))); // NOI18N
        jLabel7.setToolTipText("Cerrar sesión");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        btnPorfile.setBackground(new java.awt.Color(255, 255, 255));
        btnPorfile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPorfile.setForeground(new java.awt.Color(239, 250, 211));
        btnPorfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/config.png"))); // NOI18N
        btnPorfile.setText("          Perfil");
        btnPorfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPorfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPorfileMouseClicked(evt);
            }
        });

        btnAdminUsers.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminUsers.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdminUsers.setForeground(new java.awt.Color(239, 250, 211));
        btnAdminUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/adminUsers.png"))); // NOI18N
        btnAdminUsers.setText("            Administrar");
        btnAdminUsers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdminUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminUsersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPorfile, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnJugar)
                .addGap(28, 28, 28)
                .addComponent(btnPorfile, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        
         try {
             new LoginFrame().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.setVisible(false);
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMouseClicked
      
        //Abrir nueva ventana
        this.One.setVisible(true);
        
        //Cerrar otras ventanas
        this.MenuPanel.setVisible(false);
        this.userPanel.setVisible(false);
        this.adminPanel.setVisible(false);
        repaint();
        
    }//GEN-LAST:event_btnJugarMouseClicked

    private void btnMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMainMenuMouseClicked
       
        //Abrir ventana
        this.MenuPanel.setVisible(true);
        
        //Cerrar otras ventanas
        this.One.setVisible(false);
        this.userPanel.setVisible(false);
        this.adminPanel.setVisible(false);
        repaint();
        
    }//GEN-LAST:event_btnMainMenuMouseClicked

    private void btnPorfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPorfileMouseClicked
       
        this.userPanel.setVisible(true);
        
        //Cerrar otras ventanas
        this.One.setVisible(false);
        this.MenuPanel.setVisible(false);
        this.adminPanel.setVisible(false);
        repaint();
        
    }//GEN-LAST:event_btnPorfileMouseClicked

    private void btnAdminUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminUsersMouseClicked

        
        this.adminPanel.setVisible(true);
        
        //Cerrar otras ventanas
        this.userPanel.setVisible(false);
        this.One.setVisible(false);
        this.MenuPanel.setVisible(false);
        
    }//GEN-LAST:event_btnAdminUsersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContent;
    private javax.swing.JLabel btnAdminUsers;
    private javax.swing.JLabel btnJugar;
    private javax.swing.JLabel btnMainMenu;
    private javax.swing.JLabel btnPorfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUserType;
    // End of variables declaration//GEN-END:variables
}
