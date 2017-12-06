package com.kevin86.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by chengang on 2016/2/5.
 */
public class CommonFunc {
    public static Vector changeVector(Object... objects){
        Vector vc = new Vector();
        for (Object obj : objects) {
            vc.add(obj);
        }
        return vc;
    }

    public static Vector changeListVector(Collection objs){
        Vector vc = new Vector();
        for (Object obj : objs) {
            vc.add(obj);
        }
        return vc;
    }

    public static <T>T[] changelistToAry(Collection<T> clt){
        Object[] ary= new Object[clt.size()];
        int i = 0;
        for (Iterator<T> iterator = clt.iterator(); iterator.hasNext(); ) {
            T next =  iterator.next();
            ary[i] = next;
            i++;
        }
        return (T[]) ary;
    }

    public static String[] changelistToStringAry(Collection<String> clt){
        String[] ary= new String[clt.size()];
        int i = 0;
        for (Iterator<String> iterator = clt.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            ary[i] = next;
            i++;
        }
        return ary;
    }



}
