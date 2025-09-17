package vista;

import Coneccion.Connecion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.ctrl_categoria;
import modelo.Categoria;

public class intergestionar_categorias extends javax.swing.JInternalFrame {

    private int id_categoria;

    public intergestionar_categorias() {
        initComponents();
        this.setSize(600, 400);
        this.setTitle("Gestionar Categorias");
        this.cargartablacategoria();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new vista.PanelDegradado();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_categoria = new javax.swing.JTable();
        jPanel2 = new vista.PanelDegradado();
        btnact = new javax.swing.JButton();
        btnelim = new javax.swing.JButton();
        jPanel3 = new vista.PanelDegradado();
        jLabel1 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JTextField();
        jPanel4 =  new vista.PanelDegradado();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Administrar categorias");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_categoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_categoria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 130, 80));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("nuevo nombre");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        txtdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescActionPerformed(evt);
            }
        });
        jPanel3.add(txtdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 190, 80));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactActionPerformed
      if (!txtdesc.getText().isEmpty()) {
    Categoria Categoria = new Categoria();
    ctrl_categoria controlCategoria = new ctrl_categoria();

    Categoria.setDescripcion(txtdesc.getText().trim());
    if (controlCategoria.actualizar(Categoria, id_categoria)) {
        JOptionPane.showMessageDialog(null, "Categoría actualizada");
        txtdesc.setText("");
        this.cargartablacategoria();
    } else {
        JOptionPane.showMessageDialog(null, "Error al actualizar categoría");
    }
} else {
    JOptionPane.showMessageDialog(null, "Seleccione una categoría");
}

    }//GEN-LAST:event_btnactActionPerformed

    private void txtdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescActionPerformed


    }//GEN-LAST:event_txtdescActionPerformed

    private void btnelimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimActionPerformed
               if (!btnelim.getText().isEmpty()) {
    Categoria Categoria = new Categoria();
    ctrl_categoria controlCategoria = new ctrl_categoria();

    Categoria.setDescripcion(btnelim.getText().trim());
    if (controlCategoria.eliminar( id_categoria)) {
        JOptionPane.showMessageDialog(null, "Categoría eliminada");
        btnelim.setText("Eliminar");
        this.cargartablacategoria();
    } else {
        JOptionPane.showMessageDialog(null, "Error al eliminar categoría");
    }
} else {
    JOptionPane.showMessageDialog(null, "Seleccione una categoría");
}   
    }//GEN-LAST:event_btnelimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnact;
    private javax.swing.JButton btnelim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla_categoria;
    private javax.swing.JTextField txtdesc;
    // End of variables declaration//GEN-END:variables
private void cargartablacategoria() {
        Connecion cn = new Connecion();
        Connection conn = cn.getConnection();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id_categoria");
        model.addColumn("descripcion");
        model.addColumn("estado");

        String sql = "SELECT id_categoria , descripcion, estado FROM T_categoria";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_categoria");
                fila[1] = rs.getString("descripcion");
                fila[2] = rs.getInt("estado"); // O convertir a texto: (rs.getInt("estado") == 1 ? "Activo" : "Inactivo")
                model.addRow(fila);
            }

            tabla_categoria.setModel(model);  // ← Usas la tabla existente del formulario

        } catch (Exception e) {
            System.out.println("No se pudo llenar la tabla categorías: " + e.getMessage());
        }
            tabla_categoria.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int fila_point = tabla_categoria.rowAtPoint(e.getPoint());
                    int columna_point = 0;
                    if (fila_point > -1) {
                        id_categoria = (int) model.getValueAt(fila_point, columna_point);
                        enviardatos_cateegoriaseleccionada(id_categoria);
                    }

                }
            });
        
}
    private void enviardatos_cateegoriaseleccionada(int id_categoria) {

        try {

            Connecion cn = new Connecion();
            Connection conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                    "SELECT * FROM t_categoria WHERE id_categoria = '" + id_categoria + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtdesc.setText(rs.getString("descripcion"));
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al seleccionar categoria: " + e);
        }

    }
  
}
