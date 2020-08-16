package clipper;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * @author Matthias Hinz
 * changed for gui by Jakub Wawak
 */
class ClipBoardListener extends Observable implements Runnable {

    Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
    
    DefaultListModel source;
    JList<String> gui_source;
    
    ClipBoardListener(DefaultListModel to_add,JList<String> list_obj){
        source = to_add;
        gui_source = list_obj;
    }

    private volatile boolean running = true;

    public void terminate() {
        running = false;
    }

    public void run() {
        // the first output will be when a non-empty text is detected
        String recentContent = "";
        // continuously perform read from clipboard
        while (running) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                // request what kind of data-flavor is supported
                List<DataFlavor> flavors = Arrays.asList(sysClip.getAvailableDataFlavors());
                // this implementation only supports string-flavor
                if (flavors.contains(DataFlavor.stringFlavor)) {
                    String data = (String) sysClip.getData(DataFlavor.stringFlavor);
                    if (!data.equals(recentContent)) {
                        recentContent = data;
                        // Do whatever you want to do when a clipboard change was detected, e.g.:
                        System.out.println(data);
                       
                        source.addElement(data);
                        gui_source.setModel(source);
                        
                        setChanged();
                        notifyObservers(data);
                    }
                }

            } catch (HeadlessException e1) {
                e1.printStackTrace();
            } catch (UnsupportedFlavorException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}