/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author carlos
 */
public class PanelDados extends javax.swing.JPanel {

    /**
     * Creates new form DadosTirada
     */
    public PanelDados() {
        
        initComponents();
        reiniciarLabels();
    }

    private void reiniciarLabels() {
        ImageIcon icon = new ImageIcon("resources/carauno.png");
        this.jLabel1.setIcon(icon);
        this.jLabel1.setText("");
        this.jLabel2.setIcon(icon);
        this.jLabel2.setText("");
        this.jLabel3.setIcon(icon);
        this.jLabel3.setText("");
        this.jLabel4.setIcon(icon);
        this.jLabel4.setText("");
        this.jLabel5.setIcon(icon);
        this.jLabel5.setText("");
        this.jLabel6.setIcon(icon);
        this.jLabel6.setText("");
        this.jLabel7.setIcon(icon);
        this.jLabel7.setText("");
        this.jLabel8.setIcon(icon);
        this.jLabel8.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButtonLanzar = new javax.swing.JButton();
        jButtonSeleccionarDados = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jCheckBox1.setText("1");

        jCheckBox2.setText("2");

        jButtonLanzar.setText("Lanzar");
        jButtonLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLanzarActionPerformed(evt);
            }
        });

        jButtonSeleccionarDados.setText("Seleccionar");
        jButtonSeleccionarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarDadosActionPerformed(evt);
            }
        });

        jCheckBox3.setText("3");

        jCheckBox4.setText("4");

        jCheckBox5.setText("5");

        jCheckBox6.setText("6");

        jCheckBox7.setText("7");

        jCheckBox8.setText("8");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonSeleccionarDados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(jButtonLanzar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jButtonLanzar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jButtonSeleccionarDados)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLanzarActionPerformed

        // Selecciona al jugador que le toca
        Jugador aux = Programa.getListaJugadores().get(Programa.turnoJugador);
        // Tira los dados
        aux.tirarDados();
        // Se actualizan los iconos de los dados no seleccionados
        if (!aux.getTiradaDados()[0].isBloqueado()) {
           this.jLabel1.setIcon((aux.getTiradaDados()[0].getImagen()));
        }
        if (!aux.getTiradaDados()[1].isBloqueado()) {
           this.jLabel2.setIcon((aux.getTiradaDados()[1].getImagen()));
        }
        if (!aux.getTiradaDados()[2].isBloqueado()) {
           this.jLabel3.setIcon((aux.getTiradaDados()[2].getImagen()));
        }
        if (!aux.getTiradaDados()[3].isBloqueado()) {
           this.jLabel4.setIcon((aux.getTiradaDados()[3].getImagen()));
        }
        if (!aux.getTiradaDados()[4].isBloqueado()) {
           this.jLabel5.setIcon((aux.getTiradaDados()[4].getImagen()));
        }
        if (!aux.getTiradaDados()[5].isBloqueado()) {
           this.jLabel6.setIcon((aux.getTiradaDados()[5].getImagen()));
        }
        if (!aux.getTiradaDados()[6].isBloqueado()) {
           this.jLabel7.setIcon((aux.getTiradaDados()[6].getImagen()));
        }
        if (!aux.getTiradaDados()[7].isBloqueado()) {
           this.jLabel8.setIcon((aux.getTiradaDados()[7].getImagen()));
        }
        System.out.println("Dados Seleccionados: ");
        for (int i = 0; i < aux.getTiradaDados().length; i++) {
            System.out.println(aux.getTiradaDados()[i].isBloqueado());
        }
    }//GEN-LAST:event_jButtonLanzarActionPerformed

    private void jButtonSeleccionarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarDadosActionPerformed
        Jugador aux = Programa.getListaJugadores().get(Programa.turnoJugador);
        ArrayList<Integer> listaDadosSeleccionados = seleccionarDados();
//        if (listaDadosSeleccionadosEsValida(listaDadosSeleccionados)){
//            System.out.println("Dados validos");
//        }
//        else{
//            System.out.println("Dados no validos");
//        }
        
    }//GEN-LAST:event_jButtonSeleccionarDadosActionPerformed
    private ArrayList<Integer> seleccionarDados(){
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
//    private boolean listaDadosSeleccionadosEsValida(ArrayList<Integer> lista) {
//        Jugador aux = Programa.getListaJugadores().get(Programa.turnoJugador);
//        int[] tiradas = aux.getTiradaDados();
//        if(!lista.isEmpty()){
//            int valor = tiradas[lista.get(0)];
//            for (Integer i:lista){
//                if (tiradas[i]!=valor){
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLanzar;
    private javax.swing.JButton jButtonSeleccionarDados;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
