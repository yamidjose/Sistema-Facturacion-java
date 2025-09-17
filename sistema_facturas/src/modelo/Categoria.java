
package modelo;

/**
 *
 * @author YAMID
 */
public class Categoria {
    
      private int id_categoria;
    private String descripcion;
    private int estado;
    
    public Categoria() {
        this.id_categoria = 0;
        this.descripcion = "";
        this.estado = 0;
 
}
        public Categoria(int id_categoria, String descripcion, int estado) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.estado = estado;
 
}
   


    public int getIdcategoria() {
        return id_categoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.id_categoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

   


}
