/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smarttool.DB;


/**
 *
 * @author Salman
 */
public class IDGenerator {

public static int id=0;

    public static int nextId(){
       return (id++);
    }

}
