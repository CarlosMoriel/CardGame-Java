
import BaseDeDatos.Conection;
import Logica.UsuariosRegistrados;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Carlollos Pc
 */
public class UserPanel extends javax.swing.JPanel {

    
    static UsuariosRegistrados actualUser;
    
    static LinkedList<UsuariosRegistrados> allUsers;
    
    String nombreNuevaImagen;
    
    public UserPanel(UsuariosRegistrados actualUser , LinkedList<UsuariosRegistrados> allUsers) throws FileNotFoundException, SQLException {
        initComponents();
        
        this.allUsers = allUsers;
        this.actualUser = actualUser;
        
        if(actualUser.userType.equals("Admin")){
            this.lblMessageWelcome.setText("Bienvenido Administrador "+actualUser.userName);
        }else{
            this.lblMessageWelcome.setText("Bienvenido Usuario "+actualUser.userName);
        }
        
        //Esconder panel contraseñas
        this.panelPaswords.setVisible(false);
        this.btnNewImage.setVisible(false);
        this.btnSaveInformation.setVisible(false);
        //Iniciar informacion
        this.txtUserName.setText(actualUser.userName);
        this.txtUserName.disable();
        this.lblGamesPlayed.setText("Juegos Jugados:  "+Integer.toString(actualUser.gamesPlayed));
        this.lblGamesWined.setText( "Juegos Ganados:  "+Integer.toString(actualUser.gamesWined));
        this.lblUserType.setText(   "Tipo de usuario: "+actualUser.userType);
       
        //Poner imagen de perfil
        ImageIcon iconoTamañoReal = actualUser.obtenerImagen(actualUser.id);
        Icon icono = new ImageIcon(iconoTamañoReal.getImage().getScaledInstance(190, 160, Image.SCALE_DEFAULT));
        this.iconImage.setIcon(icono);
        
        //Obtener tabla historial
        getGamesHistory(actualUser.id);
        
        this.nombreNuevaImagen = actualUser.image;
        
    }

    
       
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new javax.swing.JPanel();
        iconImage = new javax.swing.JLabel();
        lblMessageWelcome = new javax.swing.JLabel();
        modiftInformation = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        lblGamesWined = new javax.swing.JLabel();
        lblGamesPlayed = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelPaswords = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtConfirmNewPassowd = new javax.swing.JPasswordField();
        txtPasswordActual = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSaveInformation = new javax.swing.JButton();
        btnNewImage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHistoryPersonal = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage.setBackground(new java.awt.Color(204, 255, 255));

        iconImage.setBackground(new java.awt.Color(204, 255, 255));
        iconImage.setMaximumSize(new java.awt.Dimension(100, 100));
        iconImage.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconImage, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelImageLayout.setVerticalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconImage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, 160));

        lblMessageWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMessageWelcome.setText("Bienvenido ");
        add(lblMessageWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        modiftInformation.setBackground(new java.awt.Color(204, 204, 204));
        modiftInformation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modiftInformation.setText("Modificar Informacion");
        modiftInformation.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                modiftInformationStateChanged(evt);
            }
        });
        add(modiftInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre de usuario:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblGamesWined.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGamesWined.setText("Partidas ganadas:");
        add(lblGamesWined, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblGamesPlayed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGamesPlayed.setText("Partidas Jugadas:");
        add(lblGamesPlayed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lblUserType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserType.setText("Tipo de usuario:");
        add(lblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel7.setText("Icono de jugador:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        panelPaswords.setBackground(new java.awt.Color(204, 204, 204));
        panelPaswords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Confirmar Nueva Contraseña:");
        panelPaswords.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Contraseña Actual:");
        panelPaswords.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));
        panelPaswords.add(txtConfirmNewPassowd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 160, -1));
        panelPaswords.add(txtPasswordActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 160, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nueva contraseña:");
        panelPaswords.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));
        panelPaswords.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 160, -1));

        jLabel11.setText("Cambiar Contraseña");
        panelPaswords.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        add(panelPaswords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 390, 140));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 170, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Historial de partidas:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        btnSaveInformation.setText("Guardar informacion");
        btnSaveInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInformationActionPerformed(evt);
            }
        });
        add(btnSaveInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        btnNewImage.setText("Subir Imagen");
        btnNewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewImageActionPerformed(evt);
            }
        });
        add(btnNewImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        tableHistoryPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableHistoryPersonal);
        if (tableHistoryPersonal.getColumnModel().getColumnCount() > 0) {
            tableHistoryPersonal.getColumnModel().getColumn(0).setResizable(false);
            tableHistoryPersonal.getColumnModel().getColumn(1).setResizable(false);
            tableHistoryPersonal.getColumnModel().getColumn(2).setResizable(false);
            tableHistoryPersonal.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 520, 180));
    }// </editor-fold>//GEN-END:initComponents

    private void modiftInformationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_modiftInformationStateChanged
        
        if(this.modiftInformation.isSelected()){//Activar modificacion
            
            this.panelPaswords.setVisible(true);
            this.btnNewImage.setVisible(true);
            this.btnSaveInformation.setVisible(true);
            this.txtUserName.enable();
            
        }else{ //Desactivar modificacion
            
            this.panelPaswords.setVisible(false);
            this.btnNewImage.setVisible(false);
            this.btnSaveInformation.setVisible(false);
            this.txtUserName.disable();
            
        }
        
        
    }//GEN-LAST:event_modiftInformationStateChanged

    private void btnNewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewImageActionPerformed
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG Imagenes", "jpg", "png");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setFileFilter(filtro);
        fileChooser.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:/");
        fileChooser.setCurrentDirectory(ruta);
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado != JFileChooser.CANCEL_OPTION) {
            File nombreArchivo = fileChooser.getSelectedFile();
            nombreNuevaImagen = String.valueOf(nombreArchivo);
            Image foto = getToolkit().getImage(nombreNuevaImagen);
            foto = foto.getScaledInstance(190, 160, Image.SCALE_DEFAULT);
            this.iconImage.setIcon(new ImageIcon(foto));
        }
        
    }//GEN-LAST:event_btnNewImageActionPerformed

    private void btnSaveInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInformationActionPerformed
      
        String newImage;
        String newPassword = "";
        String newUserName = "";
        
        
        boolean flagUpdate = true;
        
        //Ver si se modifico la imagen
        if(nombreNuevaImagen == null){
            newImage = this.nombreNuevaImagen;
        }else{
            newImage = this.actualUser.image;
        }
        
        //Validacion campo user name
        if(txtUserName.getText().equals("")){
            newUserName = this.actualUser.userName;
            JOptionPane.showMessageDialog(this, "Su nombre de usuario no puede quedar vacio");
            flagUpdate = false;
        }else{
            newUserName = txtUserName.getText();
        }
        
        
        //Validacion campo contraseña
        if(this.txtPasswordActual.getText().equals("") || !(this.txtPasswordActual.getText().equals(actualUser.password)) ){
            newUserName = this.actualUser.userName;
            JOptionPane.showMessageDialog(this, "Ingrese su contraseña actual correctamente");
            flagUpdate = false;
        }
        
        //Validacion nueva contraseña
        if(!(this.txtNewPassword.getText().equals(this.txtConfirmNewPassowd.getText()) )){
            JOptionPane.showMessageDialog(this, "La nueva contraseña debe coincidir porfavor intente de nuevo");
            flagUpdate = false;
        }else{
            newPassword = txtNewPassword.getText();
        }
        
        for (UsuariosRegistrados user : allUsers) {
            if(txtUserName.getText().equals(user.userName) && !(txtUserName.getText().equals(actualUser.userName)) ){
                flagUpdate = false;
                JOptionPane.showMessageDialog(this, "Este nombre de usuario ya esta en uso");
            }
        }
        
 
        
        if(flagUpdate){
            try {
                
            
            FileInputStream archivofoto;
            archivofoto= new FileInputStream(this.nombreNuevaImagen);
            
            
            String sql;
            Conection con = new Conection();
            Statement sentenciaSQL=con.Conectarse().createStatement(); //crear consulta
            sql = "UPDATE users SET userName='"+newUserName+"' ,password='"+newPassword+"' , `image`=? WHERE id=?";
            
            PreparedStatement pst = con.Conectarse().prepareStatement(sql);
            
            pst.setBinaryStream(1, archivofoto);
            pst.setInt(2, actualUser.id);
            
            int n=pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Registro Modificado","Confirmación",JOptionPane.INFORMATION_MESSAGE);
            }
            
            
            
            con.CerrarConexion();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
        
    }//GEN-LAST:event_btnSaveInformationActionPerformed

    
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
            
            sql = "SELECT * FROM users WHERE id="+actualUser.id;
            resul = cn.Conectarse().createStatement().executeQuery(sql);
            resulSetMetaData = resul.getMetaData();

            columLength = resulSetMetaData.getColumnCount();

            //Todos los usuarios

            while (resul.next()) { //mientras la tabla tenga registros
                String [] fila=new String[columLength];
                for(int j=0;j<columLength;j++){
                    fila[j]=resul.getString(j+1);
                }
                UsuariosRegistrados newUser = new UsuariosRegistrados(fila);
                actualUser = newUser;
            } 
            
            allUsers = users;
            
            
        }catch(Exception e){
            
        }
        
       
    }

        public void getGamesHistory(int id){
           
        try {
            String sql;
            Conection con = new Conection();
            Statement sentenciaSQL=con.Conectarse().createStatement(); //crear consulta
            sql = "SELECT idGame,winner,rounds,players FROM games WHERE idUser="+id;
            ResultSet rs= sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm=rs.getMetaData();
            int col=rsm.getColumnCount();
            DefaultTableModel modelo=new DefaultTableModel();
            for(int i=1;i<=col;i++){
                modelo.addColumn(rsm.getColumnLabel(i));//para poner los encabezados de la tabla
            }
            while (rs.next()) {//mientras la tabla tenga registros
                String [] fila=new String[col];
                for(int j=0;j<col;j++){
                    fila[j]=rs.getString(j+1);
                }
                modelo.addRow(fila);
            }
            
            this.tableHistoryPersonal.setModel(modelo);//asignando una tabla llena a una tabla vacía
            rs.close();
            con.CerrarConexion();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewImage;
    private javax.swing.JButton btnSaveInformation;
    private javax.swing.JLabel iconImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGamesPlayed;
    private javax.swing.JLabel lblGamesWined;
    private javax.swing.JLabel lblMessageWelcome;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JCheckBox modiftInformation;
    private javax.swing.JPanel panelImage;
    private javax.swing.JPanel panelPaswords;
    private javax.swing.JTable tableHistoryPersonal;
    private javax.swing.JPasswordField txtConfirmNewPassowd;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtPasswordActual;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
