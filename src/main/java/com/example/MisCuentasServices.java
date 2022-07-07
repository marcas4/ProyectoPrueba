/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.util.Scanner;

/**
 *
 * @author Marcia Castro
 */
public class MisCuentasServices {
    
     public static void listarBancos(){
         
         Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el id de tu usuario");
        int idUsuario = Integer.valueOf(sc.nextLine());
        MisCuentas cuenta = new MisCuentas(idUsuario);
        MisCuentasDAO.leerBancosDB(cuenta);
     }
     
     public static void listardeudas(){
         
     }
     
     public static void pagarCuota(){
         
     }
     
     public static void estadoDeuda(){
         
     }
     
        
}
