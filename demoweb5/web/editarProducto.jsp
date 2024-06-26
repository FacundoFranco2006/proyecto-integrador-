<%-- 
    Document   : editarProducto
    Created on : Jun 24, 2024, 12:24:49 PM
    Author     : mecha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Producto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Editar Producto</h2>
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="codigo" value="<c:out value="${producto.codigo}"></c:out>">
        <div class="form-group">
            <label for="marca">Marca</label>
            <input type="text" class="form-control" id="marca" name="marca" value="<c:out value="${producto.marca}"></c:out>" required>
        </div>
        <div class="form-group">
            <label for="producto">Producto</label>
            <input type="text" class="form-control" id="producto" name="producto" value="<c:out value="${producto.product}"></c:out>" required>
        </div>
        <div class="form-group">
            <label for="precio">Precio</label>
            <input type="number" step="0.01" class="form-control" id="precio" name="precio" value="<c:out value="${producto.precio}"></c:out>" required>
        </div>
        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" id="stock" name="stock" value="<c:out value="${producto.stock}"></c:out>" required>
        </div>
        <div class="form-group">
            <label for="vendidos">Vendidos</label>
            <input type="number" class="form-control" id="vendidos" name="vendidos" value="<c:out value="${producto.vendidos}"></c:out>" required>
        </div>
        <button type="submit" class="btn btn-primary">Editar</button>
    </form>
</div>
</body>
</html>