package Vista;

import Modelo.UsuarioDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;

public class Login extends javax.swing.JPanel {


    public Login() {
        initComponents();
        File archivo=new File("recordar.txt");
        if(archivo.exists()){//compruebo que existe un el fichero con el usuario a recorder si existe escribo el usuario en el textField y marco el checkbox
            recordar.setSelected(true);
            BufferedReader br=null;
            try{
                br=new BufferedReader(new FileReader(archivo));
                String s=br.readLine();
                user.setText(s);
            }catch(Exception e){
                System.out.println("Error escritura");
            }finally{
                try{
                    if(br!=null)
                        br.close();
                }catch(Exception e){
                System.out.println("Error escritura");
                }
            }
        }
    }

    public boolean comprobarUsuario(){
        Boolean authenticate;//variable que guarda si existe el usuario en la base de datos
        UsuarioDB login=new UsuarioDB();
        authenticate=login.authenticate(user.getText().trim(), pass.getText().trim());//llamo al metodo authenticate que realizara la consulta y devolvera un boolean
        if(this.recordar.isSelected()){//si recordar esta marcado escribo el usuario en el txt
            File archivo=new File("recordar.txt");
            PrintWriter pw=null;
            try{
                pw=new PrintWriter(new FileWriter(archivo));
                pw.print(user.getText().trim());
            }catch(Exception e){
                System.out.println("Error escritura");
            }finally{
                try{
                    if(pw!=null)
                        pw.close();
                }catch(Exception e){
                System.out.println("Error escritura");
                }
            }
        }else{//si recorder no esta marcado compruebo que existe el txt, si existe borro el txt
            File archivo=new File("recordar.txt");
            if(archivo.exists())
                archivo.delete();
        }
        
        return authenticate;
    }
    
    public String getUsuario(){
        return user.getText().trim();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        recordar = new javax.swing.JCheckBox();
        pass = new javax.swing.JPasswordField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña");

        user.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        recordar.setText("Recordar Usuario");

        pass.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(pass)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(recordar)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(recordar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JCheckBox recordar;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
