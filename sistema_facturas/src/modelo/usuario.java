package modelo;

/**
 *
 * @author YAMID
 */
public class usuario {

    public usuario(int id_usuario, String nombre, String apellido, String usuario, String contraseña, String telefono, int estado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.estado = estado;
    }

    public usuario() {
        
    }

 

    public int getId_usuario() {
        return  this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private String telefono;
    private int estado;

    @Override
    public String toString() {
        return "usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", estado=" + estado + '}';
    }

  
}
