/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadDicionario;

/**
 *
 * @author 20151bsi0401
 */

public class TItemDic{
    private Object key = null;

    public void setKey(Object key) {
        this.key = key;
    }
    private Object dado = null;
    private int cache_hash;

    public int getCache_hash() {
        return cache_hash;
    }

    public void setCache_hash(int cache_hash) {
        this.cache_hash = cache_hash;
    }
    public TItemDic(Object k, Object d){
        this.key = k;
        this.dado = d;
    }
    public Object getKey(){
        return key;
    }
    public Object getDado(){
        return dado;
    }

    void setDado(Object dado) {
        this.dado = dado;
    }
}
