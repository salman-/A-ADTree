/**
 * Author: Piotr Kordy (piotr.kordy@uni.lu <mailto:piotr.kordy@uni.lu>)
 * Date:   10/12/2015
 * Copyright (c) 2015,2013,2012 University of Luxembourg -- Faculty of Science,
 *     Technology and Communication FSTC
 * All rights reserved.
 * Licensed under GNU Affero General Public License 3.0;
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lu.uni.adtool.tools;
public final class Debug {

  public static void log (String msg){
    if(Options.debug_enable) {
      StackTraceElement[] stack = Thread.currentThread().getStackTrace();
      if (stack.length > 2) {
        msg = stack[2].getFileName() + ":"+ stack[2].getLineNumber() + " " +stack[2].getMethodName() + "(): \t" + msg;
//         if (stack.length > 3) {
//         msg += "\n    "+stack[3].getFileName() + ":"+ stack[3].getLineNumber() + " " +stack[3].getMethodName() + "(): \t";
//         }
      }
      System.out.println(msg);
    }
  }
}
