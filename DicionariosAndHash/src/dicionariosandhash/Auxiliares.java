
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
public class Auxiliares {
    public static boolean  isPrimo(int n){
        int quant_divs = 0, divr = 1;
        int limite = (int)Math.sqrt(n);
        
        while (divr < limite){
            if(n % divr == 0)
                quant_divs++;
            divr++;
        }
        
        return quant_divs == 1;
    }
    
    public static int primoMaiorQueN(int n){
        while(!isPrimo(n))
            n++;
        return n;
    }
    
}