/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;
import java.util.List;
import util.IItem;

/**
 *
 * @author jamie
 */
public interface IParser {
   List<IItem> parseItems(String data); 
}
