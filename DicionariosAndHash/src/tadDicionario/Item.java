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
public class Item {

    private Object key;
    private Object elemento;
    private int cacheHashCode;

    public Item(Object key, Object elemento) {
        this.key = key;
        this.elemento = elemento;

    }

    public Item(Object key, Object elemento, int hashCode) {
        this.key = key;
        this.elemento = elemento;
        this.cacheHashCode = hashCode;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getElement() {
        return elemento;
    }

    public void setElem(Object pelem) {
        this.elemento = pelem;
    }

    public int getCacheHCode() {
        return cacheHashCode;
    }

    public void setCacheHCode(int hashCode) {
        this.cacheHashCode = hashCode;
    }
}
