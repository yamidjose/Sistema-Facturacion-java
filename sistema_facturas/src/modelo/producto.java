package modelo;

public class producto {
    private int id_producto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private double porcentaje_iva;
    private int id_categoria;
    private int estado;

    public producto() {
        this.id_producto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.porcentaje_iva = 0;
        this.id_categoria = 0;
        this.estado = 0;
    }
    

    public producto(int id_producto, String nombre, int cantidad, double precio,
                    String descripcion, double porcentaje_iva, int id_categoria, int estado) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentaje_iva = porcentaje_iva;
        this.id_categoria = id_categoria;
        this.estado = estado;
    }

 

    // Getters y setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje_iva() {
        return porcentaje_iva;
    }

    public void setPorcentaje_iva(double porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", descripcion=" + descripcion + ", porcentaje_iva=" + porcentaje_iva + ", id_categoria=" + id_categoria + ", estado=" + estado + '}';
    }
}
