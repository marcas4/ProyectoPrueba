/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

/**
 *
 * @author Marcia Castro
 */
public class MisCuentas {
    
    private String usuario;
    private String banco;
    private double deuda;
    private double saldo;

    public MisCuentas(String usuario, String banco) {
        this.usuario = usuario;
        this.banco = banco;
    }

    public MisCuentas(String usuario, String banco, double deuda) {
        this.usuario = usuario;
        this.banco = banco;
        this.deuda = deuda;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
