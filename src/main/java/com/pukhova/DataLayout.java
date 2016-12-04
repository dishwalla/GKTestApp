package com.pukhova;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pukhova.model.data.Data;
import com.pukhova.model.io.DataInfoReader;
import com.pukhova.model.io.InfoReader;
import com.pukhova.model.io.LayoutInfoReader;
import com.pukhova.model.layout.Layout;

/**
 * Created by dish on 02.12.16.
 */
public class DataLayout {
    private InfoReader<Data> dir;
    private InfoReader<Layout> lir;

    @Inject
    public DataLayout(@Named("Data") InfoReader dir, @Named("Layout") InfoReader lir){
        this.dir = dir;
        this.lir = lir;
    }

    public InfoReader<Data> getDir() {
        return dir;
    }

    public InfoReader<Layout> getLir() {
        return lir;
    }
}
