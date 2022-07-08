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
        Scanner sc1 = new Scanner(System.in);
          
        System.out.println("Escribe el id del banco que quieres mirar");
        int idBanco = Integer.valueOf(sc.nextLine());
        misCuentas.setIdBanco(idBanco);
        MisCuentasDAO.verDeudasDB(misCuentas);
     }
     
     public static void pagarCuota(MisCuentas misCuentas){
         Scanner sc = new Scanner(System.in);
          
        System.out.println("Escribe el id de la deuda que quieres pagar ");
         int idDeuda = Integer.valueOf(sc.nextLine());
         misCuentas.setIdDeuda(idDeuda);
        System.out.println("Escribe cuantas cuotas vas a pagar ");
        int cuotas = Integer.valueOf(sc.nextLine());
        misCuentas.setNumCuotas(cuotas);
        
        System.out.println("Por favor confirma que vas a pagar ahora (y/n): ");
        String confirmar = sc.nextLine();
        
        if(confirmar.equals("y")){
            MisCuentasDAO.pagarCuotas(misCuentas);
        }else{
            System.out.println("Muchas gracias por utilizar nuestros servicios, cuando esté listo o lista para pagar tu deuda vuelve a este menú");
        }
         
     }
        
}
