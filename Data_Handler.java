/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package clipper;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

/**
 *
 * @author jakubwawak
 */
public class Data_Handler {
    
    ArrayList<Text_Object> data_contener;   // collection for storing text data
    
    Date act_date;                  // actual time of object creation
    
    
    // constructor
    Data_Handler(){
        data_contener = new ArrayList();
        act_date = new Date();
    }
    
    /**
     * Function adding data to contener
     * @param data 
     */
    void add(String data){
        data_contener.add(new Text_Object(data));
    }
    // Simple showing contener
    void show(){
        System.out.println("----------------------------------------");
        System.out.println("Contener: "+act_date.toString());
        System.out.println("------------------");
        for (Text_Object to : data_contener){
            System.out.println(to.simple_show());
        }
        System.out.println("------------------");
        System.out.println("----------------------------------------");
    }
    
    /**
     * Function returns list model used in jList object in gui
     * @return DefaultListModel
     */
    DefaultListModel return_listmodel(){
        
        DefaultListModel<String> to_ret = new DefaultListModel<>();
        
        for (Text_Object to : data_contener){
            to_ret.addElement(to.simple_show());
        }
        return to_ret;
    }
}