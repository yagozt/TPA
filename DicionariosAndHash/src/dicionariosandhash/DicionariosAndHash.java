/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicionariosandhash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * @author 20151bsi0401
 */
public class DicionariosAndHash {

    
    public static void zerarMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = 0;
    }
    
    public static void printMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++)
                System.out.print(matriz[i][j] + ";");
            System.out.println("\n");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,String> hashmap = new HashMap<>();
        int[][] matriz_funcao_hash = new int[100][2];
        zerarMatriz(matriz_funcao_hash);
        
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\20151bsi0401\\Documents\\nomes.txt"))){
            String linha = "";
            while((linha = br.readLine()) != null ){
                matriz_funcao_hash[FuncoesHash.FuncaoUm(linha, 100)][0]++;
                matriz_funcao_hash[FuncoesHash.FuncaoDois(linha, 100, 33)][1]++;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        printMatriz(matriz_funcao_hash);
    }

}
