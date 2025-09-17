package modelo;

public class detalle_venta {
    private int id_detalle_venta;
    private int id_cabecera_venta;
    private int id_producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;
    private double descuento;
    private double iva;
    private double total_pagar;
    private int estado;

    private producto producto; // Objeto completo del producto

    // Constructor vacío requerido para instanciación sin datos
    public detalle_venta() {}

    // Constructor completo
    public detalle_venta(int id_detalle_venta, int id_cabecera_venta, int id_producto,
                         int cantidad, double precio_unitario, double subtotal,
                         double descuento, double iva, double total_pagar, int estado) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_cabecera_venta = id_cabecera_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.total_pagar = total_pagar;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(int id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    // Relación con la clase producto
    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "detalle_venta{" + "id_detalle_venta=" + id_detalle_venta + ", id_cabecera_venta=" + id_cabecera_venta + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", subtotal=" + subtotal + ", descuento=" + descuento + ", iva=" + iva + ", total_pagar=" + total_pagar + ", estado=" + estado + ", producto=" + producto + '}';
    }
    
}
       