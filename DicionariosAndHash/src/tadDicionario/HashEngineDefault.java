/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadDicionario;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author 20151bsi0401
 */
public class HashEngineDefault extends HashEngine {

    public long hash(Object k) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(k);
            out.flush();

            byte[] yourBytes = bos.toByteArray();

            long somapoli = 0;
            int expo = 0;
            for (int i = 0; i < yourBytes.length; i++) {
                somapoli += yourBytes[i] + Math.pow(33, expo);
                expo++;
            }
            return Math.abs(somapoli);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int calcCodeHash(Object key) {
        long polResult = 0;

        byte[] vetorBytes = null;

        if (key == null) {
            return 0;
        }

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(key);
            vetorBytes = byteArrayOutputStream.toByteArray();

        } catch (Exception ex) {
            System.out.println("Erro na conversão para vetor de bytes");
        }

        for (int i = 0; i < vetorBytes.length; i++) {
            polResult = polResult + (int) vetorBytes[i] * (long) Math.pow(27, i);
        }
        return Math.abs((int) polResult);
    }
}
