public class Producto {
    private String nombre;
    private int cantidad;
    private int precio;
    private int total;

    public Producto() {
    }

    public Producto(String nombre, int cantidad, int precio, int total) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal(){
        return  total;
    }
    public void setTotal(int total){
        this.total = total;
    }
}
