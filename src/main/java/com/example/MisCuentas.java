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
    private int id_usuario;
    private String banco;
    private int idBanco; 
    private double deuda;
    private double saldo;
    private double cuota;

    public MisCuentas(String usuario, int id_usuario, String banco, int idBanco, double deuda, double saldo) {
        this.usuario = usuario;
        this.id_usuario = id_usuario;
        this.banco = banco;
        this.idBanco = idBanco;
        this.deuda = deuda;
        this.saldo = saldo;
    }

    public MisCuentas(int id_usuario, int idBanco, double deuda, double saldo) {
        this.id_usuario = id_usuario;
        this.idBanco = idBanco;
        this.deuda = deuda;
        this.saldo = saldo;
    }

    public MisCuentas(int id_usuario) {
        this.id_usuario = id_usuario;
    }

 

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
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

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    
    
}
