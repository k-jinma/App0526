/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesobd;

//clase que solo va a contener el codigo necesario para conectarse a una base de datos
import java.sql.*;

/**
 *
 * @author anag
 */

public class ConexionBD {
    
    protected String drivermysql;
    protected String url;
    protected Connection conexion;
    protected String usuario;
    protected String pass;
    
    public ConexionBD(String tipo, String nombreBD, String usuario, String clave){
        this.usuario=usuario;
        this.pass=clave;
        if(tipo.equals("mysql")){
            
            this.drivermysql="com.mysql.cj.jdbc.Driver";
            this.url="jdbc:mysql://localhost:3306/"+nombreBD;
            try{
                //1º se pasan los drivers
                Class.forName(drivermysql);//puede generar "class not found"
                
                //2º establecer la conexión a la base de datos
                this.conexion=DriverManager.getConnection(url, usuario, pass);
                
                System.out.println("Conexión establecida exitosamente");
                
            }catch(ClassNotFoundException e1){
                System.err.println("Se produjo error al no encontrar la clase");
                System.err.println(e1);
            }catch(SQLException e2){
                System.err.println("No hay ningún driver registrado que reconozca la URL especificada");
                System.err.println(e2);
            }catch(Exception e3){
                System.err.println("Se ha producido un error desconocido");
                System.err.println(e3);
            }
            
            
        }
    }
    
}