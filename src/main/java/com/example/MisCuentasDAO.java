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
        
        PreparedStatement  ps=null;
        ResultSet rs=null;
        
        try(Connection conexion = (Connection) dbConnect.get_connection()) {
               
            String query="SELECT * FROM deuda_por_usuario INNER JOIN bancos ON deuda_por_usuario.id_banco = bancos.id_banco WHERE id_usuario = ?";
                
                ps=conexion.prepareStatement(query);
                ps.setString(1, String.valueOf(misCuentas.getId_usuario()));
                rs=ps.executeQuery();
                
                while (rs.next()) {
                    System.out.println("Banco: "+rs.getString("banco")+"  ID del Banco: "+rs.getInt("id_banco"));
                                
                }
            }catch(SQLException e){
                System.out.println("no se pudieron recuperar los bancos");
                System.out.println(e);
            }
            
       
    }
    
    public static void verDeudasDB(MisCuentas misCuentas){
        Conexion dbConnect = new Conexion();
        
        PreparedStatement  ps=null;
        ResultSet rs=null;
        
        try(Connection conexion = (Connection) dbConnect.get_connection()) {
               /* String query="SELECT * FROM deuda_por_usuario WHERE id_banco = ? AND id_usuario = ?";
               */
               String query="SELECT * FROM bancos INNER JOIN (deuda_por_usuario INNER JOIN deudas ON deuda_por_usuario.id_deuda = deudas.id_deuda)" +
                             " ON bancos.id_banco = deuda_por_usuario.id_banco" +
                             " WHERE deuda_por_usuario.id_banco = ? AND deuda_por_usuario.id_usuario = ?";
                
                ps=conexion.prepareStatement(query);
                ps.setString(1, String.valueOf(misCuentas.getIdBanco()));
                ps.setString(2, String.valueOf(misCuentas.getId_usuario()));
                rs=ps.executeQuery();
                while (rs.next()) {
                    System.out.println("id Banco: "+misCuentas.getIdBanco());
                    System.out.println("Deuda: "+rs.getDouble("deuda"));
                    System.out.println("Valor cuota: "+rs.getDouble("valor_cuota"));
                    System.out.println("Cuotas totales: "+rs.getInt("cuotas_totales"));
                    System.out.println("Cuotas pagadas: "+rs.getInt("cuotas_pagadas"));
                    System.out.println("Saldo que debe: "+rs.getDouble("saldo"));
                                
                }
               
            }catch(SQLException e){
                System.out.println("no se pudieron recuperar las deudas");
                System.out.println(e);
            }
        
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
