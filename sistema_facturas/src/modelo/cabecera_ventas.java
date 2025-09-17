package modelo;

import java.sql.Date;

public class cabecera_ventas {

    private int id_cabecera;
    private int id_cliente;
    private double valor_pagar;
    private Date fecha_venta; // Usamos java.sql.Date
    private int estado;

    // Constructor completo
    public cabecera_ventas(int id_cabecera, int id_cliente, double valor_pagar, Date fecha_venta, int estado) {
        this.id_cabecera = id_cabecera;
        this.id_cliente = id_cliente;
        this.valor_pagar = valor_pagar;
        this.fecha_venta = fecha_venta;
        this.estado = estado;
    }

    // Constructor vacío
    public cabecera_ventas() {
    }

    // Getters y Setters
    public int getId_cabecera() {
        return id_cabecera;
    }

    public void setId_cabecera(int id_cabecera) {
        this.id_cabecera = id_cabecera;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int idcliente) {
        this.id_cliente = idcliente;
    }

    public double getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(double valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "cabecera_ventas{" + "id_cabecera=" + id_cabecera + ", idcliente=" + id_cliente + ", valor_pagar=" + valor_pagar + ", fecha_venta=" + fecha_venta + ", estado=" + estado + '}';
    }
    
}
