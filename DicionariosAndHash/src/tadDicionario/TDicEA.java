/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadDicionario;

import dicionariosandhash.Auxiliares;
import java.util.LinkedList;

/**
 *
 * @author 20151bsi0401
 */
public class TDicEA extends TDic{
    
    public static final TItemDic NO_SUCH_KEY = new TItemDic(null, null);
    private int IndexNullDel = 0;
    private TItemDic[] conteudos = null;
    private HashEngine hengine = null;
    private int tam;
    private int quant = 0;
    
    public TDicEA(int n, HashEngine pHashEngine) {

        tam = Auxiliares.primoMaiorQueN(n);
        conteudos = new TItemDic[tam];
        hengine = pHashEngine;
        quant = 0;
    }

    public TDicEA(HashEngine pHashEngine) {
        tam = Auxiliares.primoMaiorQueN(1<<4);
        conteudos = new TItemDic[tam];
        hengine = pHashEngine;
        quant = 0;
    }

    public TDicEA() {
        tam = Auxiliares.primoMaiorQueN(1<<4);
        conteudos = new TItemDic[tam];
        hengine = new HashEngineDefault();
        quant = 0;
    }

    public TDicEA(int n){
        hengine = new HashEngineDefault();
        tam = Auxiliares.primoMaiorQueN(n);
        conteudos = new TItemDic[tam];
        quant = 0;
    }
    
    private int[] pesquisaItem(Object k) {
        int pos = hengine.calcCodeHash(k) % tam;
        int i = pos;
        
        while ((conteudos[i] != null) && (!conteudos[i].getKey().equals(k)) && (i != pos)){
            if(((conteudos[i].equals(null)) || conteudos[i].equals(NO_SUCH_KEY)) && IndexNullDel == -1)
                IndexNullDel = i;
            i = (i + 1) % tam;
        }
        
        if(conteudos[i].getKey().equals(k))
            return new int[]{i,0};
        else
            return new int[] {-1, IndexNullDel};
    }

    private void redimensiona() {
        int novo_tam = Auxiliares.primoMaiorQueN((int)(tam * 1.5));
        TItemDic[] novosConteudos = new TItemDic[novo_tam];
        int novo_pos = 0;
        
        for(int i =0; i < novo_tam; i++)
            novosConteudos[i] = null;
        
        for(int i =0; i<tam;i++){
            novo_pos = conteudos[i].getCache_hash() % novo_tam;
            novosConteudos[novo_pos] = conteudos[i];
        }
    }

    @Override
    public Object findElem(Object key) {
        int pos = hengine.calcCodeHash(key) % tam;
        int i = pos;
        
        if((conteudos[i] != null) && (conteudos[i].getKey().equals(key)))
            return conteudos[i].getDado();
        else{
            i = (i+1) % tam;
            while((conteudos[i] != null) && (!conteudos[i].getKey().equals(key))&& (i != pos))
                i = (i+1) %tam;
        }
        
        if(conteudos[i].getKey().equals(key))
            return conteudos[i].getDado();
        else
            return null;
    }

    @Override
    public boolean insertItem(Object chave, Object elemento) {
        TItemDic item = new TItemDic(chave, elemento);
        int hk = hengine.calcCodeHash(chave);
        item.setCache_hash(hk);
        
        int pos = hk % tam;
        
        int[] posAchou = pesquisaItem(chave);
        
        if(posAchou[0] == -1){
            // Verifica se é necessário redimensionar
            if(((float)quant)/tam > (0.2*tam))
                redimensiona();
            
            conteudos[pos] = item;
            quant++;
        }
        else
            conteudos[posAchou[0]].setDado(elemento);
        
        return true;
    }

    @Override
    public Object removeElem(Object chave) {
        int[] posAchou = pesquisaItem(chave);
        
        if(posAchou[0] == -1)
            return null;
        else{
            TItemDic tmp = conteudos[posAchou[0]];
            conteudos[posAchou[0]] = NO_SUCH_KEY;
            return tmp.getDado();
        }
    }

    @Override
    public LinkedList keys() {
        LinkedList<Object> lst = new LinkedList<Object>();
        
        for(int i = 0; i< tam; i++){
            if(!conteudos[i].equals(null) && !conteudos[i].equals(NO_SUCH_KEY))
                lst.add(conteudos[i].getKey());
        }
        
        return lst;
    }

    @Override
    public LinkedList elements() {
        LinkedList<Object> lst = new LinkedList<Object>();
        
        for(int i = 0; i< tam; i++){
            if(!conteudos[i].equals(null) && !conteudos[i].equals(NO_SUCH_KEY))
                lst.add(conteudos[i].getDado());
        }
        
        return lst;
    }

    @Override
    public boolean isEmpty() {
        return quant==0;
    }

    @Override
    public int size() {
        return quant;
    }
    
}
