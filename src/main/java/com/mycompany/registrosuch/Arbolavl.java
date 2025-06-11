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
public class Arbolavl {
    
    private Nodoavl raiz;

    public void insertar(String depto, String placa, String fecha, String descripcion, int monto) {
        raiz = insertarRec(raiz, depto, placa, fecha, descripcion, monto);
    }

    private Nodoavl insertarRec(Nodoavl nodo, String depto, String placa, String fecha, String descripcion, int monto) {
        if (nodo == null) return new Nodoavl(depto, placa, fecha, descripcion, monto);

        if (placa.compareTo(nodo.placa) < 0) {
            nodo.izquierda = insertarRec(nodo.izquierda, depto, placa, fecha, descripcion, monto);
        } else {
            nodo.derecha = insertarRec(nodo.derecha, depto, placa, fecha, descripcion, monto);
        }

        actualizarAltura(nodo);

        int balance = obtenerBalance(nodo);

        if (balance > 1 && placa.compareTo(nodo.izquierda.placa) < 0)
            return rotarDerecha(nodo);

        if (balance < -1 && placa.compareTo(nodo.derecha.placa) > 0)
            return rotarIzquierda(nodo);

        if (balance > 1 && placa.compareTo(nodo.izquierda.placa) > 0) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && placa.compareTo(nodo.derecha.placa) < 0) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

        public void eliminar(String placa) {
        raiz = eliminarRec(raiz, placa);
    }

    private Nodoavl eliminarRec(Nodoavl nodo, String placa) {
        if (nodo == null) return null;

        if (placa.compareTo(nodo.placa) < 0)
            nodo.izquierda = eliminarRec(nodo.izquierda, placa);
        else if (placa.compareTo(nodo.placa) > 0)
            nodo.derecha = eliminarRec(nodo.derecha, placa);
        else {
            if (nodo.izquierda == null || nodo.derecha == null) {
                nodo = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;
            } else {
                Nodoavl sucesor = encontrarMinimo(nodo.derecha);
                nodo.placa = sucesor.placa;
                nodo.departamento = sucesor.departamento;
                nodo.fecha = sucesor.fecha;
                nodo.descripcion = sucesor.descripcion;
                nodo.monto = sucesor.monto;
                nodo.derecha = eliminarRec(nodo.derecha, sucesor.placa);
            }
        }

        return (nodo != null) ? reequilibrar(nodo) : null;
    }

    private Nodoavl encontrarMinimo(Nodoavl nodo) {
        while (nodo.izquierda != null) nodo = nodo.izquierda;
        return nodo;
    }

    private Nodoavl reequilibrar(Nodoavl nodo) {
        actualizarAltura(nodo);
        int balance = obtenerBalance(nodo);

        if (balance > 1) {
            if (obtenerBalance(nodo.izquierda) < 0)
                nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        if (balance < -1) {
            if (obtenerBalance(nodo.derecha) > 0)
                nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    
    
    private Nodoavl rotarDerecha(Nodoavl y) {
        Nodoavl x = y.izquierda;
        Nodoavl T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private Nodoavl rotarIzquierda(Nodoavl x) {
        Nodoavl y = x.derecha;
        Nodoavl T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    private void actualizarAltura(Nodoavl nodo) {
        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierda), obtenerAltura(nodo.derecha));
    }

    private int obtenerAltura(Nodoavl nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int obtenerBalance(Nodoavl nodo) {
        return (nodo == null) ? 0 : obtenerAltura(nodo.izquierda) - obtenerAltura(nodo.derecha);
    }

    public void inOrden(Nodoavl nodo, ArrayList<String[]> lista) {
        if (nodo != null) {
            inOrden(nodo.izquierda, lista);
            lista.add(new String[]{nodo.departamento, nodo.placa, nodo.fecha, nodo.descripcion, String.valueOf(nodo.monto)});
            inOrden(nodo.derecha, lista);
        }
    }

    public Nodoavl getRaiz() {
        return raiz;
    }
}
    
   
