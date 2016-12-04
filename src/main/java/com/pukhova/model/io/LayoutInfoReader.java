package com.pukhova.model.io;

import com.google.inject.Inject;
import com.pukhova.model.data.Data;
import com.pukhova.model.layout.Layout;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Created by dish on 01.12.16.
 */

public class LayoutInfoReader implements InfoReader<Layout> {

    public Layout read(InputStream is) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Layout.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Layout layout = (Layout) jaxbUnmarshaller.unmarshal(is);
        return layout;
    }
}
