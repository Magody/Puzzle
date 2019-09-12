/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PuzzleMecanica {
    
    int[][] matriz_objetivo = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int cota_g = 100;
    int cantidad_pasos = 10000000;
    ArrayList<String> camino_final;
    ArrayList<String> caminoOpt = new ArrayList<String>();

    public PuzzleMecanica() {
        camino_final = new ArrayList<>();
    }
    
    public ArrayList<String> matrizValida(int [][] matriz){
        ArrayList<String> camino = new ArrayList<>();
        int[] pos_cero = obtenerPosicionVacio(matriz);
        generaArbol(matriz, camino, -1, pos_cero[0], pos_cero[1], 4, 1);
        for (String l : camino_final) {
                if (l.compareToIgnoreCase("0") == 0) {
                    caminoOpt.add("↓");
                } else if (l.compareToIgnoreCase("1") == 0) {
                    caminoOpt.add("←");
                } else if (l.compareToIgnoreCase("2") == 0) {
                    caminoOpt.add("↑");
                } else if (l.compareToIgnoreCase("3") == 0) {
                    caminoOpt.add("→");
                }
          }
        return caminoOpt;
    }
    
    public void generaArbol(int[][] matriz_actual, ArrayList<String> camino, int direccion_anterior, 
            int pos_cero_i, int pos_cero_j, int cota, int nivel) {
        if (obtenerFallos(matriz_actual) == 0) {
            cota_g = cota;
            cantidad_pasos = camino.size();
            camino_final = new ArrayList<>(camino);
            return;
        }else if(nivel >1000){
            JOptionPane.showMessageDialog(null, "El problema no se puede resolver");
        }
        int[] fallos = {100, 100, 100, 100};
        int[][][] matrices = {new int[matriz_actual.length][matriz_actual[0].length], new int[matriz_actual.length][matriz_actual[0].length], new int[matriz_actual.length][matriz_actual[0].length], new int[matriz_actual.length][matriz_actual[0].length]};
        if (sePuedeMover(0, direccion_anterior, pos_cero_i, pos_cero_j)) {
            copiarMatriz(matrices[0], matriz_actual);
            int aux = matrices[0][pos_cero_i - 1][pos_cero_j];
            matrices[0][pos_cero_i - 1][pos_cero_j] = 0;
            matrices[0][pos_cero_i][pos_cero_j] = aux;
            fallos[0] = obtenerFallos(matrices[0]);
        }
        if (sePuedeMover(1, direccion_anterior, pos_cero_i, pos_cero_j)) {
            copiarMatriz(matrices[1], matriz_actual);
            int aux = matrices[1][pos_cero_i][pos_cero_j + 1];
            matrices[1][pos_cero_i][pos_cero_j + 1] = 0;
            matrices[1][pos_cero_i][pos_cero_j] = aux;
            fallos[1] = obtenerFallos(matrices[1]);
        }
        if (sePuedeMover(2, direccion_anterior, pos_cero_i, pos_cero_j)) {
            copiarMatriz(matrices[2], matriz_actual);
            int aux = matrices[2][pos_cero_i + 1][pos_cero_j];
            matrices[2][pos_cero_i + 1][pos_cero_j] = 0;
            matrices[2][pos_cero_i][pos_cero_j] = aux;
            fallos[2] = obtenerFallos(matrices[2]);
        }
        if (sePuedeMover(3, direccion_anterior, pos_cero_i, pos_cero_j)) {
            copiarMatriz(matrices[3], matriz_actual);
            int aux = matrices[3][pos_cero_i][pos_cero_j - 1];
            matrices[3][pos_cero_i][pos_cero_j - 1] = 0;
            matrices[3][pos_cero_i][pos_cero_j] = aux;
            fallos[3] = obtenerFallos(matrices[3]);
        }
        int minimo = valorMinimoVector(fallos);
        ArrayList<String> camino_local = new ArrayList<>(camino);
        for (int i = 0; i < 4; i++) {
            if (fallos[i] == minimo && (minimo + nivel) < cota_g && cantidad_pasos > camino_local.size()) {
                int[] pos_cero = obtenerPosicionVacio(matrices[i]);
                camino.add("" + i);
                generaArbol(matrices[i], camino, i, pos_cero[0], pos_cero[1], minimo + nivel, nivel + 1);
                camino = new ArrayList<>(camino_local);
            }
        }
    }

    public int H(int[][] matriz_actual) {
        int suma = 0;
        int n = matriz_actual.length, m = matriz_actual[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int valor = matriz_actual[i][j];
                if (valor == 0) {
                    continue;
                } else {
                    int f = (int) Math.ceil((double) valor / 3) - 1;
                    int c = (valor - 1) % 3;
                    suma += Math.abs(i - f) + Math.abs(j - c);
                }
            }
        }
        return suma;
    }

    public int[] obtenerPosicionVacio(int[][] matriz_actual) {
        int[] i_j = new int[2];
        int n = matriz_actual.length, m = matriz_actual[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz_actual[i][j] == 0) {
                    i_j[0] = i;
                    i_j[1] = j;
                    n = 0;
                    break;
                }
            }
        }
        return i_j;
    }

    public int valorMinimoVector(int[] vector) {
        int minimo = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }
        return minimo;
    }

    public void copiarMatriz(int[][] copia, int[][] original) {
        int n = copia.length, m = copia[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copia[i][j] = original[i][j];
            }
        }
    }

    public boolean sePuedeMover(int direccion, int direccion_anterior, int i, int j) {
        boolean condicion = false;
        if (direccion == 0 && direccion_anterior != 2) {
            condicion = (i - 1 >= 0);
        } else if (direccion == 1 && direccion_anterior != 3) {
            condicion = (j + 1 < matriz_objetivo[0].length);
        } else if (direccion == 2 && direccion_anterior != 0) {
            condicion = (i + 1 < matriz_objetivo.length);
        } else if (direccion == 3 && direccion_anterior != 1) {
            condicion = (j - 1 >= 0);
        }
        return condicion;
    }

    public int obtenerFallos(int[][] m1) {
        int fallos = 0;
        int n = m1.length, m = m1[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (m1[i][j] != matriz_objetivo[i][j] && m1[i][j] != 0) {
                    fallos++;
                }
            }
        }
        return fallos;
    }
}
