package com.example;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            
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
                        MisCuentasServices.listarBancos();
                        break;
                    case 2:
                        MisCuentasServices.listardeudas();
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
             Connection conexion = new Connection();
        
        try(java.sql.Connection cnx = conexion.get_connection()){
            
        }catch(Exception e){
            System.out.print(e);
        }
    }
               
}


