/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.registrosuch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nincy
 */
public class Multas extends javax.swing.JFrame {
    
    public File carpeta;
    private Arbolabb abb= new Arbolabb();
    private Arbolavl avl = new Arbolavl();
    private String arbolActivo = "ABB";
    private Multas multas;

    /**
     * Creates new form Multas
     */
    public Multas(){
    initComponents();
    }

        public Multas(File Cseleccion) {
        initComponents();
        this.carpeta = Cseleccion;
        configurarTablaVacia();
    }
        
      
        
        
     private void configurarTablaVacia() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.addColumn("Departamento");
        modelo.addColumn("Placa");
        modelo.addColumn("DPI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año");
        modelo.addColumn("Multas");
        modelo.addColumn("Traspasos");
    }

    private void cargarDesdeArchivosABB() throws FileNotFoundException {
    configurarTablaVacia();               // limpia y define columnas
    long inicio = System.nanoTime();
    abb = new Arbolabb();

    for (File sub : carpeta.listFiles(File::isDirectory)) {
        for (File archivo : sub.listFiles((f) -> f.getName().toLowerCase().endsWith("vehiculos.txt") ||
                                              f.getName().toLowerCase().endsWith("vehiculos"))) {
            try (Scanner lector = new Scanner(archivo)) {
                lector.nextLine(); // saltar encabezado
                String departamento = archivo.getName()
                                             .replace("_vehiculos.txt", "")
                                             .replace("_vehiculos", "")
                                             .replace("_", " ")
                                             .trim();

                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    if (linea.isBlank()) continue;
                    String[] datos = linea.split(",", -1);
                    if (datos.length < 8) continue;

                    String placa       = datos[0].trim();
                    String dpi         = datos[1].trim();
                    String nombre      = datos[2].trim();
                    String marca       = datos[3].trim();
                    String modelo      = datos[4].trim();
                    String anio        = datos[5].trim();
                    String multasStr   = datos[6].trim();
                    String traspasosStr= datos[7].trim();

                    abb.insertar(departamento,
                                 placa,
                                 dpi,
                                 nombre,
                                 marca,
                                 modelo,
                                 anio,
                                 multasStr,
                                 traspasosStr);
                }
            }
        }
    }

    long fin = System.nanoTime();
    
    JOptionPane.showMessageDialog(this, "Tiempo ABB: " + (fin - inicio) + " ns");
    System.out.println("Insertando nodo: " ); 
    mostrarDesdeABB();
  

}

    private void mostrarDesdeABB() {
         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        ArrayList<String[]> lista = new ArrayList<>();
        abb.inOrden(abb.getRaiz(), lista);
        
        for (String[] fila : lista) {
            modelo.addRow(fila);
        }
    }

     private void cargarDesdeArchivosAVL() throws FileNotFoundException {
         configurarTablaVacia();
    long inicio = System.nanoTime();
    avl = new Arbolavl();

    for (File sub : carpeta.listFiles(File::isDirectory)) {
        for (File archivo : sub.listFiles((f) -> f.getName().toLowerCase().endsWith("vehiculos.txt") ||
                                              f.getName().toLowerCase().endsWith("vehiculos"))) {
            try (Scanner lector = new Scanner(archivo)) {
                lector.nextLine(); // saltar encabezado
                String departamento = archivo.getName()
                                             .replace("_vehiculos.txt", "")
                                             .replace("_vehiculos", "")
                                             .replace("_", " ")
                                             .trim();

                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    if (linea.isBlank()) continue;
                    String[] datos = linea.split(",", -1);
                    if (datos.length < 8) continue;

                    String placa       = datos[0].trim();
                    String dpi         = datos[1].trim();
                    String nombre      = datos[2].trim();
                    String marca       = datos[3].trim();
                    String modelo      = datos[4].trim();
                    String anio        = datos[5].trim();
                    String multasStr   = datos[6].trim();
                    String traspasosStr= datos[7].trim();

                    avl.insertar(departamento,
                                 placa,
                                 dpi,
                                 nombre,
                                 marca,
                                 modelo,
                                 anio,
                                 multasStr,
                                 traspasosStr);
                }
            }
        }
    }

    long fin = System.nanoTime();
    JOptionPane.showMessageDialog(this, "Tiempo AVL: " + (fin - inicio) + " ns");
    mostrarDesdeAVL();
}

    private void mostrarDesdeAVL() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        ArrayList<String[]> lista = new ArrayList<>();
        avl.inOrden(avl.getRaiz(), lista);
        for (String[] fila : lista) {
            modelo.addRow(fila);
        }
    }
    
        public void agregarFila(String departamento, String placa, String dpi, String nombre,
                        String marca, String modelov, String anio, String multas, String traspasos) {
    DefaultTableModel tabla = (DefaultTableModel) jTable1.getModel();
    tabla.addRow(new Object[]{
        departamento,
        placa,
        dpi,
        nombre,
        marca,
        modelov,
        anio,
        multas,
        traspasos
    }); }

    public Arbolabb getAbb() {
    return abb;
}

public Arbolavl getAvl() {
    return avl;
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Registros = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        ABB = new javax.swing.JButton();
        AVL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Departamento", "Placa", "DPI", "Nombre", "Marca", "Modelov", "Año", "Multas", "Traspasos"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 105, 524, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        Registros.setText("Registro de Placas");
        Registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrosActionPerformed(evt);
            }
        });

        jButton2.setText("Insertar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(Registros)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Modificar)
                    .addComponent(eliminar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(Registros)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(34, 34, 34)
                .addComponent(Modificar)
                .addGap(45, 45, 45)
                .addComponent(eliminar)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        ABB.setText("Arbol ABB");
        ABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABBActionPerformed(evt);
            }
        });

        AVL.setText("Arbol AVL");
        AVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AVLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(buscar)
                .addGap(18, 18, 18)
                .addComponent(ABB)
                .addGap(36, 36, 36)
                .addComponent(AVL)
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(ABB)
                    .addComponent(AVL))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 720, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABBActionPerformed
    
        long inicio = System.nanoTime();
        arbolActivo = "ABB";
    
    abb = new Arbolabb(); // Reiniciar el árbol

    File[] subcarpetas = carpeta.listFiles(File::isDirectory);
    for (File sub : subcarpetas) {
        File[] archivos = sub.listFiles();
        for (File archivo : archivos) {
           if (archivo.getName().toLowerCase().endsWith("vehiculos.txt")) {
                try (Scanner lector = new Scanner(archivo)) {
                    String nombreArchivo = archivo.getName();
                    String departamento = nombreArchivo.replace("_vehiculos.txt", "")
                                                        .replace("_vehiculos", "")
                                                        .replace("_", " ")
                                                        .trim();
                    
                     if (lector.hasNextLine()) lector.nextLine();
  
        while (lector.hasNextLine()) {
           String[] datos = lector.nextLine().split(",", -1);
                        if (datos.length >= 8) {
                            String placa = datos[0].trim();
                            String dpi = datos[1].trim();
                            String nombre = datos[2].trim();
                            String marca = datos[3].trim();
                            String modelov = datos[4].trim();
                            String anio = datos[5].trim();
                            String multas = datos[6].trim();
                            String traspasos = datos[7].trim();


                abb.insertar(departamento, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
            }String linea = lector.nextLine();
System.out.println("Línea leída: " + linea); 
        }
    } catch (Exception e) {
        System.out.println("Error en archivo: " + archivo.getName());
    }
}
        }
    }

    long fin = System.nanoTime();
    JOptionPane.showMessageDialog(this, "Tiempo de carga en ABB: " + (fin - inicio) + " ns");
   System.out.println("Raíz del árbol: " + abb.getRaiz());
   ArrayList<String[]> debugLista = new ArrayList<>();
abb.inOrden(abb.getRaiz(), debugLista);
System.out.println("Cantidad de registros en recorrido ABB: " + debugLista.size());

   
   mostrarDesdeABB();

    }//GEN-LAST:event_ABBActionPerformed

    private void AVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AVLActionPerformed
          long inicio = System.nanoTime();
    avl = new Arbolavl(); // Reinicia el árbol

    File[] subcarpetas = carpeta.listFiles(File::isDirectory);
    for (File sub : subcarpetas) {
        File[] archivos = sub.listFiles();
        for (File archivo : archivos) {
            if (archivo.getName().toLowerCase().endsWith("vehiculos.txt")) {
                try (Scanner lector = new Scanner(archivo)) {
                    String nombreArchivo = archivo.getName();
                    String departamento = nombreArchivo.replace("_vehiculos.txt", "")
                                                        .replace("_vehiculos", "")
                                                        .replace("_", " ")
                                                        .trim();

                    if (lector.hasNextLine()) lector.nextLine(); // Saltar encabezado

                    while (lector.hasNextLine()) {
                        String[] datos = lector.nextLine().split(",", -1);
                        if (datos.length >= 8) {
                            String placa = datos[0].trim();
                            String dpi = datos[1].trim();
                            String nombre = datos[2].trim();
                            String marca = datos[3].trim();
                            String modelov = datos[4].trim();
                            String anio = datos[5].trim();
                            String multas = datos[6].trim();
                            String traspasos = datos[7].trim();

                            avl.insertar(departamento, placa, dpi, nombre, marca, modelov, anio, multas, traspasos);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error al procesar archivo: " + archivo.getName());
                }
            }
        }
    }

    long fin = System.nanoTime();
    JOptionPane.showMessageDialog(this, "Tiempo de carga en AVL: " + (fin - inicio) + " ns");
    mostrarDesdeAVL(); 

    }//GEN-LAST:event_AVLActionPerformed

    private void RegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrosActionPerformed
int fila = jTable1.getSelectedRow();
if (fila != -1) {
    String placa = jTable1.getValueAt(fila, 1).toString(); // columna de placa
    Registros h = new Registros(carpeta, placa);
    h.setVisible(true);
} else {
    JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
}        
    }//GEN-LAST:event_RegistrosActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
         String textoBuscado = jTextField1.getText().trim();

    if (textoBuscado.isEmpty()) if (textoBuscado.isEmpty()) {
    jTable1.setRowSorter(null);  // Quita el filtro si el campo está vacío
    return;
}

    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
    jTable1.setRowSorter(sorter);

    RowFilter<DefaultTableModel, Object> filtro = RowFilter.regexFilter("(?i)" + textoBuscado);
    sorter.setRowFilter(filtro);
    
 
    }//GEN-LAST:event_buscarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
         int filaSeleccionada = jTable1.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
        return;
    }

    // Obtener placa (clave primaria para eliminar del árbol)
    String placa = jTable1.getValueAt(filaSeleccionada, 1).toString(); // columna de placa

    int opcion = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro que deseas eliminar la multa con placa: " + placa + "?", 
        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        // Medición de tiempo
        long inicio = System.nanoTime();
        
        // Eliminar del árbol (según el que estés usando)
        abb.eliminar(placa); 
        avl.eliminar(placa);// si estás trabajando con ABB
        // avl.eliminar(placa); // si estás usando AVL

        long fin = System.nanoTime();

        JOptionPane.showMessageDialog(this, "Eliminación completada.\nTiempo: " + (fin - inicio) + " ns");

        // Refrescar la tabla
        mostrarDesdeABB(); 
    }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Insertar insertarVentana = new Insertar(this);  // 'this' es la instancia actual de Multas
        insertarVentana.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
         int fila = jTable1.getSelectedRow();
    if (fila != -1) {
        // Obtener datos de la fila seleccionada
              String depto     = jTable1.getValueAt(fila, 0).toString();
        String placa     = jTable1.getValueAt(fila, 1).toString();
        String dpi       = jTable1.getValueAt(fila, 2).toString();
        String nombre    = jTable1.getValueAt(fila, 3).toString();
        String marca     = jTable1.getValueAt(fila, 4).toString();
        String modelo    = jTable1.getValueAt(fila, 5).toString();
        String anio      = jTable1.getValueAt(fila, 6).toString();
        String multas    = jTable1.getValueAt(fila, 7).toString();
        String traspasos = jTable1.getValueAt(fila, 8).toString();

        // Abrir ventana Modificar con los datos
        Modificar mod = new Modificar(depto, placa, dpi, nombre, marca, modelo, anio, multas, traspasos);
        mod.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
    }
    }//GEN-LAST:event_ModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Multas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABB;
    private javax.swing.JButton AVL;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Registros;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
}
