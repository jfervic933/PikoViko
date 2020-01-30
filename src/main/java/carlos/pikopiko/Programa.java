/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class Programa extends javax.swing.JFrame {

    private static ArrayList<Jugador> listaJugadores;
    public static int turnoJugador;

    public Programa() {
        if (inicializarListaJugadores()) {
            initComponents();
            reiniciarRaciones();
            reiniciarDados();
        } else {
            JOptionPane.showMessageDialog(null, "Ha cancelado, hasta pronto");
            System.exit(0);
        }

    }

    // Este método enseña un diálogo para escoger número de jugadores y devuelve
    // el dato seleccionado
    private int numeroJugadores() {
        Integer[] numero = {2, 3, 4};

        Integer opcion = (Integer) JOptionPane.showInputDialog(null, "Selecciona número de jugadores", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, numero, numero[0]);

        return opcion == null ? 0 : opcion;

    }

    // Este método inicializa la lista de jugadores, en función del número
    // de jugadores elegidos. Devuelve true si se inicializa la lista correct.
    // 
    private boolean inicializarListaJugadores() {
        int numeroJugadores = numeroJugadores();
        // Si hay dos o más jugadores
        if (numeroJugadores != 0) {
            listaJugadores = new ArrayList<>();
            String nombre;
            for (int i = 0; i < numeroJugadores; i++) {
                nombre = JOptionPane.showInputDialog("Introduce tu nombre Jugador " + i + 1);
                listaJugadores.add(new Jugador(nombre));
            }
            // Aleatoriamente selecciono uno para que comience su turno
            Random aux = new Random();
            turnoJugador = aux.nextInt(listaJugadores.size());
            listaJugadores.get(turnoJugador).setTurno(true);
            return true;
        }
        // Si no hay jugadores
        return false;
    }
    
    // Este método devuelve false en caso de que la lista de dados
    // contenga valores distintos o bien ya haya sido seleccionado ese valor
    private boolean validarListaDadosSeleccionados(ArrayList<Integer> lista) {
        Jugador aux = listaJugadores.get(Programa.turnoJugador);
        Dado[] tiradaJugador = aux.getTiradaDados();
               
        // Si la lista de seleccionados no está vacía
        if (!lista.isEmpty()){
            // Caso de validación de que todos los dados sean iguales
            // Guardo valor del dado de ese primer elemento
            int valorDado = tiradaJugador[lista.get(0)].getCaraSeleccionada();
            System.out.println("Valor dado " + valorDado);
            for(int i: lista){
                if (tiradaJugador[i].getCaraSeleccionada()!=valorDado){
                    System.out.println("Dados distintos");
                    return false;
                }
            }
            // Si llega aquí es que son todass las caras iguales
            // Veamos que no hayan sido seleccionadas previamente
            for(Dado d:tiradaJugador){
                if (d.isBloqueado() && d.getCaraSeleccionada()==valorDado){
                    System.out.println("Dado seleccionado previamente");
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<Integer> seleccionarDados() {
        ArrayList<Integer> listaSeleccionados = new ArrayList<>();

        if (this.jCheckBox1.isEnabled()) {
            if (jCheckBox1.isSelected()) {
                listaSeleccionados.add(0);
            }
        }
        if (this.jCheckBox2.isEnabled()) {
            if (jCheckBox2.isSelected()) {
                listaSeleccionados.add(1);
            }
        }
        if (this.jCheckBox3.isEnabled()) {
            if (jCheckBox3.isSelected()) {
                listaSeleccionados.add(2);
            }
        }
        if (this.jCheckBox4.isEnabled()) {
            if (jCheckBox4.isSelected()) {
                listaSeleccionados.add(3);
            }
        }
        if (this.jCheckBox5.isEnabled()) {
            if (jCheckBox5.isSelected()) {
                listaSeleccionados.add(4);
            }
        }
        if (this.jCheckBox6.isEnabled()) {
            if (jCheckBox6.isSelected()) {
                listaSeleccionados.add(5);
            }
        }
        if (this.jCheckBox7.isEnabled()) {
            if (jCheckBox7.isSelected()) {
                listaSeleccionados.add(6);
            }
        }
        if (this.jCheckBox8.isEnabled()) {
            if (jCheckBox8.isSelected()) {
                listaSeleccionados.add(7);
            }
        }
        return listaSeleccionados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lanzarDados = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        seleccDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("JUEGO PIKO PIKO");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        jLabel24.setText("jLabel24");

        jLabel25.setText("jLabel25");

        lanzarDados.setText("Lanzar dados");
        lanzarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzarDadosActionPerformed(evt);
            }
        });

        seleccDados.setText("Seleccionar dados");
        seleccDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jCheckBox6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jCheckBox7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel25))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seleccDados)
                    .addComponent(lanzarDados, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lanzarDados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seleccDados))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(552, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lanzarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarDadosActionPerformed
        // Selecciona al jugador que le toca
        Jugador aux = listaJugadores.get(Programa.turnoJugador);
        // Tira los dados
        aux.tirarDados();
        // Se actualizan los iconos de los dados no seleccionados
        if (!aux.getTiradaDados()[0].isBloqueado()) {
            this.jLabel18.setIcon((aux.getTiradaDados()[0].getImagen()));
        }
        if (!aux.getTiradaDados()[1].isBloqueado()) {
            this.jLabel19.setIcon((aux.getTiradaDados()[1].getImagen()));
        }
        if (!aux.getTiradaDados()[2].isBloqueado()) {
            this.jLabel20.setIcon((aux.getTiradaDados()[2].getImagen()));
        }
        if (!aux.getTiradaDados()[3].isBloqueado()) {
            this.jLabel21.setIcon((aux.getTiradaDados()[3].getImagen()));
        }
        if (!aux.getTiradaDados()[4].isBloqueado()) {
            this.jLabel22.setIcon((aux.getTiradaDados()[4].getImagen()));
        }
        if (!aux.getTiradaDados()[5].isBloqueado()) {
            this.jLabel23.setIcon((aux.getTiradaDados()[5].getImagen()));
        }
        if (!aux.getTiradaDados()[6].isBloqueado()) {
            this.jLabel24.setIcon((aux.getTiradaDados()[6].getImagen()));
        }
        if (!aux.getTiradaDados()[7].isBloqueado()) {
            this.jLabel25.setIcon((aux.getTiradaDados()[7].getImagen()));
        }
    
    }//GEN-LAST:event_lanzarDadosActionPerformed

    private void seleccDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccDadosActionPerformed
        // Selecciona al jugador que le toca
        Jugador aux = listaJugadores.get(Programa.turnoJugador);
        // Guarda en una lista los datos marcados en los checkbox
        ArrayList<Integer> listaDadosSeleccionados = seleccionarDados();
        // Valida esa lista para ver si no hay dados con distinto valor
        for(int i:listaDadosSeleccionados){
            System.out.println("Dado " + (i+1));
        }
        
        System.out.println(validarListaDadosSeleccionados(listaDadosSeleccionados));
    }//GEN-LAST:event_seleccDadosActionPerformed

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
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Programa principal = new Programa();
                principal.setBounds(500, 100, 1100, 800);
                principal.setResizable(false);
                principal.setVisible(true);
            }
        });
    }

    private void reiniciarRaciones() {
        jLabel2.setText("");
        jLabel2.setIcon(Racion.R21.getImagen());
        jLabel3.setText("");
        jLabel3.setIcon(Racion.R22.getImagen());
        jLabel4.setText("");
        jLabel4.setIcon(Racion.R23.getImagen());
        jLabel5.setText("");
        jLabel5.setIcon(Racion.R24.getImagen());
        jLabel6.setText("");
        jLabel6.setIcon(Racion.R25.getImagen());
        jLabel7.setText("");
        jLabel7.setIcon(Racion.R26.getImagen());
        jLabel8.setText("");
        jLabel8.setIcon(Racion.R27.getImagen());
        jLabel9.setText("");
        jLabel9.setIcon(Racion.R28.getImagen());
        jLabel10.setText("");
        jLabel10.setIcon(Racion.R29.getImagen());
        jLabel11.setText("");
        jLabel11.setIcon(Racion.R30.getImagen());
        jLabel12.setText("");
        jLabel12.setIcon(Racion.R31.getImagen());
        jLabel13.setText("");
        jLabel13.setIcon(Racion.R32.getImagen());
        jLabel14.setText("");
        jLabel14.setIcon(Racion.R33.getImagen());
        jLabel15.setText("");
        jLabel15.setIcon(Racion.R34.getImagen());
        jLabel16.setText("");
        jLabel16.setIcon(Racion.R35.getImagen());
        jLabel17.setText("");
        jLabel17.setIcon(Racion.R36.getImagen());
    }

    private void reiniciarDados() {
        ImageIcon icon = new ImageIcon("resources/carauno.png");
        this.jLabel18.setIcon(icon);
        this.jLabel18.setText("");
        this.jLabel19.setIcon(icon);
        this.jLabel19.setText("");
        this.jLabel20.setIcon(icon);
        this.jLabel20.setText("");
        this.jLabel21.setIcon(icon);
        this.jLabel21.setText("");
        this.jLabel22.setIcon(icon);
        this.jLabel22.setText("");
        this.jLabel23.setIcon(icon);
        this.jLabel23.setText("");
        this.jLabel24.setIcon(icon);
        this.jLabel24.setText("");
        this.jLabel25.setIcon(icon);
        this.jLabel25.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lanzarDados;
    private javax.swing.JButton seleccDados;
    // End of variables declaration//GEN-END:variables
}
