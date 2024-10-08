/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasprimer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.FileWriter;
import java.io.PrintWriter;
import proyecto1c.contracts.IStatement;
import proyecto1c.symbols.SymTable;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;
import javax.swing.JOptionPane;
import proyecto1c.Lexer;
import proyecto1c.LexerWrapper;
import proyecto1c.Parser;
import proyecto1c.operations.SetEvaluation;
import vistasprimer.Analyzer;

/**
 *
 * @author infor
 */
public class Analyzer extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Analyzer() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGrafica = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnEjecutar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnNuevoArchivo = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        btnGuardarComo = new javax.swing.JMenuItem();
        btnCargar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnTokens = new javax.swing.JMenuItem();
        btnErrores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Entrada");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Gráficas");

        lblGrafica.setBackground(new java.awt.Color(255, 0, 102));
        lblGrafica.setBorder(new javax.swing.border.MatteBorder(null));

        btnAnterior.setText("Anterior");

        btnSiguiente.setText("Siguiente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Consola");

        txtSalida.setBackground(new java.awt.Color(0, 0, 0));
        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtSalida.setForeground(new java.awt.Color(0, 255, 0));
        txtSalida.setRows(5);
        jScrollPane2.setViewportView(txtSalida);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("ConjAnalyzer");

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEjecutar))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 37, Short.MAX_VALUE)
                                .addComponent(btnAnterior)
                                .addGap(36, 36, 36)
                                .addComponent(btnSiguiente)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnEjecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnterior)
                            .addComponent(btnSiguiente)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        btnNuevoArchivo.setText("Nuevo Archivo");
        btnNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(btnNuevoArchivo);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        btnGuardarComo.setText("Guardar Como");
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardarComo);

        btnCargar.setText("Cargar Archivo");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCargar);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Reportes");

        btnTokens.setText("Tokens");
        btnTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokensActionPerformed(evt);
            }
        });
        jMenu3.add(btnTokens);

        btnErrores.setText("Errores");
        btnErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErroresActionPerformed(evt);
            }
        });
        jMenu3.add(btnErrores);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErroresActionPerformed
        // TODO add your handling code here:
        try {
            Lexer lexer = new Lexer(new StringReader(txtEntrada.getText()));
            Parser parser = new Parser(lexer);
            parser.parse();

            // Combinar errores léxicos y sintácticos
            parser.syntaxErrors.addAll(lexer.getLexicalErrors());

            // Generar reporte de errores
            parser.generateErrorReport("error_report.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnErroresActionPerformed

    private void btnNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArchivoActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText("");
        txtSalida.setText("");
    }//GEN-LAST:event_btnNuevoArchivoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        // Crear el objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Configurar el filtro para archivos .ca
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos .ca", "ca"));

        // Mostrar el cuadro de diálogo para guardar el archivo
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Asegurarse de que el archivo tenga la extensión .ca
            if (!fileToSave.getName().endsWith(".ca")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".ca");
            }

            try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                fileWriter.write(txtEntrada.getText());
                JOptionPane.showMessageDialog(null, "Archivo guardado correctamente.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        // TODO add your handling code here:
        // Crear el JFileChooser para seleccionar el archivo
        JFileChooser fileChooser = new JFileChooser();

        // Mostrar el diálogo para guardar el archivo
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File fileToSave = fileChooser.getSelectedFile();

            // Intentar guardar el archivo
            try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                fileWriter.write(txtEntrada.getText());
                JOptionPane.showMessageDialog(null, "Archivo guardado correctamente.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
            }
        }
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        // Crear un JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Filtrar para que solo muestre archivos .ca (o puedes quitar este filtro)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .ca", "ca");
        fileChooser.setFileFilter(filter);

        // Mostrar el diálogo de abrir archivo
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // El usuario seleccionó un archivo
            File selectedFile = fileChooser.getSelectedFile();

            // Obtener la ruta completa del archivo seleccionado
            String filePath = selectedFile.getAbsolutePath();

            // Leer el archivo y obtener su contenido
            StringBuilder contentBuilder = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Obtener el contenido como un String
            String fileContent = contentBuilder.toString();

            // Imprimir el contenido del archivo
            //System.out.println("Contenido del archivo:");
            //System.out.println(fileContent);
            txtEntrada.setText("");
            txtEntrada.setText(fileContent);

        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }

        txtSalida.setText("");
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:

        // ---------------------------------------------------------------------------------------------------------
        //****************************************
        //****************************************
        //----------------------------------------------------
        //----------------------------------------------------
        Lexer scanner = new Lexer(new StringReader(txtEntrada.getText()));
        Parser parser = new Parser(scanner);
        LinkedList<IStatement> AST = null;
        SymTable environment = new SymTable();

        try {
            parser.parse();
            AST = parser.AST;
        } catch (Exception ex) {
            // Capturar cualquier excepción durante el proceso de parsing
            System.out.println("Excepción capturada: " + ex.getMessage());
            System.out.println("\n\n");
        } finally {
            // Ahora se imprime tanto errores léxicos como sintácticos al final del parsing
            if (!scanner.lexicalErrors.isEmpty()) {
                System.out.println("Errores lexicos:");
                for (String err : scanner.lexicalErrors) {
                    System.out.println(err); // Usar System.out en lugar de System.err
                }
                System.out.println("\n\n");

            }

            if (!parser.syntaxErrors.isEmpty()) {
                System.out.println("Errores sintacticos:");
                for (String err : parser.syntaxErrors) {
                    System.out.println(err); // Usar System.out en lugar de System.err
                }
                System.out.println("\n\n");

            }

            // Si no hubo errores fatales, ejecutar los AST
            if (AST != null && parser.syntaxErrors.isEmpty()) {
                System.out.println("Console:\n");
                for (IStatement s : AST) {
                    s.execute(environment);
                }
                //System.out.println("\n\n");

                //System.out.println("Tablas de simbolos:");
                // Imprime todas las tablas de símbolos creadas
                //environment.printAllScopes();
                //System.out.println("\n\n");
                StringBuilder str = new StringBuilder();
                str.append("""
                           digraph G {
                           rootNode [label="Raiz"];
                           node[shape="rectangle"];
                           splines=polyline;
                           concentrate=true;
                           """);

                for (IStatement s : AST) {

                    str.append(s.graph());
                    str.append("rootNode -> S_").append(s.getId()).append(";\n");
                }

                str.append("}");

                //System.out.println("Graphviz:");
                //System.out.println(str);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("consola.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            txtSalida.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            txtSalida.setText("Error.");
        }

        // ---------------------------------------------------------------------------------------------------------
        // Nombre del archivo en el que quieres guardar la salida
        String fileName = "consola.txt";
        // Abre el archivo para escribir en modo de anexado
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokensActionPerformed
        // TODO add your handling code here:
        try {
            Lexer lexer = new Lexer(new StringReader(txtEntrada.getText()));
            LexerWrapper lexerWrapper = new LexerWrapper(lexer);

            Parser parser = new Parser(lexerWrapper);  // Ya no es necesario el casting
            parser.parse();

            // Generar y guardar el reporte HTML
            String htmlReport = lexerWrapper.getTokenReporter().generateHtmlReport();
            try (FileWriter writer = new FileWriter("token_report.html")) {
                writer.write(htmlReport);
            }

            System.out.println("Analisis completado. El reporte de tokens se ha guardado en 'token_report.html'.");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnTokensActionPerformed

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
            java.util.logging.Logger.getLogger(Analyzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analyzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analyzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analyzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analyzer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JMenuItem btnCargar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JMenuItem btnErrores;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnGuardarComo;
    private javax.swing.JMenuItem btnNuevoArchivo;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JMenuItem btnTokens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGrafica;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
