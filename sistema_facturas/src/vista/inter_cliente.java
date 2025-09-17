package vista;

import controlador.ctrl_cliente;
import modelo.cliente;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author YAMID
 */
public class inter_cliente extends javax.swing.JInternalFrame {

    int obteneridcategoriacombo = 0;

    public inter_cliente() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("nuevo cliente");
      

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtdireccion = new javax.swing.JTextField();
        jPanel1 = new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("nuevo Cliente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

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
        jLabel3.setText("cedula:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 240, 22));

        txtcedula.setBackground(new java.awt.Color(255, 255, 255));
        txtcedula.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 240, 22));

        txtapellido.setBackground(new java.awt.Color(255, 255, 255));
        txtapellido.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 240, 22));

        txttelefono.setBackground(new java.awt.Color(255, 255, 255));
        txttelefono.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 240, 22));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("direccion");
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

        txtdireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtdireccion.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 240, 22));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        

        // Crear y llenar el cliente con datos del formulario
        cliente client = new cliente();
        client.setNombre(txtnombre.getText().trim());
        client.setApellido(txtapellido.getText().trim());
        client.setCedula(txtcedula.getText().trim());
        client.setTelefono(txttelefono.getText().trim());
        client.setDireccion(txtdireccion.getText().trim());
        client.setEstado(1); // Puedes cambiarlo si usas otro estado

        ctrl_cliente controlcliente = new ctrl_cliente();

        // Validaciones mínimas
        if (!client.getNombre().isEmpty() && !client.getApellido().isEmpty() && !client.getCedula().isEmpty()) {
            if (!controlcliente.existecliente(client.getCedula())) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
// metodo paalimpiar campos
    private void limpiar() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");
    }

}
