/* Copyright 2011-2017 Joseph Kendall-Morwick

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

import net.sourcedestination.funcles.consumer.Consumer7;



/**  A class representing a 7-tuple
 *


  @author Joseph Kendall-Morwick &lt;jbmorwick@gmail.com&gt;
  @version 2.0

  */
public class Tuple7<A1, A2, A3, A4, A5, A6, A7> extends Tuple<Tuple7<A1, A2, A3, A4, A5, A6, A7>> {
	private static final long serialVersionUID = 1L;
    public final A1 _1;
    public final A2 _2;
    public final A3 _3;
    public final A4 _4;
    public final A5 _5;
    public final A6 _6;
    public final A7 _7;

    public Tuple7(A1 _1, A2 _2, A3 _3, A4 _4, A5 _5, A6 _6, A7 _7) {
        super(7);
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
    }
    
    public A1 _1() { return _1; }
    public A2 _2() { return _2; }
    public A3 _3() { return _3; }
    public A4 _4() { return _4; }
    public A5 _5() { return _5; }
    public A6 _6() { return _6; }
    public A7 _7() { return _7; }

	/** a simple way to unpack a tuple with  arguments to an anonymous consumer
	 * @param c Consumer to accept the values in this tuple
	 */
	public void unpack(Consumer7<A1, A2, A3, A4, A5, A6, A7> c) {
	    c.accept(this);
	}

	/** copies this tuple and returns a new tuple with value #1 replaced by newValue
	 * @param newValue value to include at location 1	 * @return a new tuple with the new value at location 1	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set1(A1 newValue) {
	    return makeTuple(newValue, _2, _3, _4, _5, _6, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #2 replaced by newValue
	 * @param newValue value to include at location 2	 * @return a new tuple with the new value at location 2	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set2(A2 newValue) {
	    return makeTuple(_1, newValue, _3, _4, _5, _6, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #3 replaced by newValue
	 * @param newValue value to include at location 3	 * @return a new tuple with the new value at location 3	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set3(A3 newValue) {
	    return makeTuple(_1, _2, newValue, _4, _5, _6, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #4 replaced by newValue
	 * @param newValue value to include at location 4	 * @return a new tuple with the new value at location 4	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set4(A4 newValue) {
	    return makeTuple(_1, _2, _3, newValue, _5, _6, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #5 replaced by newValue
	 * @param newValue value to include at location 5	 * @return a new tuple with the new value at location 5	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set5(A5 newValue) {
	    return makeTuple(_1, _2, _3, _4, newValue, _6, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #6 replaced by newValue
	 * @param newValue value to include at location 6	 * @return a new tuple with the new value at location 6	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set6(A6 newValue) {
	    return makeTuple(_1, _2, _3, _4, _5, newValue, _7);
	}
	

	/** copies this tuple and returns a new tuple with value #7 replaced by newValue
	 * @param newValue value to include at location 7	 * @return a new tuple with the new value at location 7	 */
	public Tuple7<A1, A2, A3, A4, A5, A6, A7> set7(A7 newValue) {
	    return makeTuple(_1, _2, _3, _4, _5, _6, newValue);
	}
	
	
    @Override
    @SuppressWarnings({ "unchecked" })
    public boolean equals(Object obj) {
        try {
            Tuple7<A1, A2, A3, A4, A5, A6, A7> t = (Tuple7<A1, A2, A3, A4, A5, A6, A7>)obj;
            if(_1 == null && t._1 != null) return false;
            if(_1 != null && t._1 == null) return false;
            if(_1 != null && t._1 != null && !_1.equals(t._1)) return false;
            if(_2 == null && t._2 != null) return false;
            if(_2 != null && t._2 == null) return false;
            if(_2 != null && t._2 != null && !_2.equals(t._2)) return false;
            if(_3 == null && t._3 != null) return false;
            if(_3 != null && t._3 == null) return false;
            if(_3 != null && t._3 != null && !_3.equals(t._3)) return false;
            if(_4 == null && t._4 != null) return false;
            if(_4 != null && t._4 == null) return false;
            if(_4 != null && t._4 != null && !_4.equals(t._4)) return false;
            if(_5 == null && t._5 != null) return false;
            if(_5 != null && t._5 == null) return false;
            if(_5 != null && t._5 != null && !_5.equals(t._5)) return false;
            if(_6 == null && t._6 != null) return false;
            if(_6 != null && t._6 == null) return false;
            if(_6 != null && t._6 != null && !_6.equals(t._6)) return false;
            if(_7 == null && t._7 != null) return false;
            if(_7 != null && t._7 == null) return false;
            if(_7 != null && t._7 != null && !_7.equals(t._7)) return false;          

            return true;
        }catch(ClassCastException e) { return false; }
    }

    @Override
    public int hashCode() {
        int hash = 7;
       hash = 17 * hash + (this._1 != null ? this._1.hashCode() : 0);
       hash = 17 * hash + (this._2 != null ? this._2.hashCode() : 0);
       hash = 17 * hash + (this._3 != null ? this._3.hashCode() : 0);
       hash = 17 * hash + (this._4 != null ? this._4.hashCode() : 0);
       hash = 17 * hash + (this._5 != null ? this._5.hashCode() : 0);
       hash = 17 * hash + (this._6 != null ? this._6.hashCode() : 0);
       hash = 17 * hash + (this._7 != null ? this._7.hashCode() : 0);   
        return hash;
    }

	/** attempts to compare this tuple to another tuple using the common Comparable semantics.
	 * @throws ClassCastException if any type within the tuple doesn't implement Comparable
	 * @param t tuple to compare this tuple to
	 * @return 0 if the same, other values indicate a difference
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compareTo(Tuple7<A1, A2, A3, A4, A5, A6, A7> t) {
		int r;
		r = ((Comparable)_1).compareTo(t._1);
		if(r != 0) return r;
		r = ((Comparable)_2).compareTo(t._2);
		if(r != 0) return r;
		r = ((Comparable)_3).compareTo(t._3);
		if(r != 0) return r;
		r = ((Comparable)_4).compareTo(t._4);
		if(r != 0) return r;
		r = ((Comparable)_5).compareTo(t._5);
		if(r != 0) return r;
		r = ((Comparable)_6).compareTo(t._6);
		if(r != 0) return r;
		r = ((Comparable)_7).compareTo(t._7);
		if(r != 0) return r;
		return r;
	}

    @Override
    public String toString() { return "["+_1+","+_2+","+_3+","+_4+","+_5+","+_6+","+_7+"]"; }
}
