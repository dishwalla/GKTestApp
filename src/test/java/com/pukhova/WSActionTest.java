package com.pukhova;

import com.epam.bl.MyAction;
import com.epam.bl.WSAction;
import com.pukhova.model.Configuration;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

/**
 * Created by dish on 02.12.16.
 */

public class WSActionTest {

    Mockery context = new Mockery() { {
        setImposteriser(ClassImposteriser.INSTANCE);
    } };

    @Test
    public void testDoAction() throws Exception {
        final Configuration configuration = context.mock(Configuration.class);

        //expectation
        context.checking(new Expectations() {{
            oneOf (configuration).getParam(WSAction.WSDL_LOCATION);
        }});

        // execute
        WSAction wsAction = new WSAction(configuration);
        wsAction.doAction();

        // verify
        context.assertIsSatisfied();

    }
}
