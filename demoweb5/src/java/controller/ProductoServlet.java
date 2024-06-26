/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import util.DBConnection;
import model.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import java.util.ArrayList;

/**
 *
 * @author mecha
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    ProductoDAO productoDao = new ProductoDAOImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
    if (action != null) {
        switch (action) {
            case "nuevo":
                request.setAttribute("producto", new Producto());
                request.getRequestDispatcher("nuevoProducto.jsp").forward(request, response);
                break;
            case "editar":
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Producto producto = productoDao.getById(codigo);
                request.setAttribute("producto", producto);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
                break;
            case "eliminar":
                int codigoEliminar = Integer.parseInt(request.getParameter("codigo"));
                productoDao.delete(codigoEliminar);
                listarProductos(request, response);
                break;
            default:
                listarProductos(request, response);
                break;
        }
    } else {
        listarProductos(request, response);
    }
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto = null;
    String codigo = request.getParameter("codigo");
    String marca = request.getParameter("marca");
    String product = request.getParameter("producto");
    double precio = Double.parseDouble(request.getParameter("precio"));
    int stock = Integer.parseInt(request.getParameter("stock"));
    int vendidos = Integer.parseInt(request.getParameter("vendidos"));

    if (codigo == null || codigo.isEmpty()) {
        producto = new Producto();
        producto.setMarca(marca);
        producto.setProduct(product);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setVendidos(vendidos);
        productoDao.save(producto);
    } else {
        producto = new Producto();
        producto.setCodigo(Integer.parseInt(codigo));
        producto.setMarca(marca);
        producto.setProduct(product);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setVendidos(vendidos);
        productoDao.update(producto);
    }
    listarProductos(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> listaProductos = productoDao.getAll();
    request.setAttribute("listaProductos", listaProductos);
    request.getRequestDispatcher("productos.jsp").forward(request, response);
}
    

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("nuevoProducto.jsp");
    }

    private void editarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto;
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        producto = productoDao.getById(codigo);
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        productoDao.delete(codigo);
        listarProductos(request, response);
    }

}
