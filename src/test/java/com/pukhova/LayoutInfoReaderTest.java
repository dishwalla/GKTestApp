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
    @Test
    public void testRead() throws Exception {
        LayoutInfoReader lir = new LayoutInfoReader();
        Layout l = lir.read(getClass().getClassLoader().getResourceAsStream("layout.xml"));
        assertEquals(l.getMenu().getButton().get(0).getValue(), "Sort table");
        assertEquals(l.getGrid().getColumn().size(), 3);
        assertEquals(l.getGrid().getColumn().get(0), "Make");
        assertEquals(l.getGrid().getColumn().get(1), "Model");
        assertEquals(l.getGrid().getColumn().get(2), "Year");
    }
}
