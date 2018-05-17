/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadPolinomio;

import tadDicionario.TDic;
import tadDicionario.TDicChain;

/**
 *
 * @author 20151bsi0401
 */
public class TADPoli {
    private String polinomio;
    private TDic dicpoli = null;
    public TADPoli(String strPolinomio){
        try
        {
        if ("".equals(strPolinomio))
            throw ExceptionInInitializerError("String vazia");
        dicpoli = new TDicChain();
        }
        catch (Exception ex){
            System.out.println("ex");
        }
        
    }
    
    private void HandlePolinomio(String strPolinomio){
        if((strPolinomio.charAt(0) != '+') || (strPolinomio.charAt(0) != '-')){
            strPolinomio = "+" + strPolinomio;
        }
        String strMono = "";
        char sinal = strPolinomio.charAt(0);
        
        for(int i=1;i<strPolinomio.length();i++){
            if ((strPolinomio.charAt(i) != '+') && (strPolinomio.charAt(i) != '-'))
                strMono = strMono + strPolinomio.charAt(i);
            else{
                String[] v = strMono.split("X");
                
                Float coef = 0.0f;
                Integer grau = 0;
                
                if(v.length == 2){
                    if((v[0] != "") && (v[1] != "")){
                        coef = Float.parseFloat(v[0]);
                        grau = Integer.parseInt(v[1]);
                        
                        
                    }
                    else {
                        if((v[0] != "") && (v[1] == "")){
                            coef = Float.parseFloat(v[0]);
                            grau = new Integer(1);
                        }
                        else{
                            coef = new Float(1.0);
                            grau = Integer.parseInt(v[1]);
                        }
                    }
                }
                else{
                    if(strPolinomio.toLowerCase() == "x"){
                        grau = 1;
                        coef = Float.parseFloat("1");
                    }
                    else{
                        grau = 0;
                        coef = Float.parseFloat(strPolinomio);
                    }
                }
                
                if(sinal == '-')
                    coef = coef * -1;
                
                dicpoli.insertItem(grau, coef);
                sinal = strPolinomio.charAt(i);
            }
        } // for(int i=1;i<strPolinomio.length();i++)
    }

    private Exception ExceptionInInitializerError(String msg) {
        throw new UnsupportedOperationException(msg); //To change body of generated methods, choose Tools | Templates.
    }
    
}
