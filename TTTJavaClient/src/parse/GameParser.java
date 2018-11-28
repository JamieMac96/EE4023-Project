/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;

import model.GameTableItem;
import java.util.List;
import java.util.ArrayList;
import model.GameItem;
import model.IItem;
import model.LeaderBoardItem;

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
            switch (rowItems.length) {
                case 3:
                    items.add(new GameTableItem(id, rowItems[1], rowItems[2]));
                    break;
                case 4:
                    items.add(new GameItem(id, rowItems[1], rowItems[2], rowItems[3]));
                    break;
                case 5:
                    items.add(new LeaderBoardItem(id, rowItems[1], rowItems[2], rowItems[3], rowItems[4]));
                    break;
                default:
                    break;
            }
        }
        System.out.println("DATA BACK: " + items);
        return items;
    }
    
}
