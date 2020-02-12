/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class VentanaJuego extends javax.swing.JFrame {

    private TurnoJugadores gestorTurnos;
    private static final Parrilla PARRILLA = new Parrilla();
    private static final ArrayList<JLabel> LISTA_DADOS = new ArrayList<>();
    private static final ArrayList<JLabel> LISTA_RACIONES = new ArrayList<>();
    private static final ArrayList<JCheckBox> LISTA_CHECK = new ArrayList<>();
    private static final ArrayList<JLabel> LISTA_NOMBRES_JUGADORES = new ArrayList<>();

    public VentanaJuego() {
        gestorTurnos = new TurnoJugadores(inicializarListaJugadores());
        // Si hay jugadores en la lista
        if (!gestorTurnos.getListaJugadores().isEmpty()) {
            // Crea y establece posición de los componentes gráficos en la
            // ventana
            initComponents();
            // Los siguientes métodos agregan ciertos componentes gráficos
            // a distintas listas para que luego sea más cómodo trabajar con 
            // dichos componentes
            rellenarListaDadosJLabel();
            rellenarListaRacionesJLabel();
            rellenarListaCheck();
            rellenarListaNombresJugadoresJLabel();
            reiniciarListaNombresJugadoresJLabel();
            reiniciarJLabelRaciones();
            reiniciarJLabelDados();
            reiniciarListaCheck();
            // Inicialmente el botón seleccionar dado está deshabilitado
            this.seleccDados.setEnabled(false);
            // En el textArea no se puede escribir
            this.jTextArea1.setEditable(false);
            // Mensaje inicial
            this.jTextArea1.setText("Bienvenido al Juego del Piko Piko.\n"
                    + "Comienza el jugador: ... " + gestorTurnos.getJugadorTurno().getNombre()
                    + " lanzando los dados...");
            this.jLabel42.setText("");
            this.jLabel43.setText("");
            this.jLabel44.setText("");
            this.jLabel45.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Ha cancelado, hasta pronto");
            System.exit(0);
        }
    }

    // Este método enseña un diálogo para escoger número de jugadores y devuelve
    // el dato seleccionado
    public static int pedirNumeroJugadores() {
        Integer[] numero = {2, 3, 4};

        Integer opcion = (Integer) JOptionPane.showInputDialog(null, "Selecciona número de jugadores", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, numero, numero[0]);

        return opcion == null ? 0 : opcion;

    }

    // Este método inicializa la lista de jugadores, en función del número
    // de jugadores elegidos. Devuelve true si se inicializa la lista correct.
    // 
    private ArrayList<Jugador> inicializarListaJugadores() {
        int numeroJugadores = pedirNumeroJugadores();
        ArrayList<Jugador> listaJug = new ArrayList<>();;
        // Si hay dos o más jugadores
        if (numeroJugadores > 0) {
            String nombre;
            for (int i = 0; i < numeroJugadores; i++) {
                nombre = JOptionPane.showInputDialog("Introduce tu nombre Jugador " + (i + 1));
                listaJug.add(new Jugador(nombre));
            }
        }
        // Si no hay jugadores la lista se devuelve vacía
        return listaJug;
    }

    // Este método devuelve false en caso de que la lista de dados
    // contenga valores distintos o bien ya haya sido seleccionado ese valor
    private boolean validarListaDadosSeleccionados(ArrayList<Integer> lista) {
        //Jugador aux = listaJugadores.get(VentanaJuego.turnoJugador);
        Jugador aux = this.gestorTurnos.getJugadorTurno();
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
        jButtonTerminarTurno = new javax.swing.JButton();
        jButtonCogerRacion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabelNombreJ1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabelNombreJ2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabelNombreJ3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabelNombreJ4 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();

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
                .addContainerGap(57, Short.MAX_VALUE))
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

        jButtonTerminarTurno.setText("Terminar turno");
        jButtonTerminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarTurnoActionPerformed(evt);
            }
        });

        jButtonCogerRacion.setText("Coger ración");
        jButtonCogerRacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCogerRacionActionPerformed(evt);
            }
        });

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
                        .addComponent(jButtonTerminarTurno)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addComponent(jButtonCogerRacion)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTerminarTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCogerRacion)
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

        jLabelNombreJ1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombreJ1.setText("J1");

        jLabel30.setText("Valor acumulado: ");

        jLabel31.setText("jLabel31");

        jLabel38.setText("Última ración visible:");

        jLabel42.setText("jLabel42");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNombreJ1))
                            .addComponent(jLabel38))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabelNombreJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("Jugador 2");

        jLabelNombreJ2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombreJ2.setText("J2");

        jLabel32.setText("Valor acumulado:");

        jLabel33.setText("jLabel33");

        jLabel39.setText("Última ración visible:");

        jLabel43.setText("jLabel43");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNombreJ2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33))
                            .addComponent(jLabel39)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabelNombreJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("Jugador 3");

        jLabelNombreJ3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombreJ3.setText("J3");

        jLabel34.setText("Valor acumulado:");

        jLabel35.setText("jLabel35");

        jLabel40.setText("Última ración visible:");

        jLabel44.setText("jLabel44");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNombreJ3))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35))
                            .addComponent(jLabel40)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel44)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabelNombreJ3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setText("Jugador 4");

        jLabelNombreJ4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombreJ4.setText("J4");

        jLabel36.setText("Valor acumulado:");

        jLabel37.setText("jLabel37");

        jLabel41.setText("Última ración visible:");

        jLabel45.setText("jLabel45");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNombreJ4))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37))
                            .addComponent(jLabel41)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel45)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabelNombreJ4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
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
                        .addContainerGap(169, Short.MAX_VALUE))
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
        //  Jugador jugadorAux = listaJugadores.get(VentanaJuego.turnoJugador);
        Jugador jugadorAux = this.gestorTurnos.getJugadorTurno();

        // Tira los dados
        jugadorAux.tirarDados();

        // OJO AQUI HAY QUE COMPROBAR TIRADA FALLIDA SI LOS DADOS NO BLOQUEADOS SALEN IGUALES
        // QUE LOS BLOQUEADOS -------------------------------------------
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
        Jugador aux = this.gestorTurnos.getJugadorTurno();
        System.out.println("Turno de " + aux.getNombre());

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
                aux.seleccionarDado(i);

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
        // Mostrar valor acumulado en el jlabel correspondiente
        mostrarValorAcumuladoDadosJugadorJLabel(gestorTurnos.getOrdenJugador(), gestorTurnos.getJugadorTurno());
    }//GEN-LAST:event_seleccDadosActionPerformed

    private void establecerRacionJugadorJLabel(Jugador jugador) {
        // Esto devuelve 0,1,2,3 dependiendo del jugador que esté en su turno
        int ordenJugador = gestorTurnos.getOrdenJugador();
        ImageIcon imagen = jugador.getMisRaciones().consultarUltimaRacion().getImagen();
        switch (ordenJugador) {
            case 0:
                this.jLabel42.setIcon(imagen);
                break;
            case 1:
                this.jLabel43.setIcon(imagen);
                break;
            case 2:
                this.jLabel44.setIcon(imagen);
                break;
            case 3:
                this.jLabel45.setIcon(imagen);
                break;
        }
    }
    private void jButtonCogerRacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCogerRacionActionPerformed

        // Selecciona al jugador que le toca
        Jugador jugadorAux = this.gestorTurnos.getJugadorTurno();
        System.out.println("Coger ración. Turno de " + jugadorAux.getNombre());
        if (jugadorAux.tieneGusano()) {
            System.out.println("El jugador tiene al menos un gusano en su poder");

            // AQUI HAY QUE CONTROLAR QUE COINCIDA EXACTAMENTE CON UNA RACION DE LA PARRILLA
            // O PUEDE QUE EL JUGADOR SE HAYA PLANTADO Y TENGA QUE COGER LA
            // RACION DE MENOR VALOR DISPONIBLE
            // El jugador coge la ración y la pone en su pila
            if (jugadorAux.cogerRacion(PARRILLA, PARRILLA.getRacionParrilla(jugadorAux.getValorSeleccionados()))) {
                // Imprimo las raciones que tiene el jugador
                System.out.println("EL JUGADOR " + jugadorAux.getNombre() + " tiene las raciones");
                jugadorAux.listaRac.forEach(System.out::println);
                // Se deshabilita el jlabel de la ración cogida
                int valorJLabel = jugadorAux.getValorSeleccionados() % Parrilla.VALOR_RACION_INICIAL;
                LISTA_RACIONES.get(valorJLabel).setEnabled(false);
                // Se pone la última ración del jugador en JLabel de sus raciones
                establecerRacionJugadorJLabel(jugadorAux);
                // Ahora el jugador tiene que terminar el turno
                gestorTurnos.pasarSiguiente();
                reiniciarJLabelDados();
                reiniciarListaCheck();
                this.lanzarDados.setEnabled(true);
                this.seleccDados.setEnabled(false);
                jTextArea1.setText("Turno de: " + gestorTurnos.getJugadorTurno().getNombre());
                reiniciarJLabelValorAcumulado();
            } else {
                jTextArea1.setText("Imposible coger ración");
            }

        } else {
            System.out.println("Probablemente no puedas coger ración");
        }

    }//GEN-LAST:event_jButtonCogerRacionActionPerformed

    private void jButtonTerminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarTurnoActionPerformed
        Jugador jugador = gestorTurnos.getJugadorTurno();
        System.out.println("Numero de raciones en la pila de " + jugador.getNombre() + " -- " +
                jugador.getMisRaciones().numeroRaciones());
        if (jugador.getMisRaciones().numeroRaciones()> 0) {
            jTextArea1.setText("Debes devolver una ración");
            System.out.println("Devolver ración ------------");
        } else {
            gestorTurnos.pasarSiguiente();
            reiniciarJLabelDados();
            reiniciarListaCheck();
            this.lanzarDados.setEnabled(true);
            this.seleccDados.setEnabled(false);
            jTextArea1.setText("Turno de: " + gestorTurnos.getJugadorTurno().getNombre());
        }
    }//GEN-LAST:event_jButtonTerminarTurnoActionPerformed

    public void mostrarValorAcumuladoDadosJugadorJLabel(int ordenJugador, Jugador aux) {
        int valorDadosSeleccionados = aux.getValorSeleccionados();
        switch (ordenJugador) {
            case 0:
                jLabel31.setText(String.valueOf(valorDadosSeleccionados));
                break;
            case 1:
                jLabel33.setText(String.valueOf(valorDadosSeleccionados));
                break;
            case 2:
                jLabel35.setText(String.valueOf(valorDadosSeleccionados));
                break;
            case 3:
                jLabel37.setText(String.valueOf(valorDadosSeleccionados));
        }
    }

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

    // Añade todos los JLabel de los nombres de los jugadores
    // a una lista de JLabel
    private void rellenarListaNombresJugadoresJLabel() {
        LISTA_NOMBRES_JUGADORES.add(jLabelNombreJ1);
        LISTA_NOMBRES_JUGADORES.add(jLabelNombreJ2);
        LISTA_NOMBRES_JUGADORES.add(jLabelNombreJ3);
        LISTA_NOMBRES_JUGADORES.add(jLabelNombreJ4);
    }

    // Este método establece los nombres de los jugadores en los respectivos
    // JLabel
    private void reiniciarListaNombresJugadoresJLabel() {
        for (int i = 0; i < gestorTurnos.getListaJugadores().size(); i++) {
            LISTA_NOMBRES_JUGADORES.get(i).setText(gestorTurnos.getListaJugadores().get(i).getNombre());
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
            aux.setEnabled(true);
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
            aux.setEnabled(true);
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

    private void reiniciarJLabelValorAcumulado(){
        this.jLabel31.setText("");
        this.jLabel33.setText("");
        this.jLabel35.setText("");
        this.jLabel37.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCogerRacion;
    private javax.swing.JButton jButtonTerminarTurno;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNombreJ1;
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
