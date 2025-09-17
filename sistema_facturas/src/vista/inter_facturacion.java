
package vista;

import Coneccion.Connecion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.producto;
import modelo.cabecera_ventas;
import modelo.detalle_venta;
import controlador.Ctrl_RegistrarVenta;
import controlador.VentaPDF;

/**
 *
 * @author YAMID
 */

public class inter_facturacion extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<detalle_venta> listaProductos = new ArrayList<>();
    private detalle_venta producto;

    private int id_Cliente = 0;//id del cliente sleccionado

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private double porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int auxIdDetalle = 1;//id del detalle de venta

    public inter_facturacion() {

        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");

        //Cargar lo Clientes en la vista - cargar productos
        this.cararcomboclientes();
        this.cararcomboproductos();
        this.iniciartablaproductos();

        txtefectivo.setEnabled(false);
        btn_calcularcambio.setEnabled(false);

        txtsubtota.setText("0.0");
        txtiva.setText("0.0");
        txtdescuento.setText("0.0");
        txttotala_ppagar.setText("0.0");

    }

    private void iniciartablaproductos() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        this.tabla_productos.setModel(modeloDatosProductos);
    }

    private void listartablaproductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());

        for (int i = 0; i < listaProductos.size(); i++) {
            detalle_venta detalle = listaProductos.get(i);
            producto prod = detalle.getProducto(); // Debe haberse asignado antes

            if (prod != null) {
                this.modeloDatosProductos.setValueAt(i + 1, i, 0); // nº
                this.modeloDatosProductos.setValueAt(prod.getNombre(), i, 1); // Nombre del producto
                this.modeloDatosProductos.setValueAt(detalle.getCantidad(), i, 2); // Cantidad
                this.modeloDatosProductos.setValueAt(detalle.getPrecio_unitario(), i, 3); // Precio unitario
                this.modeloDatosProductos.setValueAt(detalle.getSubtotal(), i, 4); // Subtotal
                this.modeloDatosProductos.setValueAt(detalle.getDescuento(), i, 5); // Descuento
                this.modeloDatosProductos.setValueAt(detalle.getIva(), i, 6); // IVA
                this.modeloDatosProductos.setValueAt(detalle.getTotal_pagar(), i, 7); // Total a pagar
                this.modeloDatosProductos.setValueAt("Eliminar", i, 8); // Acción
            } else {
                System.err.println("⚠ Error: producto es null en detalle_venta index " + i);
            }
        }
        tabla_productos.setModel(modeloDatosProductos);
        this.cararcomboproductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new vista.PanelDegradado()
        ;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_seleccionecliente = new javax.swing.JComboBox<>();
        jComboBox_seleccioneproducto = new javax.swing.JComboBox<>();
        btn_añadir = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_buscar1 = new javax.swing.JTextField();
        jPanel2 = new vista.PanelDegradado();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttotala_ppagar = new javax.swing.JTextField();
        txtsubtota = new javax.swing.JTextField();
        txtcambio = new javax.swing.JTextField();
        txtiva = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        txtefectivo = new javax.swing.JTextField();
        jPanel3 = new vista.PanelDegradado();
        btnregistrarventa = new javax.swing.JButton();
        btn_calcularcambio = new javax.swing.JButton();
        jPanel4 = new vista.PanelDegradado();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        txt_cantidad = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Facturacion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        jComboBox_seleccionecliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione un cliente", "Item 2", "Item 3", "Item 4" }));
        jComboBox_seleccionecliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(16, 56, 73)));
        jComboBox_seleccionecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_seleccioneclienteActionPerformed(evt);
            }
        });

        jComboBox_seleccioneproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione producto", "Item 2", "Item 3", "Item 4" }));
        jComboBox_seleccioneproducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(16, 50, 71)));
        jComboBox_seleccioneproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_seleccioneproductoActionPerformed(evt);
            }
        });

        btn_añadir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito-de-compra-anadir.png"))); // NOI18N
        btn_añadir.setText("Añadir productos");
        btn_añadir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(13, 40, 54)));
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cabeza-de-conocimiento.png"))); // NOI18N
        btn_buscar.setText("Buscar cliente");
        btn_buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(14, 50, 69)));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 0), java.awt.Color.black));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Subtota:l");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("IVA:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Efectivo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total a Pagar");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsubtota, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotala_ppagar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsubtota, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotala_ppagar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.black, new java.awt.Color(0, 0, 0)));

        btnregistrarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/papel-de-registro.png"))); // NOI18N
        btnregistrarventa.setText("Registrar venta");
        btnregistrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarventaActionPerformed(evt);
            }
        });

        btn_calcularcambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deuda.png"))); // NOI18N
        btn_calcularcambio.setText("calcular cambio");
        btn_calcularcambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularcambioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnregistrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcularcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_calcularcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregistrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.black, null));

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
        tabla_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_productos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_seleccionecliente, 0, 153, Short.MAX_VALUE)
                                    .addComponent(jComboBox_seleccioneproducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(106, 106, 106)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox_seleccionecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_seleccioneproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(btn_añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_seleccioneproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_seleccioneproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_seleccioneproductoActionPerformed

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
       

        String combo = this.jComboBox_seleccioneproducto.getSelectedItem().toString();

        // Validar que se haya seleccionado un producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            return;
        }

        // Validar que se haya ingresado una cantidad
        if (txt_cantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            return;
        }

        // Validar que la cantidad sea numérica
        if (!validar(txt_cantidad.getText())) {
            JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numéricos");
            return;
        }

        // Validar que la cantidad sea mayor que cero
        cantidad = Integer.parseInt(txt_cantidad.getText());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), ni negativa");
            return;
        }

        // Obtener datos del producto seleccionado desde la base de datos
        if (!datosdelproducto()) {
            JOptionPane.showMessageDialog(null, "No se encontró el producto en la base de datos");
            return;
        }

        // Validar que la cantidad no supere el stock
        if (cantidad > cantidadProductoBBDD) {
            JOptionPane.showMessageDialog(null, "La cantidad supera el stock disponible");
            return;
        }

        // Calcular valores
        subtotal = precioUnitario * cantidad;
        this.calculariva(precioUnitario, (int) porcentajeIva); // Asigna el valor de iva
        totalPagar = subtotal + iva - descuento;

        // Redondear valores
        subtotal = Math.round(subtotal * 100.0) / 100.0;
        iva = Math.round(iva * 100.0) / 100.0;
        descuento = Math.round(descuento * 100.0) / 100.0;
        totalPagar = Math.round(totalPagar * 100.0) / 100.0;

        // Crear objeto producto para asociarlo al detalle
        producto p = new producto();
        p.setId_producto(idProducto);
        p.setNombre(nombre);
        p.setPrecio(precioUnitario);
        p.setCantidad(cantidadProductoBBDD); // stock
        p.setPorcentaje_iva(porcentajeIva);

        // Crear objeto detalle_venta
        detalle_venta detalle = new detalle_venta(
                auxIdDetalle,
                1, // id_cabecera temporal
                idProducto,
                cantidad,
                precioUnitario,
                subtotal,
                descuento,
                iva,
                totalPagar,
                1
        );
        detalle.setProducto(p); // Asociar producto

        // Agregar a la lista
        listaProductos.add(detalle);

        // Confirmar
        JOptionPane.showMessageDialog(null, "Producto agregado correctamente");

        // Limpiar campos y actualizar interfaz
        auxIdDetalle++;
        txt_cantidad.setText("");
        this.cararcomboproductos();
        this.CalcularTotalPagar();
        txtefectivo.setEnabled(true);
        btn_calcularcambio.setEnabled(true);

        // Actualizar tabla
        this.listartablaproductos();
    


    }//GEN-LAST:event_btn_añadirActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String clienteBuscar = txt_buscar1.getText().trim();
        Connecion conexion = new Connecion();
        Connection cn = conexion.getConnection();
        String sql = "select nombre, apellido from t_cliente where cedula = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBox_seleccionecliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_seleccionecliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Cedula de cliente incorrecta o no encontrada!");
            }
            txt_buscar1.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_calcularcambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularcambioActionPerformed
        if (!txtefectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos 
            boolean validacion = validar(txtefectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txtefectivo.getText().trim());
                double top = Double.parseDouble(txttotala_ppagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txtcambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }    }//GEN-LAST:event_btn_calcularcambioActionPerformed
    int idArrayList = 0;
    private void tabla_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productosMouseClicked
        int fila_point = tabla_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confir dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listartablaproductos();
                break;
            case 1: //presione no
                break;
            default://sea que presione cancel (2) o close (-1)
                break;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_productosMouseClicked

    private void btnregistrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarventaActionPerformed
        cabecera_ventas cabeceraVenta = new cabecera_ventas();
        detalle_venta detalleVenta = new detalle_venta();
        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();

        java.util.Date utilDate = new java.util.Date(); // Fecha actual
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Convertir

        if (!jComboBox_seleccionecliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {

                //metodo para obtener el id del cliente
                this.ObtenerIdCliente();
                //registrar cabecera
                cabeceraVenta.setId_cabecera(0);
                cabeceraVenta.setId_cliente(id_Cliente);
                cabeceraVenta.setValor_pagar(Double.parseDouble(txttotala_ppagar.getText()));
                cabeceraVenta.setFecha_venta(sqlDate);
                cabeceraVenta.setEstado(1);

                if (controlVenta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "¡Venta Registrada!");
                    
                    //llamar la factura
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosCliente(id_Cliente);
                    pdf.generarFacturaPDF();

                    //guardar detalle
                    for (detalle_venta elemento : listaProductos) {
                        detalleVenta.setId_detalle_venta(0);
                        detalleVenta.setId_cabecera_venta(0);
                        detalleVenta.setId_producto(elemento.getId_producto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecio_unitario(elemento.getPrecio_unitario());
                        detalleVenta.setSubtotal(elemento.getSubtotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIva(elemento.getIva());
                        detalleVenta.setTotal_pagar(elemento.getTotal_pagar());
                        detalleVenta.setEstado(1);

                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            //System.out.println("Detalle de Venta Registrado");

                            txtsubtota.setText("0.0");
                            txtiva.setText("0.0");
                            txtdescuento.setText("0.0");
                            txttotala_ppagar.setText("0.0");
                            txtefectivo.setText("");
                            txtcambio.setText("0.0");
                            auxIdDetalle = 1;

                            this.cararcomboclientes();
                            this.RestarStockProductos(elemento.getId_producto(), elemento.getCantidad());

                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                        }
                    }
                    //vaciamos la lista
                    listaProductos.clear();
                    listartablaproductos();

                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        }

    }//GEN-LAST:event_btnregistrarventaActionPerformed

    private void jComboBox_seleccioneclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_seleccioneclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_seleccioneclienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_calcularcambio;
    private javax.swing.JButton btnregistrarventa;
    private javax.swing.JComboBox<String> jComboBox_seleccionecliente;
    private javax.swing.JComboBox<String> jComboBox_seleccioneproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public transient javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txt_buscar1;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txtcambio;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtefectivo;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtsubtota;
    public static javax.swing.JTextField txttotala_ppagar;
    // End of variables declaration//GEN-END:variables
private void cararcomboclientes() {
        Connecion conexion = new Connecion(); // Usa la clase de conexión correctamente
        Connection cn = conexion.getConnection();
        String sql = "select * from t_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccionecliente.removeAllItems();
            jComboBox_seleccionecliente.addItem("seleccione un cliente");
            while (rs.next()) {
                jComboBox_seleccionecliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();

        } catch (Exception e) {
            System.out.println("error al cargar clientes '" + e + "'");
        }
    }

    private void cararcomboproductos() {
        Connecion conexion = new Connecion(); // Usa la clase de conexión correctamente
        Connection cn = conexion.getConnection();
        String sql = "select * from t_producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccioneproducto.removeAllItems();
            jComboBox_seleccioneproducto.addItem("seleccione producto");
            while (rs.next()) {
                jComboBox_seleccioneproducto.addItem(rs.getString("nombre"));
            }
            cn.close();

        } catch (Exception e) {
            System.out.println("error al cargar productos'" + e + "'");
        }
    }

    public boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

 public boolean datosdelproducto() {
    boolean encontrado = false;

    try {
        String nombreProducto = jComboBox_seleccioneproducto.getSelectedItem().toString();

        // Validar que no sea la opción por defecto
        if (nombreProducto.equalsIgnoreCase("Seleccione producto:")) {
            return false;
        }

        String sql = "SELECT * FROM t_producto WHERE nombre = ?";
        Connecion conexion = new Connecion(); // Asegúrate que esté bien implementada
        Connection cn = conexion.getConnection();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombreProducto);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            encontrado = true;
            idProducto = rs.getInt("id_producto");
            nombre = rs.getString("nombre");
            cantidadProductoBBDD = rs.getInt("cantidad");
            precioUnitario = rs.getDouble("precio");
            porcentajeIva = rs.getDouble("porcentaje_iva");

            // Calcular IVA
            this.calculariva(precioUnitario, (int) porcentajeIva);
        } else {
            System.out.println("Producto no encontrado en la base de datos con nombre: " + nombreProducto);
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (Exception e) {
        System.out.println("Error al obtener datos del producto: " + e.getMessage());
        e.printStackTrace();
    }

    return encontrado;
}



    private double calculariva(double precio, int porcentajeiva) {
        int p_iva = porcentajeiva;
        switch (p_iva) {
            case 0:
                iva = 0.0;
                break;
            case 19:
                iva = (precio * cantidad) * 0.19;
                break;
            default:
                throw new AssertionError();
        }
        return iva;
    }

    private void CalcularTotalPagar() {
        detalle_venta detalle = new detalle_venta();

        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (detalle_venta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubtotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotal_pagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txtsubtota.setText(String.valueOf(subtotalGeneral));
        txtiva.setText(String.valueOf(ivaGeneral));
        txtdescuento.setText(String.valueOf(descuentoGeneral));
        txttotala_ppagar.setText(String.valueOf(totalPagarGeneral));
    }

    /*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from t_cliente where concat(nombre,' ',apellido) = '" + this.jComboBox_seleccionecliente.getSelectedItem() + "'";
            Connecion conexion = new Connecion();
            Connection cn = conexion.getConnection();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id_Cliente = rs.getInt("id_cliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }

    //metodo para restar la cantidad (stock) de los productos vendidos
    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connecion conexion = new Connecion();
            Connection cn = conexion.getConnection();
            String sql = "select id_producto, cantidad from t_producto where id_producto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            Connecion conexion = new Connecion();
            Connection cn = conexion.getConnection();
            PreparedStatement consulta = cn.prepareStatement("update t_producto set cantidad=? where id_producto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if (consulta.executeUpdate() > 0) {
                //System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }

    }
}
