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
    String dpi;
    String nombre;
    String marca;
    String modelo;
    String anio;
    String multas;
    String traspasos;

    int altura;
    Nodoavl izquierda, derecha;

    public Nodoavl(String departamento, String placa, String dpi, String nombre,
                   String marca, String modelo, String anio, String multas, String traspasos) {
        this.departamento = departamento;
        this.placa = placa;
        this.dpi = dpi;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.multas = multas;
        this.traspasos = traspasos;
        this.altura = 1;
    }
}
