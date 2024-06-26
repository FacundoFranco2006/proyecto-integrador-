<%-- 
    Document   : productos
    Created on : Jun 24, 2024, 12:23:48 PM
    Author     : mecha
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2>Stock de Productos</h2>
            <a href="ProductoServlet?action=nuevo" class="btn btn-success" method="post">Nuevo Producto</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Marca</th>
                        <th>Producto</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Vendidos</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="producto" items="${listaProductos}">
                    <tr>
                        <td><c:out value="${producto.codigo}"></c:out></td>
                        <td><c:out value="${producto.marca}"></c:out></td>
                        <td><c:out value="${producto.product}"></c:out></td>
                        <td><c:out value="${producto.precio}"></c:out></td>
                        <td><c:out value="${producto.stock}"></c:out></td>
                        <td><c:out value="${producto.vendidos}"></c:out></td>
                        <td>
                            <a href="ProductoServlet?action=editar&codigo=<c:out value="${producto.codigo}"></c:out>" class="btn btn-primary" >Editar</a>
                            <a href="ProductoServlet?action=eliminar&codigo=<c:out value="${producto.codigo}"></c:out>" class="btn btn-danger">Eliminar</a>
                        </td>
                        </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>