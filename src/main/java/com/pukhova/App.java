package com.pukhova;

import com.epam.bl.BusinessFunction;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.pukhova.model.Configuration;
import com.pukhova.model.data.Data;
import com.pukhova.model.io.InfoReader;
import com.pukhova.model.layout.Layout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    JFrame frame = new JFrame("Application");

    Injector injector = Guice.createInjector(new AppModule());
    DataLayout dl = injector.getInstance(DataLayout.class);
    InfoReader<Data> dataInfoReader = dl.getDir();
    InfoReader<Layout> layoutInfoReader = dl.getLir();
    JTable tbl = injector.getInstance(JTable.class);
    Configuration conf = injector.getInstance(Configuration.class);

    String localeVal = conf.getParam("locale");
    String [] localeSplitted = localeVal.split("_");
    Locale defaultLocale = new Locale(localeSplitted[0], localeSplitted[1]);

    ResourceBundle defaultBundle = ResourceBundle.getBundle("MyMessages", defaultLocale);

    public static void main( String[] args ){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App application = new App();
                application.createAndShowGUI();
            }
        });
    }

    public ResourceBundle getCurrentBundle(){
        return defaultBundle;
    }

    private void createAndShowGUI() {
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        Data data;
        Layout layout;
        try {
            InputStream isd = new FileInputStream(conf.getParam("dataFile"));
            InputStream isl = new FileInputStream(conf.getParam("layoutFile"));
            //InputStream isd = getClass().getClassLoader().getResourceAsStream(conf.getParam("dataFile"));
            //InputStream isl = getClass().getClassLoader().getResourceAsStream(conf.getParam("layoutFile"));
            data = dataInfoReader.read(isd);
            layout = layoutInfoReader.read(isl);
            addTable(pane, data, layout);
            addButtons(pane, layout);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.toString());
        }
    }

    private void addTable(Container pane, Data d, Layout l) {
        List<Data.Car> carList = d.getCar();
        Object[][] cars = new Object[carList.size()][];
        int index = 0;
        for (Data.Car car : carList){
            Object [] secArray = new Object[]{car.getMake(), car.getModel(), car.getYear() + ""};
            cars[index] = secArray;
            index++;
        }
        List<String> columns = l.getGrid().getColumn();
        String [] cols = new String[columns.size()];
        int i = 0;
        for (String s : columns){
            cols[i] = getCurrentBundle().getString(s);
            i++;
        }
        placeTable(cols, cars, pane);
    }

    private void addButtons(Container pane, Layout l) {
        for (final Layout.Menu.Button btn : l.getMenu().getButton()){
            String btnClazz = btn.getClazz();
            Key<BusinessFunction> key = Key.get(BusinessFunction.class, Names.named(btnClazz));
            final BusinessFunction myAction = injector.getInstance(key);
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    myAction.doAction();
                }
            };
            placeButton(getCurrentBundle().getString(btnClazz), pane, actionListener);
        }
    }

    private void placeButton(String text, Container container, ActionListener al) {
        JButton button = new JButton(text);
        button.addActionListener(al);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    private void placeTable(String [] s, Object[][] o, Container container) {
        TableModel myModel = new DefaultTableModel(o, s);
        JTable table = tbl;
        table.setModel(myModel);
        table.setAlignmentX(Component.CENTER_ALIGNMENT);
        table.setOpaque(true);
        table.setAutoCreateColumnsFromModel(true);
        container.add(new JScrollPane(table));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
    }

}
