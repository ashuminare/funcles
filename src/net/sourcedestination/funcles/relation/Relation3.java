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

package net.sourcedestination.funcles.relation;

import java.util.function.BiPredicate;

import net.sourcedestination.funcles.function.Function3;
import net.sourcedestination.funcles.tuple.Tuple3;

/** This class provides a clean abstraction for implementing binary relations
 *
 * @author Joseph Kendall-Morwick <jmorwick@indiana.edu>
 * @version 2.0
 */
@FunctionalInterface
public abstract interface Relation3<A1, A2, A3> extends Relation<Tuple3<A1, A2, A3>>, 
											   Function3<A1, A2, A3,Boolean> {
	
	public default Boolean apply(A1 arg1, A2 arg2, A3 arg3) {
		return test(arg1, arg2, arg3);
	}

	public default boolean test(Tuple3<A1, A2, A3> args) {
		return test(args._1, args._2, args._3);
	}

	public default Boolean apply(Tuple3<A1, A2, A3> args) {
		return test(args._1, args._2, args._3);
	}

	public boolean test(A1 arg1, A2 arg2, A3 arg3);
	
}
