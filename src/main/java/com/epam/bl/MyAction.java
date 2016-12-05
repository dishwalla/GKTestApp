package com.epam.bl;

import com.google.inject.Inject;

import javax.swing.*;

/**
 * Created by dish on 02.12.16.
 */

public class MyAction implements BusinessFunction {

    public static final int COLUMN = 0;
    private JTable table;

    @Inject
    public MyAction(JTable t) {
        this.table = t;
    }

    public void doAction() {
        table.getRowSorter().toggleSortOrder(COLUMN);
    }

}
