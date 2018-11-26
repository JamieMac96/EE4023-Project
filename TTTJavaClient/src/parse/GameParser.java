/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;

import java.util.List;
import java.util.ArrayList;
import util.GameItem;
import util.GameTableItem;
import util.IItem;
import util.LeaderBoardItem;

/**
 *
 * @author jamie
 */
public class GameParser implements IParser{

    @Override
    public List<IItem> parseItems(String data) {
        List<IItem> items = new ArrayList<>();
        
        if(data.equals("ERROR-NOGAMES") || data.equals("ERROR-DB")){
            return items;
        }
        String [] rows = data.split("\n");
        for(String row : rows){
            String[] rowItems = row.split(",");
            int id = Integer.parseInt(rowItems[0]);
            if(rowItems.length == 3) {
                items.add(new GameTableItem(id, rowItems[1], rowItems[2]));
            }
            else if(rowItems.length == 4) {
                items.add(new GameItem(id, rowItems[1], rowItems[2], rowItems[3]));
            }
            else if(rowItems.length == 5) {
                items.add(new LeaderBoardItem(id, rowItems[1], rowItems[2], rowItems[3], rowItems[4]));
            }
        }
        System.out.println("DATA BACK: " + items);
        return items;
    }
    
}
