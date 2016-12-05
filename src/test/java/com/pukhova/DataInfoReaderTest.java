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

    public static final int INDEX = 0;
    public static final int SIZE = 1;

    @Test
    public void testRead() throws Exception {
        DataInfoReader dir = new DataInfoReader();
        Data data = dir.read(getClass().getClassLoader().getResourceAsStream("data.xml"));
        assertEquals(data.getCar().size(), SIZE);
        assertEquals(data.getCar().get(INDEX).getMake(), "Toyota");
        assertEquals(data.getCar().get(INDEX).getModel(), "RAV4");
        assertEquals(data.getCar().get(INDEX).getYear(), 2007);
    }

}
