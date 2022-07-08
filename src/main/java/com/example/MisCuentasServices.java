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
    
     public static void listarBancos(MisCuentas misCuentas){
        MisCuentasDAO.leerBancosDB(misCuentas);
     }
     
     public static void listardeudas(MisCuentas misCuentas){
        Scanner sc = new Scanner(System.in);
          
        System.out.println("Escribe el id del banco que quieres mirar");
        int idBanco = Integer.valueOf(sc.nextLine());
        misCuentas.setIdBanco(idBanco);
        MisCuentasDAO.verDeudasDB(misCuentas);
     }
     
     public static void pagarCuota(){
         
     }
     
     public static void estadoDeuda(){
         
     }
     
        
}
