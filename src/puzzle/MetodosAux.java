
package puzzle;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MetodosAux {
    
    ArrayList<int[][]> listaMatrices = new ArrayList<>();
    int[][] matriz0 = {{2,7,6},{8,1,0},{3,4,5}};
    int[][] matriz1 = {{0,7,6},{1,5,8},{3,2,4}};
    int[][] matriz2 = {{8,4,2},{5,1,6},{0,3,7}};
    int[][] matriz3 = {{0,5,2},{3,7,6},{8,4,1}};
    int[][] matriz4 = {{3,6,7},{2,5,0},{4,1,8}};
    int[][] matriz5 = {{7,2,8},{3,5,1},{0,6,4}};
    int[][] matriz6 = {{1,8,4},{6,0,5},{2,7,3}};
    int[][] matriz7 = {{3,8,2},{4,7,5},{1,0,6}};
    int[][] matriz8 = {{6,1,5},{0,3,8},{2,4,7}};
    int[][] matriz9 = {{4,6,3},{5,0,2},{8,1,7}};
    int[][] matriz10 = {{5,1,0},{2,8,3},{7,4,6}};
    int[][] matriz11 = {{3,4,5},{8,2,7},{0,6,1}};
    int[][] matriz12 = {{7,2,5},{8,1,3},{4,6,0}};
    int[][] matriz13 = {{1,7,3},{5,2,8},{4,0,6}};
    int[][] matriz14 = {{3,5,1},{8,2,6},{0,4,7}};
    
    public MetodosAux() {
        listaMatrices.add(matriz0);
        listaMatrices.add(matriz1);
        listaMatrices.add(matriz2);
        listaMatrices.add(matriz3);
        listaMatrices.add(matriz4);
        listaMatrices.add(matriz5);
        listaMatrices.add(matriz6);
        listaMatrices.add(matriz7);
        listaMatrices.add(matriz8);
        listaMatrices.add(matriz9);
        listaMatrices.add(matriz10);
        listaMatrices.add(matriz11);
        listaMatrices.add(matriz12);
        listaMatrices.add(matriz13);
        listaMatrices.add(matriz14);
    }
    
    public int[][] obtenerMatriz(){
        int num = (int) Math.floor(Math.random()*15);
        return listaMatrices.get(num);
    }
    
    public int[] obtenerVector(int[][] matriz){
        int[] vec = new int[9];
        int cont=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(matriz[i][j]==0){
                    vec[cont] = 8;
                }else{
                    vec[cont] = matriz[i][j]-1;
                }
                cont++;
            }
        }
        return vec;
    }
    
    public int[][] cambioPosMatriz(int[][] m, int i1, int j1, int i2, int j2){
        int aux = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = aux;
        return m;
    }
    
    public boolean comprobar(int[][] m){
        int [][] matrizObj = {{1,2,3}, {4,5,6}, {7,8,0}};
        int cont=0;
        boolean estado = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(m[i][j] == matrizObj[i][j]){
                    cont++;
                }
            }
        }
        if(cont!=9){
            estado = false; 
        }
        return estado;
    }
}
