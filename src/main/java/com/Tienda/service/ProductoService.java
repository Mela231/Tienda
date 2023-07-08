
package com.Tienda.service;
import com.Tienda.domain.Producto;
import java.util.List;
public interface ProductoService {
     //Metodo que retorna la lista de categorias
    public List<Producto> getProductos(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Producto producto);
}
