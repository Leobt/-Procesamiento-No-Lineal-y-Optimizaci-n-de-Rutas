package ec.edu.puce;

import ec.edu.puce.modelo.Categoria;
import ec.edu.puce.modelo.Producto;

public class Main { 

    public static void main(String[] args) {

        // Crear categorias
        Categoria tienda = new Categoria("Tienda");

        Categoria tecnologia = new Categoria("Tecnologia");
        Categoria ropa = new Categoria("Ropa");

        Categoria computadoras = new Categoria("Computadoras");
        Categoria celulares = new Categoria("Celulares");

        // Crear productos
        Producto laptop = new Producto("Laptop", 800);
        Producto mouse = new Producto("Mouse", 20);
        Producto celular = new Producto("Samsung", 500);
        Producto camiseta = new Producto("Camiseta", 25);

        // Agregar productos a las categorias
        computadoras.addProducto(laptop);
        computadoras.addProducto(mouse);

        celulares.addProducto(celular);

        ropa.addProducto(camiseta);

        // Crear las subcategorias
        tecnologia.addSubCategoria(computadoras);
        tecnologia.addSubCategoria(celulares);

        tienda.addSubCategoria(tecnologia);
        tienda.addSubCategoria(ropa);

        // Mostrar categorias
        IO.println("CATEGORIAS:");
        tienda.showSubCategorias("");

        // Buscar producto
        IO.println("");
        IO.println("Ingrese el nombre del producto:");

        String nombreProducto = IO.readln();

        Producto productoEncontrado =
                tienda.searchProducto(nombreProducto);

        if (productoEncontrado != null) {

            IO.println("");
            IO.println("Producto encontrado:");
            IO.println(productoEncontrado);

        } else {

            IO.println("");
            IO.println("Producto no encontrado.");
        }
    }
}