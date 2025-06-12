/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrosuch;

import java.util.ArrayList;

/**
 *
 * @author nincy
 */
public class Arbolabb {
    private Nodo raiz;

     public void insertar(String depto, String placa, String dpi, String nombre,
                         String marca, String modelov, String anio, String multas, String traspasos) {
        System.out.println("Insertando placa: " + placa); 
         raiz = insertarRec(raiz, depto, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
    }

    private Nodo insertarRec(Nodo nodo, String depto, String placa, String dpi, String nombre,
                             String marca, String modelov, String anio, String multas, String traspasos) {
        if (nodo == null) return new Nodo(depto, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
        if (placa.compareTo(nodo.placa) < 0) {
            nodo.izq = insertarRec(nodo.izq, depto, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
        } else {
            nodo.der = insertarRec(nodo.der, depto, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
        }
        return nodo;
    }

      public void eliminar(String placa) {
        raiz = eliminarRec(raiz, placa);
    }

    private Nodo eliminarRec(Nodo nodo, String placa) {
        if (nodo == null) return null;
        if (placa.compareTo(nodo.placa) < 0) {
            nodo.izq = eliminarRec(nodo.izq, placa);
        } else if (placa.compareTo(nodo.placa) > 0) {
            nodo.der = eliminarRec(nodo.der, placa);
        } else {
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;

            Nodo sucesor = encontrarMinimo(nodo.der);
            nodo.placa = sucesor.placa;
            nodo.departamento = sucesor.departamento;
            nodo.dpi = sucesor.dpi;
            nodo.nombre = sucesor.nombre;
            nodo.marca = sucesor.marca;
            nodo.modelo = sucesor.modelo;
            nodo.anio = sucesor.anio;
            nodo.multas = sucesor.multas;
            nodo.traspasos = sucesor.traspasos;
            nodo.der = eliminarRec(nodo.der, sucesor.placa);
        }
        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izq != null) nodo = nodo.izq;
        return nodo;
    }
    
    public void inOrden(Nodo nodo, ArrayList<String[]> lista) {
        if (nodo != null) {
            inOrden(nodo.izq, lista);
            lista.add(new String[]{
                nodo.departamento, nodo.placa, nodo.dpi, nodo.nombre,
                nodo.marca, nodo.modelo, nodo.anio, nodo.multas, nodo.traspasos
            });
            inOrden(nodo.der, lista);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
}
