/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicionariosandhash;

/**
 *
 * @author 20151bsi0401
 */
public class FuncoesHash {
    public static int FuncaoUm(String str, int totalElem){
        int somaComponentesAsc = 0;
        for(int i = 0; i < str.length(); i++){
            somaComponentesAsc += str.charAt(i);
        }
        return somaComponentesAsc % totalElem;
    }
    
    public static int FuncaoDois(String str, int totalElem, int z){
        int somaComponentesAsc = 0;
        for(int i = 0; i < str.length(); i++){
            somaComponentesAsc += str.charAt(i)*Math.pow(z, i);
        }
        return somaComponentesAsc % totalElem;
    }
}
