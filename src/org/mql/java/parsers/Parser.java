package org.mql.java.parsers;

import java.io.File;

public interface Parser<T,U> {
    T Parse(U item);


}
