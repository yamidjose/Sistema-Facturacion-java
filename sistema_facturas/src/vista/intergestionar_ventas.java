package vista;

import Coneccion.Connecion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.cabecera_ventas;
import controlador.Ctrl_RegistrarVenta;

public class intergestionar_ventas extends javax.swing.JInternalFrame {

    private int id_cliente = 0;
    private int id_venta;

    public intergestionar_ventas() {
        initComponents();
        this.setSize(900, 500);
        this.setTitle("Gestionar ventas");
        this.CargarTablaventas();
        this.cargarcomboclientes();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new vista.PanelDegradado();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        jPanel3 = new vista.PanelDegradado();
        jLabel1 = new javax.swing.JLabel();
        txt_totalpagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        btnact = new javax.swing.JButton();
        jComboBox_seleccioneestado = new javax.swing.JComboBox<>();
        jComboBox_seleccionecliente1 = new javax.swing.JComboBox<>();
        jPanel4 = new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Administrar Ventas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 870, 270));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total pagar");

        txt_totalpagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalpagarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("estado");

        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });

        btnact.setBackground(new java.awt.Color(204, 204, 204));
        btnact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnact.setForeground(new java.awt.Color(0, 0, 0));
        btnact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/documento (1).png"))); // NOI18N
        btnact.setText("actualizar");
        btnact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactActionPerformed(evt);
            }
        });

        jComboBox_seleccioneestado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_seleccioneestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo", " " }));
        jComboBox_seleccioneestado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(16, 56, 73)));

        jComboBox_seleccionecliente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_seleccionecliente1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione un cliente", "Item 2", "Item 3", "Item 4" }));
        jComboBox_seleccionecliente1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(16, 56, 73)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_totalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_seleccionecliente1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_seleccioneestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(141, 141, 141)
                .addComponent(btnact)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_seleccionecliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_seleccioneestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnact)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 870, 100));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactActionPerformed
        cabecera_ventas cabeceraVenta = new cabecera_ventas();
        Ctrl_RegistrarVenta controlRegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente, estado;

        cliente = jComboBox_seleccionecliente1.getSelectedItem().toString().trim();
        estado = jComboBox_seleccionecliente1.getSelectedItem().toString().trim();

// Obtener el id del cliente
        try {
            Connecion conexion = new Connecion();
            Connection cn = conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT id_cliente, CONCAT(nombre, ' ', apellido) AS cliente "
                    + "FROM t_cliente WHERE CONCAT(nombre, ' ', apellido) = '" + cliente + "'"
            );

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en cargar el id cliente: " + e);
        }
        // Actualizar datos
        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            cabeceraVenta.setId_cliente(id_cliente);

            if (estado.equalsIgnoreCase("Activo")) {
                cabeceraVenta.setEstado(1);
            } else {
                cabeceraVenta.setEstado(0);
            }

            if (controlRegistrarVenta.actualizar(cabeceraVenta, id_venta)) {
                JOptionPane.showMessageDialog(null, "¡Registro Actualizado!");
                this.CargarTablaventas();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar datos");
        }


    }//GEN-LAST:event_btnactActionPerformed

    private void txt_totalpagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalpagarActionPerformed


    }//GEN-LAST:event_txt_totalpagarActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnact;
    private javax.swing.JComboBox<String> jComboBox_seleccionecliente1;
    private javax.swing.JComboBox<String> jComboBox_seleccioneestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla_ventas;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_totalpagar;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        this.txt_totalpagar.setText("");
        this.txt_fecha.setText("");
        this.jComboBox_seleccioneestado.setSelectedItem("seleccione un cliente");
        this.jComboBox_seleccioneestado.setSelectedItem("activo");
    }

    private void CargarTablaventas() {
        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT cv.id_cabecera AS id, "
                + "CONCAT(c.nombre, ' ', c.apellido) AS cliente, "
                + "cv.valor_pagar AS total_pagar, "
                + "cv.fecha_venta AS fecha_venta, "
                + "CASE WHEN cv.estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS estado "
                + "FROM t_cabecera AS cv "
                + " JOIN t_cliente AS c ON cv.id_cliente = c.id_cliente";

        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            model.addColumn("N°");
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("Estado");

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("cliente");
                fila[2] = rs.getDouble("total_pagar");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("estado");

                model.addRow(fila);
            }

            tabla_ventas.setModel(model);
            jScrollPane1.setViewportView(tabla_ventas);

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla ventas: " + e.getMessage());
        }

        // Listener para seleccionar fila y cargar datos
        tabla_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_point > -1) {
                    id_venta = (int) tabla_ventas.getValueAt(fila_point, columna_point);
                    EnviarDatosventasSeleccionado(id_venta);
                }
            }
        });
    }

    private void EnviarDatosventasSeleccionado(int id_venta) {
        try {
            Connecion conexion = new Connecion(); // Usa el tipo correcto
            Connection cn = conexion.getConnection();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cv.id_cabecera, cv.id_cliente, CONCAT(c.nombre,' ', c.apellido) AS cliente, "
                    + "cv.valor_pagar, cv.fecha_venta, cv.estado "
                    + "FROM t_cabecera AS cv JOIN t_cliente AS c ON cv.id_cliente = c.id_cliente "
                    + "WHERE cv.id_cabecera = ?;"
            );
            pst.setInt(1, id_venta); // ← FALTABA ESTA LÍNEA

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jComboBox_seleccionecliente1.setSelectedItem(rs.getString("cliente"));
                txt_totalpagar.setText(rs.getString("valor_pagar"));
                txt_fecha.setText(rs.getString("fecha_venta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    jComboBox_seleccioneestado.setSelectedItem("activo");
                } else {
                    jComboBox_seleccioneestado.setSelectedItem("inactivo");
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente: " + e);
        }
    }

    private void cargarcomboclientes() {
        Connecion conexion = new Connecion(); // Usa la clase de conexión correctamente
        Connection cn = conexion.getConnection();
        String sql = "select * from t_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccionecliente1.removeAllItems();
            jComboBox_seleccionecliente1.addItem("seleccione un cliente");
            while (rs.next()) {
                jComboBox_seleccionecliente1.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();

        } catch (Exception e) {
            System.out.println("error al cargar clientes '" + e + "'");
        }
    }

}
