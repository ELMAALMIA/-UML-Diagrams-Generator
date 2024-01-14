package org.mql.java.xml.dom;

import java.io.File;

public interface Parser<T> {
    T parse(File file);
}
