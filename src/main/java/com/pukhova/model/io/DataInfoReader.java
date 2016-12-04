package com.pukhova.model.io;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pukhova.model.data.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.InputStream;

/**
 * Created by dish on 01.12.16.
 */

public class DataInfoReader implements InfoReader<Data> {

    public Data read(InputStream is) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Data data = (Data) jaxbUnmarshaller.unmarshal(is);
        return data;
    }
}
