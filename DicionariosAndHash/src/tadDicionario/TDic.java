/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadDicionario;

import java.util.LinkedList;

/**
 *
 * @author 20151bsi0401
 */
public abstract class TDic {

    private static Item NO_SUCH_KEY = new Item(null, null);
    private int tamanho;
    private final HashEngine hengine;
    protected int colisoes[];

    public TDic() {
        this.hengine = new HashEngineDefault();
        this.tamanho = 100;
        colisoes = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            colisoes[i] = 0;
        }
    }

    public TDic(int tam, HashEngine hE) {
        hengine = hE;
        this.tamanho = tam;
        colisoes = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            colisoes[i] = 0;
        }
    }

    public TDic(HashEngine hE) {
        hengine = hE;
        tamanho = 100;

        colisoes = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            colisoes[i] = 0;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public abstract Object findElem(Object key);

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract boolean insertItem(Object chave, Object elemento);

    public abstract Object removeElem(Object chave);

    public abstract LinkedList keys();

    public abstract LinkedList elements();
}
