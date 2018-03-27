/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicionariosandhash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 20151bsi0401
 */
public class DicionariosAndHash {

    public static void zerarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public static void printMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + ";");
            }
            System.out.println("\n");
        }
    }

    public static void gravaMatrizArquivo(int[][] matriz) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\dicionariosandhash\\resultado.csv"));
        for(int i = 0; i < matriz.length ; i++){
            for(int j = 0; j < matriz[i].length; j++){
                writer.write(matriz[i][j] + ";");
            }
            writer.write("\n");
        }
        writer.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        int MAX = 101;
        int[][] matriz_funcao_hash = new int[MAX][2];
        zerarMatriz(matriz_funcao_hash);

        try (BufferedReader br = new BufferedReader(new FileReader("src\\dicionariosandhash\\nomes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                matriz_funcao_hash[FuncoesHash.FuncaoUm(linha, MAX)][0]++;
                matriz_funcao_hash[FuncoesHash.FuncaoDois(linha, MAX, 33)][1]++;
            }
            gravaMatrizArquivo(matriz_funcao_hash);
            System.out.println("Arquivo salvo com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }

}
