<%-- 
    Document   : index
    Created on : 20/09/2021, 20:37:15
    Author     : 50254
--%>
<%@page import ="modelo.Producto"%>
<%@page import="modelo.Marca"  %>
<%@page import ="java.util.HashMap"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCTOS</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
        <h1>FORMULARIO PRODUCTOS</h1>
        <div class="container">
          <form action="sr_producto" metod="POST" class="form-group">
         <label for="lbl_producto"> Producto: </label>
           <input type="text" name="txt_producto" id="txt producto " class="form-control" placeholder="Ejemplo: Cereal" required>
          <label for="lbl_idMarca"> Id Marca: </label>
           <select name="txt_marca" id="drop_marca" class="form-control">
               <%
                  Producto producto = new Producto();
                  HashMap <String,String> drop = producto.drop_marca();
                    for (String i: drop.keySet()){
                        out.println("<option value='" + i + "'>"+drop.get(i)+"</option>");
                    }
                   %>
           </select>
           <label for="lbl_Descripcion"> Descripcion: </label>
           <input type="text" name="txt_Descripcion" id="txt producto " class="form-control" placeholder="Ejemplo: Caja de cereal Kelog´s" required>  
         <label for="lbl_PrecioCosto"> Precio Costo: </label>
           <input type="text" name="txt_preciocosto" id="txt producto " class="form-control" placeholder="Ejemplo: 31.00" required>  
         <label for="lbl_PrecioVenta"> Precio Venta: </label>
           <input type="text" name="txt_precioventa" id="txt producto " class="form-control" placeholder="Ejemplo: 39.00" required>  
         <label for="lbl_Existencia"> Existencia: </label>
           <input type="text" name="txt_existencia" id="txt producto " class="form-control" placeholder="Ejemplo: 500" required>  
           <br>
           <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">AGREGAR</button>
          
          
          
          
          </form>
           <table class="table table-striped">
    <thead>
      <tr>
        <th>Producto</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Precio Costo</th>
        <th>Precio Venta</th>
        <th>Existencia</th>
        
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <%
            Producto producto=new Producto();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla=producto.leer(); 
            for(int t=0; t<tabla.getRowCount();t++){
                out.println("<tr data-id="+ tabla.getValueAt(t, 0) + " data-id_m="+ tabla.getValueAt(t, 2)+">");
                out.println("<td>"+ tabla.getValueAt(t, 1)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 3)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 4)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 5)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 6)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 7)+"</td>");
                
                out.println("</tr>");
            }
        
        %>
      
    </tbody>
  </table>
        </h1>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    </body>
</html>
