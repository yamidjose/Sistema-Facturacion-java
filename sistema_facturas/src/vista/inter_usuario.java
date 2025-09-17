package vista;

import controlador.ctrl_cliente;
import controlador.ctrlusuario;
import modelo.usuario;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author YAMID
 */
public class inter_usuario extends javax.swing.JInternalFrame {

    int obteneridcategoriacombo = 0;

    public inter_usuario() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("nuevo cliente");
        txt_password.setVisible(true);
        txt_contravisible.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txt_telefono = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jCheckBox_vreclave = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txt_contravisible = new javax.swing.JTextField();
        jPanel1 = new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 25));

        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        txtusuario.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 220, 25));

        txtapellido.setBackground(new java.awt.Color(255, 255, 255));
        txtapellido.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 220, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("telefono");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 0, 0));
        btnguardar.setText("guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(255, 255, 255));
        txt_telefono.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 220, 25));

        txt_password.setAlignmentX(23.0F);
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 220, 25));
        txt_password.getAccessibleContext().setAccessibleName("");

        jCheckBox_vreclave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_vreclaveMouseClicked(evt);
            }
        });
        jCheckBox_vreclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_vreclaveActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_vreclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 40, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("nuevo Usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        txt_contravisible.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_contravisible.setSelectionEnd(120);
        txt_contravisible.setSelectionStart(140);
        txt_contravisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contravisibleActionPerformed(evt);
            }
        });
        getContentPane().add(txt_contravisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 220, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        // Crear y llenar el cliente con datos del formulario
        usuario client = new usuario();
        client.setNombre(txtnombre.getText().trim());
        client.setApellido(txtapellido.getText().trim());
        client.setUsuario(txtusuario.getText().trim());
        client.setContraseña(txt_password.getText().trim());
        client.setTelefono(txt_telefono.getText().trim());
        client.setEstado(1); // Puedes cambiarlo si usas otro estado

        ctrlusuario controlcliente = new ctrlusuario();

        // Validaciones mínimas
        if (!client.getNombre().isEmpty() && !client.getApellido().isEmpty() && !client.getUsuario().isEmpty()) {
            if (!controlcliente.existeusuario(client.getUsuario())) {
                if (controlcliente.guardar(client)) {
                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente");
                    limpiar(); // limpia los campos del formulario
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar cliente en la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este cliente ya existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios");
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void txt_contravisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contravisibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contravisibleActionPerformed

    private void jCheckBox_vreclaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_vreclaveMouseClicked
        if (jCheckBox_vreclave.isSelected() == true) {
            String pass = "";
            char[] passingre = txt_password.getPassword();
            for (int i = 0; i < passingre.length; i++) {
                pass += passingre[i];
            }
            txt_contravisible.setText(pass);
            txt_password.setVisible(false);
            txt_contravisible.setVisible(true);
        } else {
             String pass_ingresado = txt_contravisible.getText().trim();
    txt_password.setText(pass_ingresado);
    txt_password.setVisible(true);
    txt_contravisible.setVisible(false);
        }


    }//GEN-LAST:event_jCheckBox_vreclaveMouseClicked

    private void jCheckBox_vreclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_vreclaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_vreclaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox jCheckBox_vreclave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_contravisible;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
// metodo paalimpiar campos
    private void limpiar() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtusuario.setText("");
        txt_password.setText("");
        txt_telefono.setText("");
    }

}
