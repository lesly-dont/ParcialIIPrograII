/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 50254
 */
public class Producto {
   private int id, existencias,idmarca,precioC, precioV;
   private String producto,descripcion;
   
   private Conexion cn;
public Producto (){}
    public Producto( int existencias,int idmarca, String producto, String descripcion, int precioC, int precioV) {
        
        this.existencias = existencias;
        this.idmarca = idmarca;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precioC = precioC;
        this.precioV = precioV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioC() {
        return precioC;
    }

    public void setPrecioC(int precioC) {
        this.precioC = precioC;
    }

    public int getPrecioV() {
        return precioV;
    }

    public void setPrecioV(int precioV) {
        this.precioV = precioV;
    }
  
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }
    
   
   public void agregar(){
   try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="INSERT INTO `parcialii`.`productos` (`producto`, `idMarca`, `Descripcion`, `precio_costo`, `precio_venta`, `existencias`) VALUES (?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getIdmarca());
            parametro.setString(3, getDescripcion());
            parametro.setInt(4, getPrecioC());
            parametro.setInt(5, getPrecioV());
            parametro.setInt(6, getExistencias());
            parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
   public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn=new Conexion();
            cn.abrir_conexion();
            String query="SELECT p.idProducto as id, p.producto, m.idmarca,m.marca, p.Descripcion, p.precio_costo, p.precio_venta, p.existencias FROM productos as p inner join marcas as m on p.idMarca = m.idmarca;";
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]={"ID","Producto","ID Marca","Marca","Descripcion","Precio Costo","Precio Venta","Existencias" };
            tabla.setColumnIdentifiers(encabezado);
            String datos[]= new String [8];
            while(consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("producto");
            datos[2] = consulta.getString("idmarca");
            datos[3] = consulta.getString("marca");
            datos[4] = consulta.getString("Descripcion");
            datos[5] = consulta.getString("precio_costo");
            datos[6] = consulta.getString("precio_venta");
            datos[7] = consulta.getString("existencias");
            tabla.addRow(datos);
            }
            
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
   
   }
  

