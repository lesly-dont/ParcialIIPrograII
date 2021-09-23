package modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lesly Quevedo
 */
public class Conexion {
    public Connection conexionBD;
    //public final String puerto = "3306";
    public final String bd = "parcialii";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd);
    public final String usuario = "root";
    public final String contra = "leslyquevedo0016";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion (){
    try{
    Class.forName(jdbc);
    conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
   //JOptionPane.showMessageDialog(null, "Conexion Exitosa","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    
    }catch(HeadlessException | ClassNotFoundException | SQLException ex){
    System.out.println("Error " + ex.getMessage());
    }
    }
    public void cerrar_conexion (){
    try{
        conexionBD.close();
    }catch(SQLException ex){
         System.out.println("Error " + ex.getMessage());
    }
    } 
}
