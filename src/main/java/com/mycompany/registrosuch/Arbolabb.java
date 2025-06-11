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

     public void insertar(String depto, String placa, String fecha, String descripcion, int monto) {
        raiz = insertarRec(raiz, depto, placa, fecha, descripcion, monto);
    }

    private Nodo insertarRec(Nodo nodo, String depto, String placa, String fecha, String descripcion, int monto) {
        if (nodo == null) return new Nodo(depto, placa, fecha, descripcion, monto);
        if (placa.compareTo(nodo.placa) < 0) {
            nodo.izq = insertarRec(nodo.izq, depto, placa, fecha, descripcion, monto);
        } else {
            nodo.der = insertarRec(nodo.der, depto, placa, fecha, descripcion, monto);
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
            // Nodo encontrado
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;

            Nodo sucesor = encontrarMinimo(nodo.der);
            nodo.placa = sucesor.placa;
            nodo.departamento = sucesor.departamento;
            nodo.fecha = sucesor.fecha;
            nodo.descripcion = sucesor.descripcion;
            nodo.monto = sucesor.monto;
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
            lista.add(new String[]{nodo.departamento, nodo.placa, nodo.fecha, nodo.descripcion, String.valueOf(nodo.monto)});
            inOrden(nodo.der, lista);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
}
