package com.pukhova.model.io;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * Created by dish on 01.12.16.
 */
public interface InfoReader<T> {

    public T read(InputStream is) throws JAXBException;
}
