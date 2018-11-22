/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import util.GameTableItem;
import util.IItem;

/**
 *
 * @author jamie
 */
public class AvailableGameParser implements IParser{

    @Override
    public List<IItem> parseItems(String data) {
        List<IItem> items = new ArrayList<>();
        
        if(data.equals("ERROR-NOGAME") || data.equals("ERROR-DB")){
            return items;
        }
        
        String [] rows = data.split("\n");
        
        for(String row : rows){
            String[] rowItems = row.split(",");
            int id = Integer.parseInt(rowItems[0]);
            items.add(new GameTableItem(id, rowItems[1], rowItems[2]));
        }
        System.out.println("DATA BACK: " + items);
        return items;
    }
    
}
