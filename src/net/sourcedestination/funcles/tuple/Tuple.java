/* Copyright 2011-2014 Joseph Kendall-Morwick

     This file is part of the Funcles library.

    Funcles is free software: you can redistribute it and/or modify
    it under the terms of the Lesser GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Funcles is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    Lesser GNU General Public License for more details.

    You should have received a copy of the Lesser GNU General Public License
    along with Funcles.  If not, see <http://www.gnu.org/licenses/>.

 */

package net.sourcedestination.funcles.tuple;

//TODO: add a copy-on-modify method to modify tuples. 

import java.io.Serializable;

/** Abstract class for all tuples

  @author Joseph Kendall-Morwick <jmorwick@indiana.edu>
  @version 2.0
 */
public class Tuple implements Serializable {
    private int size;

    /** constructor for abstract tuple class which tracks tuple properties
     *
     * @param mutable whether or not this tuple can be altered
     * @param size number of elements in this tuple
     */
    public Tuple(int size) {
        this.size = size;
    }

    /** the number of elements in this tuple
     *
     * @return the number of elements in this tuple
     */
    public int size() { return size; }

    
    
    public static <A1, A2> Tuple2<A1, A2> makeTuple(A1 _1, A2 _2) {
        return new Tuple2<A1, A2>(_1, _2);
    }
    
    public static <A1, A2, A3> Tuple3<A1, A2, A3> makeTuple(A1 _1, A2 _2, A3 _3) {
        return new Tuple3<A1, A2, A3>(_1, _2, _3);
    }
    
    public static <A1, A2, A3, A4> Tuple4<A1, A2, A3, A4> makeTuple(A1 _1, A2 _2, A3 _3, A4 _4) {
        return new Tuple4<A1, A2, A3, A4>(_1, _2, _3, _4);
    }
    
    public static <A1, A2, A3, A4, A5> Tuple5<A1, A2, A3, A4, A5> makeTuple(A1 _1, A2 _2, A3 _3, A4 _4, A5 _5) {
        return new Tuple5<A1, A2, A3, A4, A5>(_1, _2, _3, _4, _5);
    }
    
}
