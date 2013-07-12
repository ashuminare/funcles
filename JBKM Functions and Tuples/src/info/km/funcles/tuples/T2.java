/* Copyright 2011-2013 Joseph Kendall-Morwick

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


package info.km.funcles.tuples;

import info.km.funcles.Tuple;

/** A class representing a 2-tuple
 *


  @author Joseph Kendall-Morwick <jmorwick@indiana.edu>
  @version 0.1

  */
public class T2 <A1, A2> extends Tuple {
    private A1 a1;
    private A2 a2;

    public T2(A1 a, A2 b) {
        this(a, b, false);
    }

    public T2(A1 a1, A2 a2, boolean mutable) {
        super(mutable,2);
        this.a1 = a1;
        this.a2 = a2;
    }

    public A1 a1() { return a1; }
    public A2 a2() { return a2; }

    public void setA1(A1 a1) { if(isMutable()) this.a1 = a1; }
    public void setA2(A2 a2) { if(isMutable()) this.a2 = a2; }


    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        try {
            T2<A1,A2> t = (T2<A1,A2>)obj;
            if(a1 == null && t.a1 != null) return false;
            else if(a1 != null && t.a1 == null) return false;
            else if(a1 != null && t.a1 != null && !a1.equals(t.a1)) return false;
            if(a2 == null && t.a2 != null) return false;
            else if(a2 != null && t.a2 == null) return false;
            else if(a2 != null && t.a2 != null && !a2.equals(t.a2)) return false;
            return true;
        }catch(ClassCastException e) { return false; }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.a1 != null ? this.a1.hashCode() : 0);
        hash = 79 * hash + (this.a2 != null ? this.a2.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() { return "["+a1+","+a2+"]"; }
}
