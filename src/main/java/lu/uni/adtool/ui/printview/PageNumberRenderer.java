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
package lu.uni.adtool.ui.printview;

import java.awt.Component;

/**
 * PageNumberRenderer public interface.
 *
 * @author Piotr Kordy
 */
public interface PageNumberRenderer {
  /**
   * Get component with rendered page number.
   *
   * @param pageNumber
   *          page number.
   * @param isSelected
   *          is the page selected?
   * @param hasFocus
   *          has the page focus?
   * @return Component.
   */
  Component getRenderer(int pageNumber, boolean isSelected, boolean hasFocus);
}
