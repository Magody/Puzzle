/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import puzzle.MetodosAux;
import puzzle.PuzzleMecanica;

/**
 *
 * @author Usuario
 */
public class PuzzleVIsta extends javax.swing.JFrame {

    private Image imagen;
    private ArrayList<JPanel> jPanelesList = new ArrayList<>();
    private ArrayList<Image> imgList = new ArrayList<>();
    private ArrayList<Image> imgListDesorden = new ArrayList<>();
    private ArrayList<String> camino;
    private int []vec = new int[9];
    private int width = 450, cont=0, contMovim=0, piezaVacia=0, contPasos=0;
    private MetodosAux metAux = new MetodosAux();
    private PuzzleMecanica mecanica;
    int [][]matriz = new int[3][3];
    
    public PuzzleVIsta(BufferedImage img) {
        imagen = Toolkit.getDefaultToolkit().createImage(img.getSource());
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setTitle("BORJA - BURBANO - DÍAZ");
        camino = new ArrayList<>();
        jPanelesList.add(jP1);
        jPanelesList.add(jP2);
        jPanelesList.add(jP3);
        jPanelesList.add(jP4);
        jPanelesList.add(jP5);
        jPanelesList.add(jP6);
        jPanelesList.add(jP7);
        jPanelesList.add(jP8);
        jPanelesList.add(jP0);
        mecanica = new PuzzleMecanica();
        matriz = metAux.obtenerMatriz();
        vec = metAux.obtenerVector(matriz).clone();
        mecanica = new PuzzleMecanica();
        //camino.clear();
        camino = mecanica.matrizValida(matriz);
        jLIntentosOpt1.setText(String.valueOf(camino.size()));
        cambiar(img, jPOriginal);
        crearImg(imagen);
        insertarImg(imgList);
    }
    
    public class ImageFondo extends javax.swing.JPanel{
        private Image img=null;
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,150,150,null);
        }
        public void setImage(Image image){
            if (image!=null) {
                img = image;
            }
        }
    }
    
    public void crearImg(Image imagenPrincipal){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j  < 3; j++){
                if(i==2 && j==2){
                    ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fond.png"));
                    imagen = createImage(new FilteredImageSource(icon.getImage().getSource(),
                        new CropImageFilter(0, 0, 150, 150)));
                }else{
                    imagen = createImage(new FilteredImageSource(imagenPrincipal.getSource(),
                        new CropImageFilter(j*(width/3), i*(width/3) , width/3, width/3)));
                }
                imgList.add(imagen);
            }
        }
    }
    
    public void insertarImg(ArrayList imgLista){
        for(int i=0; i<9; i++){
            ImageFondo fondoClass = new ImageFondo();
            fondoClass.setImage(imgList.get(vec[i]));
            imgListDesorden.add(imgList.get(vec[i]));
            jPanelesList.get(i).add(fondoClass);
            jPanelesList.get(i).revalidate();
            jPanelesList.get(i).repaint();
        }
    }
    
    public void cambiar(Image img, JPanel panel){
        ImageFondo fondoClass = new ImageFondo();
        fondoClass.setImage(img);
        panel.removeAll();
        panel.add(fondoClass);
        panel.revalidate();
        panel.repaint();
    }
    
    public void intecambioIMG(int pos1, JPanel panel1, int pos2, JPanel panel2){
        int aux = vec[pos1];
        imagen = imgListDesorden.get(pos1);
        imgListDesorden.set(pos1, imgListDesorden.get(pos2));
        imgListDesorden.set(pos2, imagen);
        cambiar(imgListDesorden.get(pos1), panel1);
        cambiar(imgListDesorden.get(pos2), panel2);
        vec[pos2] = aux;
        vec[pos1] = piezaVacia;
    }
    
    public void comprobarEstado(int [][] m){
        if(metAux.comprobar(m)){
            JOptionPane.showMessageDialog(this, "LO LOGRASTE....", "FELICIDADES....", JOptionPane.INFORMATION_MESSAGE);
            for(int i=0; i<9; i++){
                jPanelesList.get(i).setEnabled(false);
            }
        }
    }
    
    public void moverPuzzle(int iIni, int jIni, int iFin, int jFin, 
            int posIni, int posFin, JPanel panelIni, JPanel panelFin){
        matriz = metAux.cambioPosMatriz(matriz, iIni, jIni, iFin, jFin).clone();
        intecambioIMG(posIni, panelIni, posFin, panelFin);
        contMovim++;
        comprobarEstado(matriz);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBTerminar = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLIntentos = new javax.swing.JLabel();
        jBPistas = new javax.swing.JButton();
        jLIntentosOpt1 = new javax.swing.JLabel();
        jPGame = new javax.swing.JPanel();
        jP1 = new javax.swing.JPanel();
        jP2 = new javax.swing.JPanel();
        jP3 = new javax.swing.JPanel();
        jP4 = new javax.swing.JPanel();
        jP5 = new javax.swing.JPanel();
        jP6 = new javax.swing.JPanel();
        jP7 = new javax.swing.JPanel();
        jP8 = new javax.swing.JPanel();
        jP0 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPAyuda = new javax.swing.JPanel();
        jBAyuda = new javax.swing.JButton();
        jPOriginal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLPartes = new javax.swing.JLabel();
        jLPasos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PUZZLE ...... !");

        jBTerminar.setText("TERMINAR JUEGO !");
        jBTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTerminarActionPerformed(evt);
            }
        });

        jLabel.setText("Intentos optimos :");

        jLabel3.setText("Numero de intentos :");

        jLIntentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIntentos.setText("0");

        jBPistas.setText("Pistas");
        jBPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPistasActionPerformed(evt);
            }
        });

        jLIntentosOpt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIntentosOpt1.setText("0");

        javax.swing.GroupLayout jPMenuLayout = new javax.swing.GroupLayout(jPMenu);
        jPMenu.setLayout(jPMenuLayout);
        jPMenuLayout.setHorizontalGroup(
            jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBPistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPMenuLayout.createSequentialGroup()
                        .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLIntentos, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLIntentosOpt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jBTerminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPMenuLayout.setVerticalGroup(
            jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIntentosOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLIntentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(jBTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jP1.setBackground(new java.awt.Color(153, 153, 153));
        jP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP1MouseClicked(evt);
            }
        });
        jP1.setLayout(new java.awt.GridLayout(1, 0));

        jP2.setBackground(new java.awt.Color(153, 153, 153));
        jP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP2MouseClicked(evt);
            }
        });
        jP2.setLayout(new java.awt.GridLayout(1, 0));

        jP3.setBackground(new java.awt.Color(153, 153, 153));
        jP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP3MouseClicked(evt);
            }
        });
        jP3.setLayout(new java.awt.GridLayout(1, 0));

        jP4.setBackground(new java.awt.Color(153, 153, 153));
        jP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP4MouseClicked(evt);
            }
        });
        jP4.setLayout(new java.awt.GridLayout(1, 0));

        jP5.setBackground(new java.awt.Color(153, 153, 153));
        jP5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP5MouseClicked(evt);
            }
        });
        jP5.setLayout(new java.awt.GridLayout(1, 0));

        jP6.setBackground(new java.awt.Color(153, 153, 153));
        jP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP6MouseClicked(evt);
            }
        });
        jP6.setLayout(new java.awt.GridLayout(1, 0));

        jP7.setBackground(new java.awt.Color(153, 153, 153));
        jP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP7MouseClicked(evt);
            }
        });
        jP7.setLayout(new java.awt.GridLayout(1, 0));

        jP8.setBackground(new java.awt.Color(153, 153, 153));
        jP8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP8MouseClicked(evt);
            }
        });
        jP8.setLayout(new java.awt.GridLayout(1, 0));

        jP0.setBackground(new java.awt.Color(153, 153, 153));
        jP0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP0MouseClicked(evt);
            }
        });
        jP0.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPGameLayout = new javax.swing.GroupLayout(jPGame);
        jPGame.setLayout(jPGameLayout);
        jPGameLayout.setHorizontalGroup(
            jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGameLayout.createSequentialGroup()
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jP7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
        );
        jPGameLayout.setVerticalGroup(
            jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGameLayout.createSequentialGroup()
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jP2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jP1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jP5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jP4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jP8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jP0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPAyuda.setBackground(new java.awt.Color(153, 153, 153));
        jPAyuda.setLayout(new java.awt.GridLayout(1, 0));

        jBAyuda.setText("Ayuda");
        jBAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAyudaActionPerformed(evt);
            }
        });

        jPOriginal.setBackground(new java.awt.Color(153, 153, 153));
        jPOriginal.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Imagen Original");

        jLPartes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPartes.setText("Parte 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLPartes, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLPartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLPasos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLPasos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPasos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jPGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLPasos, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAyudaActionPerformed
        if(cont==9){cont=0;}
        cambiar(imgList.get(cont), jPAyuda);
        jLPartes.setText("Parte " + (cont+1));
        cont++;
    }//GEN-LAST:event_jBAyudaActionPerformed

    private void jBTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTerminarActionPerformed
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBTerminarActionPerformed

    private void jP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP1MouseClicked
        if(matriz[0][1]==piezaVacia){  //Mover DERECHA
            moverPuzzle(0, 0, 0, 1, 0, 1, jP1, jP2);
        }
        if(matriz[1][0]==piezaVacia){  //Mover ABAJO
            moverPuzzle(0, 0, 1, 0, 0, 3, jP1, jP4);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP1MouseClicked

    private void jP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP2MouseClicked
        if(matriz[0][0]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(0, 1, 0, 0, 1, 0, jP2, jP1);
        }
        if(matriz[1][1]==piezaVacia){  //Mover ABAJO
            moverPuzzle(0, 1, 1, 1, 1, 4, jP2, jP5);
        }
        if(matriz[0][2]==piezaVacia){  //Mover DERECHA
            moverPuzzle(0, 1, 0, 2, 1, 2, jP2, jP3);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP2MouseClicked

    private void jP3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP3MouseClicked
        if(matriz[0][1]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(0, 2, 0, 1, 2, 1, jP3, jP2);
        }
        if(matriz[1][2]==piezaVacia){  //Mover ABAJO
            moverPuzzle(0, 2, 1, 2, 2, 5, jP3, jP6);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP3MouseClicked

    private void jP4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP4MouseClicked
        if(matriz[0][0]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(1, 0, 0, 0, 3, 0, jP4, jP1);
        }
        if(matriz[1][1]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(1, 0, 1, 1, 3, 4, jP4, jP5);
        }
        if(matriz[2][0]==piezaVacia){  //Mover ABAJO
            moverPuzzle(1, 0, 2, 0, 3, 6, jP4, jP7);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP4MouseClicked

    private void jP5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP5MouseClicked
        if(matriz[0][1]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(1, 1, 0, 1, 4, 1, jP5, jP2);
        }
        if(matriz[1][0]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(1, 1, 1, 0, 4, 3, jP5, jP4);
        }
        if(matriz[2][1]==piezaVacia){  //Mover ABAJO
            moverPuzzle(1, 1, 2, 1, 4, 7, jP5, jP8);
        }
        if(matriz[1][2]==piezaVacia){  //Mover DERECHA
            moverPuzzle(1, 1, 1, 2, 4, 5, jP5, jP6);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP5MouseClicked

    private void jP6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP6MouseClicked
        if(matriz[0][2]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(1, 2, 0, 2, 5, 2, jP6, jP3);
        }
        if(matriz[1][1]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(1, 2, 1, 1, 5, 4, jP6, jP5);
        }
        if(matriz[2][2]==piezaVacia){  //Mover ABAJO
            moverPuzzle(1, 2, 2, 2, 5, 8, jP6, jP0);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP6MouseClicked

    private void jP7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP7MouseClicked
        if(matriz[1][0]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(2, 0, 1, 0, 6, 3, jP7, jP4);
        }
        if(matriz[2][1]==piezaVacia){  //Mover DERECHA
            moverPuzzle(2, 0, 2, 1, 6, 7, jP7, jP8);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP7MouseClicked

    private void jP8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP8MouseClicked
        if(matriz[1][1]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(2, 1, 1, 1, 7, 4, jP8, jP5);
        }
        if(matriz[2][0]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(2, 1, 2, 0, 7, 6, jP8, jP7);
        }
        if(matriz[2][2]==piezaVacia){  //Mover DERECHA
            moverPuzzle(2, 1, 2, 2, 7, 8, jP8, jP0);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP8MouseClicked

    private void jP0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP0MouseClicked
        if(matriz[1][2]==piezaVacia){  //Mover ARRIBA
            moverPuzzle(2, 2, 1, 2, 8, 5, jP0, jP6);
        }
        if(matriz[2][1]==piezaVacia){  //Mover IZQUIERDA
            moverPuzzle(2, 2, 2, 1, 8, 7, jP0, jP8);
        }
        jLIntentos.setText(String.valueOf(contMovim));
    }//GEN-LAST:event_jP0MouseClicked

    private void jBPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPistasActionPerformed
        
        long t1, t2;
        t1 = System.currentTimeMillis();
        
        String pistas = "";
        camino = new ArrayList<>();
        mecanica = new PuzzleMecanica();
        camino = mecanica.matrizValida(matriz);
        for(int i=0; i<camino.size(); i++){
            pistas = pistas.concat(camino.get(i)+"  ");
        }
        jLPasos.setText(pistas);
        
        t2 = System.currentTimeMillis();
        System.out.println("Para "+camino.size()+"pasos restantes, Se demoró "+ ( t2 - t1 ) +" milisegundos");
    }//GEN-LAST:event_jBPistasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAyuda;
    private javax.swing.JButton jBPistas;
    private javax.swing.JButton jBTerminar;
    private javax.swing.JLabel jLIntentos;
    private javax.swing.JLabel jLIntentosOpt1;
    private javax.swing.JLabel jLPartes;
    private javax.swing.JLabel jLPasos;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jP0;
    private javax.swing.JPanel jP1;
    private javax.swing.JPanel jP2;
    private javax.swing.JPanel jP3;
    private javax.swing.JPanel jP4;
    private javax.swing.JPanel jP5;
    private javax.swing.JPanel jP6;
    private javax.swing.JPanel jP7;
    private javax.swing.JPanel jP8;
    private javax.swing.JPanel jPAyuda;
    private javax.swing.JPanel jPGame;
    private javax.swing.JPanel jPMenu;
    private javax.swing.JPanel jPOriginal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
