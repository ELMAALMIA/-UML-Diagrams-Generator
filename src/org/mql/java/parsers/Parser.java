package org.mql.java.parsers;



public interface Parser<T,U> {
    T Parse(U item);


}
