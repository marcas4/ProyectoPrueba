/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcia Castro
 */
public class Conexion {
    
     public Connection get_connection(){
        Connection conection = null;
        
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost/proyectoprueba","root","");
           /* if(conection != null){
                System.out.println("Conexión exitosa");
            }*/
                                   
        }catch(SQLException e){
            System.out.println(e);
        }
        return conection;
    }
    
}
