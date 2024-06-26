/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.Producto;
import java.util.List;

/**
 *
 * @author mecha
 */
public interface ProductoDAO {
    
    int save (Producto producto);
    
    int update (Producto producto);
    
    int delete (Producto producto);
    
    List<Producto> getAll();
    
    Producto getById (int codigo);

    public void delete(int codigo);
}
