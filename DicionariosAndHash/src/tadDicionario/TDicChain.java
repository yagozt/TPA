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
public class TDicChain extends TDic{

    private int quant_entradas;
    private int tam_vet_conteudo = 0;
    private LinkedList<TItemDic>[] vet_conteudo = null;
    private HashEngine he;

    public TDicChain(int tam_vet, HashEngine he) {
        this.tam_vet_conteudo = Auxiliares.primoMaiorQueN(tam_vet);
        this.vet_conteudo = new LinkedList[this.tam_vet_conteudo];
        quant_entradas = 0;
        this.he = he;

        for (int i = 0; i < this.tam_vet_conteudo; i++) {
            this.vet_conteudo[i] = new LinkedList<TItemDic>();
        }
    }

    public TDicChain(HashEngine he) {
        int tam_vet = Auxiliares.primoMaiorQueN(64);
        this.vet_conteudo = new LinkedList[tam_vet];
        this.quant_entradas = 0;
        this.he = he;

        for (int i = 0; i < tam_vet; i++) {
            this.vet_conteudo[i] = new LinkedList<TItemDic>();
        }
    }

    public TDicChain() {
        int tam_vet = 64;
        this.vet_conteudo = new LinkedList[tam_vet];
        this.quant_entradas = 0;
        this.he = new HashEngineDefault();

        for (int i = 0; i < tam_vet; i++) {
            this.vet_conteudo[i] = new LinkedList<TItemDic>();
        }
    }

    private int pesquisaItem(Object k, LinkedList<TItemDic> lst) {
        boolean achou = false;
        int i = 0;

        while (!achou && (i < lst.size())) {
            achou = k.equals(lst.get(i).getKey());
            i++;
        }

        if (achou) {
            return i - 1;
        } else {
            return -1;
        }
    }

    public Object findElement(Object k) {
        int i = 0;
        
        for(i = 0; i < size(); i++){
            int a = pesquisaItem(k, vet_conteudo[i]);
            if(a != -1){
                return vet_conteudo[i].get(a);
            }
        }
        return null;
    }

    public boolean insertItem(Object k, Object dado) {
        TItemDic item = new TItemDic(k, dado);
        int hk = (int) he.calcCodeHash(k);
        item.setCache_hash(hk);
        int pos = (int) (hk % tam_vet_conteudo);

        //Decidindo se é uma alteração ou a inclusão de uma nova entrada.
        int posAchou = pesquisaItem(k, vet_conteudo[pos]);

        if (posAchou == -1) {
            if (tam_vet_conteudo / quant_entradas > 0.75) {
                redimensiona();
            }
            vet_conteudo[pos].add(item);
            quant_entradas++;
        } else {
            vet_conteudo[pos].get(posAchou).setDado(dado);
        }

        return true;
    }

    public Object removeElement(Object k) {
        int pos = he.calcCodeHash(k) % tam_vet_conteudo;

        int posItem = pesquisaItem(k, vet_conteudo[pos]);
        TItemDic temp;

        if (posItem != -1) {
            temp = vet_conteudo[pos].get(posItem);
            vet_conteudo[pos].remove(posItem);
            this.quant_entradas--;
            return temp.getDado();
        }

        return null;
    }

    public int size() {
        return quant_entradas;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public LinkedList<Object> keys() {
        return null;
    }

    public LinkedList<Object> elements() {
        return null;
    }

    private void redimensiona() {
        int novo_tam = Auxiliares.primoMaiorQueN((int) (tam_vet_conteudo * 1.5));
        int novo_pos = 0;
        LinkedList<TItemDic>[] novo_vet = new LinkedList[novo_tam];

        for (int i = 0; i < novo_tam; i++) {
            novo_vet[i] = new LinkedList<TItemDic>();
        }

        for (int i = 0; i < tam_vet_conteudo; i++) {

            for (int k = 0; i < vet_conteudo[i].size(); k++) {
                novo_pos = vet_conteudo[i].get(k).getCache_hash() % novo_tam;
                novo_vet[novo_pos].add(vet_conteudo[i].get(k));
            } // for k
        } // for i

        vet_conteudo = novo_vet;
        tam_vet_conteudo = novo_tam;
    }

    @Override
    public Object findElem(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removeElem(Object chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
