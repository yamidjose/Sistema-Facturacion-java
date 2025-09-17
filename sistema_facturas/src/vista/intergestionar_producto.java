package vista;

import Coneccion.Connecion;
import controlador.ctrl_producto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JTable;
import modelo.producto;

public class intergestionar_producto extends javax.swing.JInternalFrame {

    private int id_producto;
    int obteneridcategoriacombo = 0;

    public intergestionar_producto() {
        initComponents();
        this.setSize(900, 500);
        this.setTitle("Gestionar productos");
        this.CargarTablaProductos();
        this.CargarComboCategoria();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new vista.PanelDegradado();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jPanel2 = new vista.PanelDegradado();
        btnact = new javax.swing.JButton();
        btnelim = new javax.swing.JButton();
        jPanel3 = new vista.PanelDegradado();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jPanel4 = new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Administrar productos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnact.setBackground(new java.awt.Color(204, 204, 204));
        btnact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnact.setForeground(new java.awt.Color(0, 0, 0));
        btnact.setText("actualizar");
        btnact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactActionPerformed(evt);
            }
        });
        jPanel2.add(btnact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 25));

        btnelim.setBackground(new java.awt.Color(204, 204, 204));
        btnelim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnelim.setForeground(new java.awt.Color(0, 51, 51));
        btnelim.setText("eliminar");
        btnelim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimActionPerformed(evt);
            }
        });
        jPanel2.add(btnelim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("nombre:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("preicio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");

        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        txtdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IVA:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria:");

        jComboBox1_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione iva:", "19%", "no iva", " ", " " }));

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione categoria:", " " }));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_categoria, 0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1_iva, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactActionPerformed

        producto product = new producto();
        ctrl_producto controlProducto = new ctrl_producto();
        String iva = "";
        String categoria = "";
        iva = jComboBox1_iva.getSelectedItem().toString().trim();
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();

        //validar campos
        if (txtnombre.getText().isEmpty() || txtcantidad.getText().isEmpty() || txtprecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (iva.equalsIgnoreCase("Seleccione iva:")) {
                JOptionPane.showMessageDialog(null, "Seleccione iva.");
            } else {
                if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria");
                } else {
                    try {
                        product.setNombre(txtnombre.getText().trim());
                        product.setCantidad(Integer.parseInt(txtcantidad.getText().trim()));
                        String precioTXT = "";
                        double Precio = 0.0;
                        precioTXT = txtprecio.getText().trim();
                        boolean aux = false;
                        
                        /*
                            *Si el usuario ingresa , (coma) como punto decimal,
                            lo transformamos a punto (.)
                         */
                        for (int i = 0; i < precioTXT.length(); i++) {
                            if (precioTXT.charAt(i) == ',') {
                                String precioNuevo = precioTXT.replace(",", ".");
                                Precio = Double.parseDouble(precioNuevo);
                                aux = true;
                            }
                        }
                        //evaluar la condicion
                        if (aux == true) {
                            product.setPrecio(Precio);
                        } else {
                            Precio = Double.parseDouble(precioTXT);
                            product.setPrecio(Precio);
                        }

                        product.setDescripcion(txtdesc.getText().trim());
                        //Porcentaje IVA
                        if (iva.equalsIgnoreCase("No iva")) {
                            product.setPorcentaje_iva(0);
                        } else if (iva.equalsIgnoreCase("19%")) {
                            product.setPorcentaje_iva(19);
                        }

                        //idcategoria - cargar metodo que obtiene el id de categoria
                        this.id_categoria();
                        product.setId_categoria(obteneridcategoriacombo);
                        product.setEstado(1);

                        if (controlProducto.actualizar(product, id_producto)) {
                            JOptionPane.showMessageDialog(null, "Registro Actualizado");
                            this.CargarComboCategoria();
                            this.CargarTablaProductos();
                            this.jComboBox1_iva.setSelectedItem("Seleccione iva:");
                            this.Limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Actualizar");
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnactActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed


    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnelimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimActionPerformed
        ctrl_producto controlProducto = new ctrl_producto();
        if (id_producto == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Producto!");
        } else {
            if (!controlProducto.eliminar(id_producto)) {
                JOptionPane.showMessageDialog(null, "¡Producto Eliminado!");
                this.CargarTablaProductos();
                this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar producto!");
            }
        }

    }//GEN-LAST:event_btnelimActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescActionPerformed

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_categoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnact;
    private javax.swing.JButton btnelim;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txtnombre.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        txtdesc.setText("");
        jComboBox1_iva.setSelectedItem("Seleccione iva:");
        jComboBox_categoria.setSelectedItem("Seleccione categoria:");
    }

    private void CargarComboCategoria() {
        Connecion conexion = new Connecion(); // Usa el tipo correcto
        Connection cn = conexion.getConnection();
        String sql = "select * from t_categoria";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al cargar categorias!");
        }
    }

    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

 private void CargarTablaProductos() {
    Connecion conexion = new Connecion(); // Usa la clase de conexión correctamente
    Connection cn = conexion.getConnection();
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL con alias
    String sql = "SELECT p.id_producto, p.nombre, p.cantidad, p.precio, p.descripcion, " +
                 "p.porcentaje_iva, c.descripcion AS categoria, p.estado " +
                 "FROM t_producto p " +
                 "INNER JOIN t_categoria c ON p.id_categoria = c.id_categoria";

    try (Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        // Definir columnas de la tabla
        model.addColumn("N°");          // ID
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Descripción");
        model.addColumn("IVA");
        model.addColumn("Categoría");
        model.addColumn("Estado");

        // Llenar modelo con datos
        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getInt("id_producto");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getInt("cantidad");
            fila[3] = rs.getDouble("precio");
            fila[4] = rs.getString("descripcion");

            int porcentajeIva = rs.getInt("porcentaje_iva");
            fila[5] = porcentajeIva + "%"; // Mostrar porcentaje como texto

            fila[6] = rs.getString("categoria");
            fila[7] = rs.getInt("estado");

            model.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tabla_productos.setModel(model);
        jScrollPane1.setViewportView(tabla_productos);
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla productos: " + e);
    }

    // Listener para seleccionar fila
    tabla_productos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila_point = tabla_productos.rowAtPoint(e.getPoint());
            int columna_point = 0;
            if (fila_point > -1) {
                id_producto = (int) tabla_productos.getValueAt(fila_point, columna_point);
                EnviarDatosProductoSeleccionado(id_producto);
            }
        }
    });
}

    private double calcularIva(double precio, int iva) {
        int p_iva = iva;
        switch (p_iva) {
            case 0:
                IVA = 0.0;
                break;
            case 19:
                IVA = precio * 0.19;
                break;
          
            default:
                break;
        }
        //redondear decimales
        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;
    }

    private void EnviarDatosProductoSeleccionado(int id_producto) {
        try {
            Connecion conexion = new Connecion(); // Usa el tipo correcto
            Connection cn = conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from t_producto where id_producto = '" + id_producto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtnombre.setText(rs.getString("nombre"));
                txtcantidad.setText(rs.getString("cantidad"));
                txtprecio.setText(rs.getString("precio"));
                txtdesc.setText(rs.getString("descripcion"));
                int iva = rs.getInt("porcentaje_iva");
                switch (iva) {
                    case 0:
                        jComboBox1_iva.setSelectedItem("No grava iva");
                        break;
                    case 19:
                        jComboBox1_iva.setSelectedItem("19%");
                        break;

                    default:
                        jComboBox1_iva.setSelectedItem("Seleccione iva:");
                        break;
                }
                int idCate = rs.getInt("id_categoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

    private String relacionarCategoria(int id_categoria) {

        String sql = "select descripcion from t_categoria where id_categoria = '" + id_categoria + "'";
        Statement st;
        try {
            Connecion conexion = new Connecion(); // Usa el tipo correcto
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id de la categoria!");
        }
        return descripcionCategoria;
    }

    private int id_categoria() {
        String sql = "select * from t_categoria where descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connecion conexion = new Connecion(); // Usa el tipo correcto
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obteneridcategoriacombo = rs.getInt("id_categoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id categoria");
        }
        return obteneridcategoriacombo;
    }
}
