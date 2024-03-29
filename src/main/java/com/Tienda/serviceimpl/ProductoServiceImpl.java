package com.Tienda.serviceimpl;

import com.Tienda.dao.ProductoDao;
import com.Tienda.domain.Producto;
import com.Tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//SE HACE EN EL EXÁMEN SI O SI
@Service
public class ProductoServiceImpl implements ProductoService {

    //Permtie que cree una ariable de un bojeto, y si no existe este l ocrea
    @Autowired//Dao
    private ProductoDao productoDao;

    //Se debe hacer para traer os métodos que se encuentren en el implements
    @Override
    @Transactional(readOnly = true)//Springframework  //readOnly:
    public List<Producto> getProductos(boolean activos) {
        //Esto es un objeto
        List<Producto> lista = productoDao.findAll();//trae TODOS los registros de categoría

        if (activos) {
            //Para remover las categorías donde activo = false     
            lista.removeIf(x -> !x.isActivo());//lista se remueve si:primero se pone un alias, en este caso x           

        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }
    

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }

}
