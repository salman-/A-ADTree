/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smarttool.DB;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Salman
 */
public class IDGenerator {
	private static final AtomicInteger counter = new AtomicInteger();

    public static int nextId(){
    	 return counter.getAndIncrement();
    }

}
