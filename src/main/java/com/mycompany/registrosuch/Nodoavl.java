/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrosuch;

/**
 *
 * @author nincy
 */
public class Nodoavl {
    
     String departamento;
    String placa;
    String fecha;
    String descripcion;
    int monto;
    int altura;
    Nodoavl izquierda, derecha;

    public Nodoavl(String departamento, String placa, String fecha, String descripcion, int monto) {
        this.departamento = departamento;
        this.placa = placa;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.altura = 1;
    }
}
