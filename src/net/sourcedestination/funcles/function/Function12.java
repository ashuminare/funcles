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

package net.sourcedestination.funcles.function;

import java.util.function.Function;

import net.sourcedestination.funcles.tuple.*;

import static net.sourcedestination.funcles.tuple.Tuple.makeTuple;


/** 
 *
 * @author Joseph Kendall-Morwick &lt;jbmorwick@gmail.com&gt;
 * @version 2.0
 */
@FunctionalInterface
public interface Function12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, R> extends Function<Tuple12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>, R> {
	default R apply(Tuple12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12> args) {
		return apply(args._1, args._2, args._3, args._4, args._5, args._6, args._7, args._8, args._9, args._10, args._11, args._12);
	}

	R apply(A1 arg1, A2 arg2, A3 arg3, A4 arg4, A5 arg5, A6 arg6, A7 arg7, A8 arg8, A9 arg9, A10 arg10, A11 arg11, A12 arg12);
	
	
	default Function11<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, R> bind1(A1 arg) {
	    return (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) -> apply(arg, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, R> bind2(A2 arg) {
	    return (a1, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) -> apply(a1, arg, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A4, A5, A6, A7, A8, A9, A10, A11, A12, R> bind3(A3 arg) {
	    return (a1, a2, a4, a5, a6, a7, a8, a9, a10, a11, a12) -> apply(a1, a2, arg, a4, a5, a6, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A5, A6, A7, A8, A9, A10, A11, A12, R> bind4(A4 arg) {
	    return (a1, a2, a3, a5, a6, a7, a8, a9, a10, a11, a12) -> apply(a1, a2, a3, arg, a5, a6, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A6, A7, A8, A9, A10, A11, A12, R> bind5(A5 arg) {
	    return (a1, a2, a3, a4, a6, a7, a8, a9, a10, a11, a12) -> apply(a1, a2, a3, a4, arg, a6, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A7, A8, A9, A10, A11, A12, R> bind6(A6 arg) {
	    return (a1, a2, a3, a4, a5, a7, a8, a9, a10, a11, a12) -> apply(a1, a2, a3, a4, a5, arg, a7, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A8, A9, A10, A11, A12, R> bind7(A7 arg) {
	    return (a1, a2, a3, a4, a5, a6, a8, a9, a10, a11, a12) -> apply(a1, a2, a3, a4, a5, a6, arg, a8, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A7, A9, A10, A11, A12, R> bind8(A8 arg) {
	    return (a1, a2, a3, a4, a5, a6, a7, a9, a10, a11, a12) -> apply(a1, a2, a3, a4, a5, a6, a7, arg, a9, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A7, A8, A10, A11, A12, R> bind9(A9 arg) {
	    return (a1, a2, a3, a4, a5, a6, a7, a8, a10, a11, a12) -> apply(a1, a2, a3, a4, a5, a6, a7, a8, arg, a10, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A7, A8, A9, A11, A12, R> bind10(A10 arg) {
	    return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a11, a12) -> apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, arg, a11, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A12, R> bind11(A11 arg) {
	    return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a12) -> apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, arg, a12);
	}
	
	default Function11<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, R> bind12(A12 arg) {
	    return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) -> apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, arg);
	}
	
	static <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12,R> Function12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12,R>
		toFunction12(Function<Tuple12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>, R> f) {
		return (arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12) -> 
		  f.apply(makeTuple(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12));
	}
	
	static <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, R> Function12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12,R>
		 applyHigherOrder(Function< ? super Function12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12,R>, 
				                   ? extends Function<Tuple12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>,R>> hof,
				          Function12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12,R> f) {
		return toFunction12(hof.apply(f));
	}
			
}
