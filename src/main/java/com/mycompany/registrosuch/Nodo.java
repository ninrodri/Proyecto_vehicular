/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrosuch;

/**
 *
 * @author nincy
 */
public class Nodo {
 
   String departamento, placa, fecha, descripcion;
    int monto;
    Nodo izq, der;

    public Nodo(String departamento, String placa, String fecha, String descripcion, int monto) {
        this.departamento = departamento;
        this.placa = placa;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }
}
