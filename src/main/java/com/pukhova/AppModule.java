package com.pukhova;

import com.epam.bl.BusinessFunction;
import com.epam.bl.MyAction;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.pukhova.model.Configuration;
import com.pukhova.model.io.DataInfoReader;
import com.pukhova.model.io.InfoReader;
import com.pukhova.model.io.LayoutInfoReader;

import javax.swing.*;

/**
 * Created by dish on 02.12.16.
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InfoReader.class).annotatedWith(Names.named("Data")).to(DataInfoReader.class);
        bind(InfoReader.class).annotatedWith(Names.named("Layout")).to(LayoutInfoReader.class);
        bind(BusinessFunction.class).annotatedWith(Names.named("com.epam.bl.MyAction")).to(MyAction.class);
        bind(JTable.class).toInstance(new JTable());
        bind(Configuration.class).toInstance(new Configuration());

    }
}
