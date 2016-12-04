package com.pukhova;

import com.pukhova.model.data.Data;
import com.pukhova.model.io.DataInfoReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dish on 01.12.16.
 */
public class DataInfoReaderTest {
    @Test
    public void testRead() throws Exception {
        DataInfoReader dir = new DataInfoReader();
        Data d = dir.read(getClass().getClassLoader().getResourceAsStream("data.xml"));
        assertEquals(d.getCar().size(), 1);
        assertEquals(d.getCar().get(0).getMake(), "Toyota");
        assertEquals(d.getCar().get(0).getModel(), "RAV4");
        assertEquals(d.getCar().get(0).getYear(), 2007);
    }

}
