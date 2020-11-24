/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package clipper;

import java.util.Date;

/**
 *Object for storing text
 * @author jakubwawak
 */
public class Text_Object {
    
    String raw_data;    // raw data of text
    
    int raw_data_len;   // length of text
    
    
    Date act_date;      // date added
    
    // constructor
    Text_Object(String data){
        
        raw_data = data;
        
        // usun lewa i prawa spacje
        
        raw_data_len = raw_data.length();
        
        act_date = new Date();
        
    }
    
    /**
     * Function for returning raw data from object
     * @return String
     */
    String raw_data_show(){
        return raw_data;
    }
    /**
     * Function for showing date
     * @return String
     */
    String date_show(){
        return act_date.toString();
    }
    /**
     * Function for showing cut clipboard data
     * @return String
     */
    String simple_show(){
        
        if ( raw_data_len > 40 ){
            return raw_data.substring(0, 30) + "(...)";
        }
        else{
            return raw_data;
        }
    }
    
    /**
     * Function for giving category
     * @return String
     */
    String give_category(){
        
        if(raw_data.contains(("https"))){
            return "internet link";
        }
        else if (raw_data.contains("@")){
            return "e-mail address";
        }
        else if (raw_data.contains("()")){
            return "computer code";
        }
        return "other";
    }
    
}

