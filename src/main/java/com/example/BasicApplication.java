package com.example;

import java.sql.Connection;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
        //Se pregunta al usuario su id
        Scanner sc = new Scanner(System.in);
        Scanner scid = new Scanner(System.in);
        System.out.println("Escribe el id de tu usuario");
        int idUsuario = Integer.valueOf(scid.nextLine());
        MisCuentas misCuentas = new MisCuentas(idUsuario);
            
            int option = 0;
            //Se lista el menú
            do{
                System.out.println("***************************");
                System.out.println("  Aplicación de Mis Cuentas  ");
                System.out.println("1. Ver el listado de mis bancos");
                System.out.println("2. Ver mis deudas ");
                System.out.println("3. Pagar una deuda");
                System.out.println("4. Salir");
                
                //Se lee la opción que se de en pantalla
                option = sc.nextInt();
                
                switch(option){
                    case 1:
                        MisCuentasServices.listarBancos(misCuentas);
                        break;
                    case 2:
                        MisCuentasServices.listardeudas(misCuentas);
                        break;
                    case 3:
                       MisCuentasServices.pagarCuota(misCuentas);
                        break;
                    default:
                        break;
                }
                
            }while(option != 4);
            
                       
		SpringApplication.run(BasicApplication.class, args);
            
    }
             
}


