package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
             Connection conexion = new Connection();
        
        try(java.sql.Connection cnx = conexion.get_connection()){
            
        }catch(Exception e){
            System.out.print(e);
        }
    }
               
}


