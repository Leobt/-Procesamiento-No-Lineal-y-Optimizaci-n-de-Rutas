package ec.edu.puce;

import ec.edu.puce.modelo.Categoria;
import ec.edu.puce.modelo.Producto;

public class Main { 

    public static void main(String[] args) {

        
        Categoria tienda = new Categoria("Tienda");

        Categoria tecnologia = new Categoria("Tecnologia");
        Categoria ropa = new Categoria("Ropa");

        Categoria computadoras = new Categoria("Computadoras");
        Categoria celulares = new Categoria("Celulares");

        Producto laptop = new Producto("Laptop", 800);
        Producto mouse = new Producto("Mouse", 20);
        Producto celular = new Producto("Samsung", 500);
        Producto camiseta = new Producto("Camiseta", 25);


        computadoras.addProducto(laptop);
        computadoras.addProducto(mouse);

        celulares.addProducto(celular);

        ropa.addProducto(camiseta);

        tecnologia.addSubCategoria(computadoras);
        tecnologia.addSubCategoria(celulares);

        tienda.addSubCategoria(tecnologia);
        tienda.addSubCategoria(ropa);

        IO.println("CATEGORIAS:");
        tienda.showSubCategorias("");

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