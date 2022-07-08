package com.example;

import java.sql.Connection;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
            
            
        /*     Conexion conexion = new Conexion();
                        try(Connection cnx = (Connection) conexion.get_connection()) {
                                                        
                        } catch (Exception e) {
                            System.out.println(e); 
                                    
                        }*/
            
        Scanner sc = new Scanner(System.in);
        Scanner scid = new Scanner(System.in);
        System.out.println("Escribe el id de tu usuario");
        int idUsuario = Integer.valueOf(scid.nextLine());
        MisCuentas misCuentas = new MisCuentas(idUsuario);
            
            int option = 0;
            
            do{
                System.out.println("************************");
                System.out.println("  Aplicación de Mis Cuentas  ");
                System.out.println("1. Ver el listado de mis bancos");
                System.out.println("2. Ver mis deudas ");
                System.out.println("3. Ver estado de mi deuda ");
                System.out.println("4. Pagar una deuda");
                System.out.println("5. Salir");
                
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
                       MisCuentasServices.estadoDeuda();
                        break;
                    case 4:
                       MisCuentasServices.pagarCuota();
                        break;
                    default:
                        break;
                }
                
            }while(option != 5);
            
                       
		SpringApplication.run(BasicApplication.class, args);
            
    }
             
}


