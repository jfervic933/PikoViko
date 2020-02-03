/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class VentanaJuego extends javax.swing.JFrame {

    private static ArrayList<Jugador> listaJugadores;
    public static int turnoJugador;
    private static final Parrilla PARRILLA = new Parrilla();
    private static final ArrayList<JLabel> LISTA_DADOS = new ArrayList<>();
    private static final ArrayList<JLabel> LISTA_RACIONES = new ArrayList<>();
    private static final ArrayList<JCheckBox> LISTA_CHECK = new ArrayList<>();

    public VentanaJuego() {
        if (inicializarListaJugadores()) {
            initComponents();
            rellenarListaDadosJLabel();
            rellenarListaRacionesJLabel();
            rellenarListaCheck();
            reiniciarJLabelRaciones();
            reiniciarJLabelDados();
            reiniciarListaCheck();

            // Inicialmente el botón seleccionar dado está deshabilitado
            this.seleccDados.setEnabled(false);
            this.jTextArea1.setEditable(false);
            this.jTextArea1.setText("Bienvenido al Juego del Piko Piko.\n"
                    + "Comienza el jugador: ... lanzando los dados...");

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
        Jugador aux = listaJugadores.get(VentanaJuego.turnoJugador);
        Dado[] tiradaJugador = aux.getTiradaDados();

        // Si la lista de seleccionados no está vacía
        if (!lista.isEmpty()) {
            // Caso de validación de que todos los dados sean iguales
            // Guardo valor del dado de ese primer elemento
            int valorDado = tiradaJugador[lista.get(0)].getCaraSeleccionada();
            System.out.println("Valor dado " + valorDado);
            for (int i : lista) {
                if (tiradaJugador[i].getCaraSeleccionada() != valorDado) {
                    System.out.println("Dados distintos");
                    return false;
                }
            }
            // Si llega aquí es que son todass las caras iguales
            // Veamos que no hayan sido seleccionadas previamente
            for (Dado d : tiradaJugador) {
                if (d.isBloqueado() && d.getCaraSeleccionada() == valorDado) {
                    System.out.println("Dado seleccionado previamente");
                    return false;
                }
            }
            return true;
        } else { // Lista vacía
            return false;
        }

    }

    private ArrayList<Integer> seleccionarDados() {
        ArrayList<Integer> listaSeleccionados = new ArrayList<>();
        JCheckBox aux;
        for (int i = 0; i < LISTA_CHECK.size(); i++) {
            aux = LISTA_CHECK.get(i);
            // Si ese check está habilitado y seleccionado
            // se guarda que ese dado está seleccionado
            if (aux.isEnabled() && aux.isSelected()) {
                listaSeleccionados.add(i);
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
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        JLabelNombreJ1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabelNombreJ2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabelNombreJ3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabelNombreJ4 = new javax.swing.JLabel();

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
                .addContainerGap(49, Short.MAX_VALUE))
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Terminar turno");

        jButton2.setText("Coger ración");

        jButton3.setText("Robar ración");

        jButton4.setText("Devolver ración");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addComponent(jButton2)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setText("Jugador 1");

        JLabelNombreJ1.setText("J1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(JLabelNombreJ1)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(JLabelNombreJ1))
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("Jugador 2");

        jLabelNombreJ2.setText("J2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombreJ2)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabelNombreJ2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("Jugador 3");

        jLabelNombreJ3.setText("J3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombreJ3)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabelNombreJ3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setText("Jugador 4");

        jLabelNombreJ4.setText("J4");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombreJ4)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabelNombreJ4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(245, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(394, 394, 394)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lanzarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarDadosActionPerformed
        // Selecciona al jugador que le toca
        Jugador jugadorAux = listaJugadores.get(VentanaJuego.turnoJugador);
        // Tira los dados
        jugadorAux.tirarDados();
        // Recorre los ocho dados
        for (int i = 0; i < jugadorAux.getTiradaDados().length; i++) {
            // Obtengo cada dado
            Dado dadoAux = jugadorAux.getTiradaDados()[i];
            // Si ese dado no está bloqueado, cambio la imagen por la nueva
            if (!dadoAux.isBloqueado()) {
                LISTA_DADOS.get(i).setIcon(dadoAux.getImagen());
            }
        }
        // Se deshabilita el botón lanzar dados hasta que seleccione dados
        // o termine el turno
        this.lanzarDados.setEnabled(false);
        // Se habilita el botón de seleccionar dados
        this.seleccDados.setEnabled(true);
        // Muestra el mensaje de ayuda
        this.jTextArea1.setText("Ahora debes seleccionar dados o terminar tu turno...");
    }//GEN-LAST:event_lanzarDadosActionPerformed

    private void seleccDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccDadosActionPerformed
        // Selecciona al jugador que le toca
        Jugador aux = listaJugadores.get(VentanaJuego.turnoJugador);
        // Guarda en una lista los datos marcados en los checkbox
        ArrayList<Integer> listaDadosSeleccionados = seleccionarDados();
        // Valida esa lista para ver si no hay dados con distinto valor
        if (validarListaDadosSeleccionados(listaDadosSeleccionados)) {
            this.jTextArea1.setText("Selección de dados válida...\n"
                    + "Ahora puedes:\n"
                    + "\tA - Volver a lanzar dados\n"
                    + "\tB - Coger una ración\n"
                    + "\tC - Robar una ración\n"
                    + "\tD - Terminar tu turno");
            // Hay que bloquear esos dados seleccionados
            for (int i : listaDadosSeleccionados) {
                // Bloqueo el dado
                aux.getTiradaDados()[i].bloquear();
                // Deshabilito el label
                deshabilitarDado(i);
            }
            // Se habilita el botón para lanzar dados
            this.lanzarDados.setEnabled(true);
            // Se deshabilita el botón de selección de dados
            this.seleccDados.setEnabled(false);
        } else {
            if (aux.todosBloqueados()) {
                this.jTextArea1.setText("No te quedan dados. Debes"
                        + "\tA - Coger una ración\n"
                        + "\tB - Robar una ración\n"
                        + "\tC - Terminar tu turno");
            } else {
                this.jTextArea1.setText("No has seleccionado dados o "
                        + "tu selección de dados NO es válida...\n"
                        + "Ahora puedes:\n"
                        + "\tA - Hacer una nueva selección\n"
                        + "\tB - Coger una ración\n"
                        + "\tC - Robar una ración\n"
                        + "\tD - Terminar tu turno");
            }
        }
    }//GEN-LAST:event_seleccDadosActionPerformed

    private void deshabilitarDado(int i) {
        switch (i) {
            case 0:
                this.jLabel18.setEnabled(false);
                this.jCheckBox1.setEnabled(false);
                break;
            case 1:
                this.jLabel19.setEnabled(false);
                this.jCheckBox2.setEnabled(false);
                break;
            case 2:
                this.jLabel20.setEnabled(false);
                this.jCheckBox3.setEnabled(false);
                break;
            case 3:
                this.jLabel21.setEnabled(false);
                this.jCheckBox4.setEnabled(false);
                break;
            case 4:
                this.jLabel22.setEnabled(false);
                this.jCheckBox5.setEnabled(false);
                break;
            case 5:
                this.jLabel23.setEnabled(false);
                this.jCheckBox6.setEnabled(false);
                break;
            case 6:
                this.jLabel24.setEnabled(false);
                this.jCheckBox7.setEnabled(false);
                break;
            case 7:
                this.jLabel25.setEnabled(false);
                this.jCheckBox8.setEnabled(false);
                break;

        }
    }

    // Añade todos los JCheckBox a una lista
    private void rellenarListaCheck() {
        LISTA_CHECK.add(jCheckBox1);
        LISTA_CHECK.add(jCheckBox2);
        LISTA_CHECK.add(jCheckBox3);
        LISTA_CHECK.add(jCheckBox4);
        LISTA_CHECK.add(jCheckBox5);
        LISTA_CHECK.add(jCheckBox6);
        LISTA_CHECK.add(jCheckBox7);
        LISTA_CHECK.add(jCheckBox8);
    }

    // Establece todos los checkbox sin seleccionar
    private void reiniciarListaCheck() {
        for (JCheckBox aux : LISTA_CHECK) {
            aux.setSelected(false);
        }
    }

    // Añade todos los JLabel de los dados a una lista de JLabel
    private void rellenarListaDadosJLabel() {
        LISTA_DADOS.add(jLabel18);
        LISTA_DADOS.add(jLabel19);
        LISTA_DADOS.add(jLabel20);
        LISTA_DADOS.add(jLabel21);
        LISTA_DADOS.add(jLabel22);
        LISTA_DADOS.add(jLabel23);
        LISTA_DADOS.add(jLabel24);
        LISTA_DADOS.add(jLabel25);
    }

    // Establece a cada JLabel del dado su imagen inicial para comenzar el juego
    private void reiniciarJLabelDados() {
        ImageIcon icon = new ImageIcon("resources/carauno.png");
        for (JLabel aux : LISTA_DADOS) {
            aux.setIcon(icon);
            aux.setText("");
        }
    }

    // Añade todos los JLabel de las raciones a una lista de JLabel
    private void rellenarListaRacionesJLabel() {
        LISTA_RACIONES.add(jLabel2);
        LISTA_RACIONES.add(jLabel3);
        LISTA_RACIONES.add(jLabel4);
        LISTA_RACIONES.add(jLabel5);
        LISTA_RACIONES.add(jLabel6);
        LISTA_RACIONES.add(jLabel7);
        LISTA_RACIONES.add(jLabel8);
        LISTA_RACIONES.add(jLabel9);
        LISTA_RACIONES.add(jLabel10);
        LISTA_RACIONES.add(jLabel11);
        LISTA_RACIONES.add(jLabel12);
        LISTA_RACIONES.add(jLabel13);
        LISTA_RACIONES.add(jLabel14);
        LISTA_RACIONES.add(jLabel15);
        LISTA_RACIONES.add(jLabel16);
        LISTA_RACIONES.add(jLabel17);
    }

    // Establece las imágenes de cada ración en el JLabel correspondiente
    private void reiniciarJLabelRaciones() {
        for (int i = 0; i < Parrilla.NUMERO_RACIONES; i++) {
            JLabel labelAux = LISTA_RACIONES.get(i);
            labelAux.setText("");
            labelAux.
                    setIcon(PARRILLA.getRacionParrilla(i + Parrilla.VALOR_RACION_INICIAL).getImagen());

        }
    }
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Programa principal = new Programa();
//                principal.setBounds(500, 100, 1100, 800);
//                principal.setResizable(false);
//                principal.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelNombreJ1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNombreJ2;
    private javax.swing.JLabel jLabelNombreJ3;
    private javax.swing.JLabel jLabelNombreJ4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton lanzarDados;
    private javax.swing.JButton seleccDados;
    // End of variables declaration//GEN-END:variables

}
