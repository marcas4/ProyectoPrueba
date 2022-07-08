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
    /*Se conecta directamente con la base de datos para obtener la lista de bancos donde la
      usuaria o usuario tiene deudas*/
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
    
    /*Se conecta directamente con la base de datos para obtener la lista de deudas que tiene la
      usuaria o usuario en determinado banco*/
    public static void verDeudasDB(MisCuentas misCuentas){
        Conexion dbConnect = new Conexion();
        
        PreparedStatement  ps=null;
        ResultSet rs=null;
        
        try(Connection conexion = (Connection) dbConnect.get_connection()) {
               String query="SELECT * FROM bancos INNER JOIN (deuda_por_usuario INNER JOIN deudas ON deuda_por_usuario.id_deuda = deudas.id_deuda)" +
                             " ON bancos.id_banco = deuda_por_usuario.id_banco" +
                             " WHERE deuda_por_usuario.id_banco = ? AND deuda_por_usuario.id_usuario = ?";
                
                ps=conexion.prepareStatement(query);
                ps.setString(1, String.valueOf(misCuentas.getIdBanco()));
                ps.setString(2, String.valueOf(misCuentas.getId_usuario()));
                rs=ps.executeQuery();
                while (rs.next()) {
                    System.out.println("id Banco: "+misCuentas.getIdBanco());
                    System.out.println("ID de la Deuda: "+rs.getInt("id_deuda"));
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
     /*Se conecta directamente con la base de datos para pagar las cuotas que desee  la
      usuaria o usuario en la deuda elegida por el o ella*/  
    public static void pagarCuotas(MisCuentas misCuentas){
       Conexion db_connect = new Conexion();
        
       try(Connection conexion = db_connect.get_connection())  {
            PreparedStatement  ps=null;
            ResultSet rs=null;
            
             String query="SELECT * FROM deudas WHERE id_deuda= ?";
                
                ps=conexion.prepareStatement(query);
                ps.setString(1, String.valueOf(misCuentas.getIdDeuda()));
                rs=ps.executeQuery();
              /*  while (rs.next()) {
                    System.out.println("Deuda: "+rs.getDouble("deuda"));
               
                }*/
              rs.next();
              double valorCuota = rs.getDouble("valor_cuota");
              int cuotasPagadas= rs.getInt("cuotas_pagadas");
              int cuotasTotales = rs.getInt("cuotas_totales");
              double saldo = rs.getDouble("saldo");
              int cuotasFaltantes = cuotasTotales - cuotasPagadas;
              if(cuotasFaltantes < misCuentas.getNumCuotas()){
                   System.out.println("El número de cuotas que desea pagar excede el número de cuotas faltantes");
                   System.out.println("Solo puede pagar: "+cuotasFaltantes);
              }else{
                  double pago = misCuentas.getNumCuotas() * valorCuota;
                  int cuotasPagadasDB = cuotasPagadas + misCuentas.getNumCuotas();
                  double saldoDB = saldo - pago;
                  
                  PreparedStatement  ps1=null;
                  
                  String query1="UPDATE deudas SET saldo = ?, cuotas_pagadas = ? WHERE id_deuda = ?";
                               
                   ps1=conexion.prepareStatement(query1);
                   ps1.setString(1, String.valueOf(saldoDB));
                   ps1.setString(2, String.valueOf(cuotasPagadasDB));
                   ps1.setString(3, String.valueOf(misCuentas.getIdDeuda()));
                   ps1.executeUpdate();
                   
                   System.out.println("Ha pagado usted "+misCuentas.getNumCuotas()+" cuota por un valor total de: "+pago);
                   System.out.println("Se ha actualizado su deuda: ");
                   System.out.println("ID de la Deuda: "+rs.getInt("id_deuda"));
                   System.out.println("Deuda: "+rs.getDouble("deuda"));
                   System.out.println("Valor cuota: "+rs.getDouble("valor_cuota"));
                   System.out.println("Cuotas totales: "+rs.getInt("cuotas_totales"));
                   System.out.println("Cuotas pagadas: "+cuotasPagadasDB);
                   System.out.println("Saldo que debe: "+saldoDB);
                   
                   if(saldoDB == 0){
                       System.out.println("Su deuda ha sido cancelada totalmente");
                   }
                  
              }
                  
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
