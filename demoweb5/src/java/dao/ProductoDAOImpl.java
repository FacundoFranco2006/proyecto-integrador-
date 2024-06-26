/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Producto;
import util.DBConnection;

public class ProductoDAOImpl implements ProductoDAO {
    private String sql = "";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int save(Producto producto) {
        int row = 0;
        sql = "INSERT INTO productos (codigo, marca, producto, precio, stock, vendidos) VALUES (?, ?, ?, ?, ?, ?)";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getMarca());
            preparedStatement.setString(3, producto.getProduct());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getStock());
            preparedStatement.setInt(6, producto.getVendidos());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int update(Producto producto) {
        int row = 0;
        sql = "UPDATE productos SET marca = ?, producto = ?, precio = ?, stock = ?, vendidos = ? WHERE codigo = ?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getMarca());
            preparedStatement.setString(2, producto.getProduct());
            preparedStatement.setDouble(3, producto.getPrecio());
            preparedStatement.setInt(4, producto.getStock());
            preparedStatement.setInt(5, producto.getVendidos());
            preparedStatement.setInt(6, producto.getCodigo());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(Producto producto) {
        int row = 0;
        sql = "DELETE FROM productos WHERE codigo = ?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, producto.getCodigo());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Producto> getAll() {
        List<Producto> list = new ArrayList<>();
        sql = "SELECT * FROM productos";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setProduct(resultSet.getString("producto"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setVendidos(resultSet.getInt("vendidos"));
                list.add(producto);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Producto getById(int codigo) {
        Producto producto = null;
        sql = "SELECT * FROM productos WHERE codigo = ?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setProduct(resultSet.getString("producto"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setVendidos(resultSet.getInt("vendidos"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
    }

    @Override
    public void delete(int codigo) {
        sql = "DELETE FROM productos WHERE codigo = ?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
