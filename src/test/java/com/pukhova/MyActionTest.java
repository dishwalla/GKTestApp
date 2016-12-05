package com.pukhova;

import com.epam.bl.MyAction;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

/**
 * Created by dish on 02.12.16.
 */

public class MyActionTest {

    public static final int COLUMN = 0;
    Mockery context = new Mockery() { {
        setImposteriser(ClassImposteriser.INSTANCE);
    } };

    @Test
    public void testDoAction() throws Exception {
        final JTable table = context.mock(JTable.class);
        final TableRowSorter sorter = context.mock(TableRowSorter.class);

        //expectation
        context.checking(new Expectations() {{
            oneOf (sorter).toggleSortOrder(COLUMN);
            oneOf (table).getRowSorter(); will(returnValue(sorter));
        }});

        // execute
        MyAction myAction = new MyAction(table);
        myAction.doAction();

        // verify
        context.assertIsSatisfied();

    }
}
