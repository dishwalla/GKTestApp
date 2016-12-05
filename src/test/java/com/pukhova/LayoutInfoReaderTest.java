package com.pukhova;

import com.pukhova.model.io.LayoutInfoReader;
import com.pukhova.model.layout.Layout;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by dish on 01.12.16.
 */
public class LayoutInfoReaderTest {

    public static final int SIZE = 3;

    @Test
    public void testRead() throws Exception {
        LayoutInfoReader lir = new LayoutInfoReader();
        Layout layout = lir.read(getClass().getClassLoader().getResourceAsStream("layout.xml"));
        assertEquals(layout.getMenu().getButton().get(0).getValue(), "Sort table");
        assertEquals(layout.getGrid().getColumn().size(), SIZE);
        assertEquals(layout.getGrid().getColumn().get(0), "Make");
        assertEquals(layout.getGrid().getColumn().get(1), "Model");
        assertEquals(layout.getGrid().getColumn().get(2), "Year");
    }
}
