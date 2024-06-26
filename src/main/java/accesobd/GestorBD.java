/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesobd;


import java.sql.*;
import java.util.ArrayList;
import modeloDatos.*;

/**
 * DAO
 * @author mamiko
 */
public class GestorBD extends ConexionBD{
    
    private Statement sentencia;
    private PreparedStatement sentenciaP;
    private ResultSet cursor;

    public GestorBD(String tipo,String nombreBD,String usuario,String clave) {
        super(tipo,nombreBD,usuario,clave);
    
    }

    public ArrayList<Paciente> obtenerPaciente(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "Select * from PACIENTE";
        try{
            this.sentenciaP = this.conexion.prepareStatement(sql);
            cursor = this.sentenciaP.executeQuery();
            
            while(cursor.next()){
                Paciente p = new Paciente();
                p.setDni(cursor.getString(1));
                p.setNombre(cursor.getString(2));
                p.setTel(cursor.getString(3));
                pacientes.add(p);
            }
        }catch(SQLException ex){
            System.out.println("Error");
        }
        return pacientes;
    }
    
    public ArrayList<Medico> obtenerMedico(){
        ArrayList<Medico> medicos = new ArrayList<>();
        String sql = "Select * from MEDICO";
        try{
            this.sentencia = this.conexion.createStatement();
            cursor = this.sentencia.executeQuery(sql);
            
            int seq = 1;  //シーケンス番号
            while(cursor.next()){
                Medico m = new Medico();
                m.setSecuencia(seq);
                m.setNombre(cursor.getString(1));
                m.setEsp(cursor.getString(2));

                medicos.add(m);
                seq++;
            }
        }catch(SQLException ex){
            System.out.println("Error");
        }
        return medicos;
    }
    
    public void cerrarConexion(){
        try{
            if(this.sentencia!=null)
                sentencia.close();
            if(this.sentenciaP!=null)
                sentenciaP.close();
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error en el cierre");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}