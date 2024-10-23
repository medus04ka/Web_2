package org.example.util;

public class RestrictionsHelper {

    public  static <T extends Number> void  isGreaterOrLesser(T g, T l, T value) throws Exception {
        if (value == null) {
            throw new Exception(value + "is Null");
        }
        if (value.doubleValue() > g.doubleValue() || value.doubleValue() < l.doubleValue()) {
            throw new Exception("Bredik ne pishem value can be only lesser " + g + " and greater " + l);
        }
    }

}
