package ec.edu.puce.modelo;

import java.util.ArrayList;
import java.util.List;
 
public class Categoria {

    private String nombre;
    private List<Categoria> subCategorias;
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.subCategorias = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public void addSubCategoria(Categoria subCategoria) {
        this.subCategorias.add(subCategoria);
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void showSubCategorias(String prefijo) {
        IO.println(prefijo + "-- " + nombre);

        for (Categoria categoria : this.subCategorias) {
            categoria.showSubCategorias(prefijo + "|   ");
        }
    }

    public Categoria searchSubCategoria(String nombreCategoriaBuscada) {

        if (nombreCategoriaBuscada.equals(this.nombre)) {
            return this;
        }

        for (Categoria subCategoria : this.subCategorias) {

            Categoria categoria =
                    subCategoria.searchSubCategoria(nombreCategoriaBuscada);

            if (categoria != null) {
                return categoria;
            }
        }

        return null;
    }

    public Producto searchProducto(String nombreProductoBuscado) {

        for (Producto producto : this.productos) {

            if (producto.getNombre().equalsIgnoreCase(nombreProductoBuscado)) {
                return producto;
            }
        }

        for (Categoria subCategoria : this.subCategorias) {

            Producto producto =
                    subCategoria.searchProducto(nombreProductoBuscado);

            if (producto != null) {
                return producto;
            }
        }

        return null;
    }
}