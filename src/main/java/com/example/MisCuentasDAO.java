/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcia Castro
 */
public class MisCuentasDAO {
    
    public static void leerBancosDB(MisCuentas misCuentas){
        Conexion dbConnect = new Conexion();
        
        try(Connection conexion = (Connection) dbConnect.get_connection()) {
            PreparedStatement  ps=null;
            PreparedStatement  ps1=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            
            try{
                String query="SELECT id_banco FROM deuda_por_usuario WHERE id_usuario = ?;";
                
                ps=conexion.prepareStatement(query);
                ps.setString(1, String.valueOf(misCuentas.getId_usuario()));
                rs=ps.executeQuery();
                
                while (rs.next()) {
                    String query1="SELECT banco FROM bancos WHERE id_bancos = ?;";
                
                    ps1=conexion.prepareStatement(query1);
                    ps1.setString(1, String.valueOf(misCuentas.getBanco()));
                    rs1=ps1.executeQuery();
                    System.out.println("Banco: "+rs.getInt("banco"));
                }
               
            }catch(SQLException e){
                System.out.println("no se pudieron recuperar los bancos");
                System.out.println(e);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void leerDeudasDB(int usuario, int banco){
        
    }
    
    public static void pagarDeudaDB(int usuario, int deuda){
        
    }
    
    public static void actualizarDeudasDB(int usuario){
        
    }
    
    public static void pagarCuotas(MisCuentas misCuentas){
        Conexion dbConnect = new Conexion();
        
        try(Connection conexion = (Connection) dbConnect.get_connection()) {
            PreparedStatement  ps=null;
            ResultSet rs=null;
            
           
            
        } catch (Exception e) {
        }
    }
}
