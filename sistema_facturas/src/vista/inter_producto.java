package vista;

import Coneccion.Connecion;
import controlador.ctrl_producto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.producto;

/**
 *
 * @author YAMID
 */
public class inter_producto extends javax.swing.JInternalFrame {

    int obteneridcategoriacombo = 0;

    public inter_producto() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("nuevo producto");

        this.cargar_combo_categoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        jComboBox1_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        txtdescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jPanel1 = new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nuevo Producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Precio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripcion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categorias:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 240, 22));

        txtprecio.setBackground(new java.awt.Color(255, 255, 255));
        txtprecio.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 240, 22));

        txtcantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtcantidad.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, 22));

        jComboBox1_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione iva:", "19%", "no iva", " ", " " }));
        getContentPane().add(jComboBox1_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 240, -1));

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 240, -1));

        txtdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtdescripcion.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 240, 22));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("IVA:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 0, 0));
        btnguardar.setText("guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_categoriaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        producto produc = new producto();
        ctrl_producto controlproduct = new ctrl_producto();

        String iva = jComboBox1_iva.getSelectedItem().toString().trim();
        String categoria = jComboBox_categoria.getSelectedItem().toString().trim();

        if (txtnombre.getText().equals("") || txtcantidad.getText().equals("") || txtprecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "complete todos los campos");
            txtnombre.setBackground(Color.white);
            txtcantidad.setBackground(Color.white);
            txtprecio.setBackground(Color.white);
            return;
        }

        if (iva.equalsIgnoreCase("seleccione iva:")) {
            JOptionPane.showMessageDialog(null, "seleccione iva:");
            return;
        }

        if (categoria.equalsIgnoreCase("seleccione categoria:")) {
            JOptionPane.showMessageDialog(null, "seleccione categoria:");
            return;
        }

        if (controlproduct.existeproducto(txtnombre.getText().trim())) {
            JOptionPane.showMessageDialog(null, "el producto ya existe");
            return;
        }

        try {
            produc.setNombre(txtnombre.getText().trim());
            produc.setCantidad(Integer.parseInt(txtcantidad.getText().trim()));

            String preciotxt = txtprecio.getText().trim().replace(",", ".");
            double precio = Double.parseDouble(preciotxt);
            produc.setPrecio(precio);

            produc.setDescripcion(txtdescripcion.getText().trim());

            if (iva.equalsIgnoreCase("no iva")) {
                produc.setPorcentaje_iva(0);
            } else if (iva.equalsIgnoreCase("19%")) {
                produc.setPorcentaje_iva(19);
            }

            this.id_categoria();
            produc.setId_categoria(obteneridcategoriacombo);
            produc.setEstado(1);

            if (controlproduct.guardar(produc)) {
                JOptionPane.showMessageDialog(null, "registro guardado");
                this.cargar_combo_categoria();
                jComboBox1_iva.setSelectedItem("seleccione iva:");
                this.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "error al guardar");
            }

        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("error en " + e);
        }


    }//GEN-LAST:event_btnguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> jComboBox1_iva;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
// metodo paalimpiar campos
    private void limpiar() {
        txtnombre.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        txtdescripcion.setText("");
    }

    private void cargar_combo_categoria() {
        Connecion conexion = new Connecion(); // Usa el tipo correcto
        Connection cn = conexion.getConnection();
        String sql = " select * from t_categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("seleccione categoria: ");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));

            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error al cargar las categorias");
        }

    }

    private int id_categoria() {
        String sql = " select * from t_categoria where descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connecion conexion = new Connecion(); // Usa el tipo correcto
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obteneridcategoriacombo = rs.getInt("id_categoria");

            }
        } catch (Exception e) {
            System.out.println("error al cargar la categoria");
        }
        return obteneridcategoriacombo;
    }
}
