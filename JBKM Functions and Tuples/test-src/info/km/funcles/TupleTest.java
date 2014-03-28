package info.km.funcles;

import static org.junit.Assert.*;
import static info.km.funcles.Tuple.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TupleTest {


	@Test
	public void makeMutableTuple() {
		T2<String, String> t2 = Tuple.makeMutableTuple("hi", "there");
		assertNotNull(t2);
		assertEquals(2, t2.size());
		assertTrue(t2.isMutable());
		assertEquals("hi", t2.a1());
		assertEquals("there", t2.a2());
		t2.setA1("what's");
		t2.setA2("up?");
		assertEquals("what's", t2.a1());
		assertEquals("up?", t2.a2());

		T3<Integer, Integer, Integer> t3 = 
				Tuple.makeMutableTuple(1, 2, 3);
		assertNotNull(t3);
		assertEquals(3, t3.size());
		assertEquals((Integer)1, t3.a1());
		assertEquals((Integer)2, t3.a2());
		assertEquals((Integer)3, t3.a3());
		t3.setA1(6);
		t3.setA2(7);
		t3.setA3(8);
		assertEquals((Integer)6, t3.a1());
		assertEquals((Integer)7, t3.a2());
		assertEquals((Integer)8, t3.a3());

		T4<Integer, Integer, Integer, Integer> t4 = 
				Tuple.makeMutableTuple(1, 2, 3, 4);
		assertNotNull(t4);
		assertEquals(4, t4.size());
		assertEquals((Integer)1, t4.a1());
		assertEquals((Integer)2, t4.a2());
		assertEquals((Integer)3, t4.a3());
		assertEquals((Integer)4, t4.a4());
		t4.setA1(6);
		t4.setA2(7);
		t4.setA3(8);
		t4.setA4(9);
		assertEquals((Integer)6, t4.a1());
		assertEquals((Integer)7, t4.a2());
		assertEquals((Integer)8, t4.a3());
		assertEquals((Integer)9, t4.a4());

		T5<Integer, Integer, Integer, Integer, Integer> t5 = 
				Tuple.makeMutableTuple(1, 2, 3, 4, 5);
		assertNotNull(t5);
		assertEquals(5, t5.size());
		assertEquals((Integer)1, t5.a1());
		assertEquals((Integer)2, t5.a2());
		assertEquals((Integer)3, t5.a3());
		assertEquals((Integer)4, t5.a4());
		assertEquals((Integer)5, t5.a5());
		t5.setA1(6);
		t5.setA2(7);
		t5.setA3(8);
		t5.setA4(9);
		t5.setA5(10);
		assertEquals((Integer)6, t5.a1());
		assertEquals((Integer)7, t5.a2());
		assertEquals((Integer)8, t5.a3());
		assertEquals((Integer)9, t5.a4());
		assertEquals((Integer)10, t5.a5());
	}
	
	@Test
	public void testMakeImmutableTuple() {
		String msg = "attempted modification of immutable tuple";
		T2<String, String> t2 = Tuple.makeTuple("hi", "there");
		assertNotNull(t2);
		assertEquals(2, t2.size());
		assertFalse(t2.isMutable());
		assertEquals("hi", t2.a1());
		assertEquals("there", t2.a2());
		try{ t2.setA1("what's"); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t2.setA2("up?"); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		assertEquals("hi", t2.a1());
		assertEquals("there", t2.a2());

		T3<Integer, Integer, Integer> t3 = 
				Tuple.makeTuple(1, 2, 3);
		assertNotNull(t3);
		assertEquals(3, t3.size());
		assertFalse(t3.isMutable());
		assertEquals((Integer)1, t3.a1());
		assertEquals((Integer)2, t3.a2());
		assertEquals((Integer)3, t3.a3());
		try{ t3.setA1(6); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t3.setA2(7); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t3.setA3(8); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		assertEquals((Integer)1, t3.a1());
		assertEquals((Integer)2, t3.a2());
		assertEquals((Integer)3, t3.a3());

		T4<Integer, Integer, Integer, Integer> t4 = 
				Tuple.makeTuple(1, 2, 3, 4);
		assertNotNull(t4);
		assertEquals(4, t4.size());
		assertFalse(t4.isMutable());
		assertEquals((Integer)1, t4.a1());
		assertEquals((Integer)2, t4.a2());
		assertEquals((Integer)3, t4.a3());
		assertEquals((Integer)4, t4.a4());
		try{ t4.setA1(6); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t4.setA2(7); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t4.setA3(8); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t4.setA4(9); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		assertEquals((Integer)1, t4.a1());
		assertEquals((Integer)2, t4.a2());
		assertEquals((Integer)3, t4.a3());
		assertEquals((Integer)4, t4.a4());

		T5<Integer, Integer, Integer, Integer, Integer> t5 = 
				Tuple.makeTuple(1, 2, 3, 4, 5);
		assertNotNull(t5);
		assertEquals(5, t5.size());
		assertFalse(t5.isMutable());
		assertEquals((Integer)1, t5.a1());
		assertEquals((Integer)2, t5.a2());
		assertEquals((Integer)3, t5.a3());
		assertEquals((Integer)4, t5.a4());
		assertEquals((Integer)5, t5.a5());
		try{ t5.setA1(6); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t5.setA2(7); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t5.setA3(8); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t5.setA4(9); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		try{ t5.setA5(10); } 
		catch(RuntimeException e) { assertEquals(e.getMessage(), msg); }
		assertEquals((Integer)1, t5.a1());
		assertEquals((Integer)2, t5.a2());
		assertEquals((Integer)3, t5.a3());
		assertEquals((Integer)4, t5.a4());
		assertEquals((Integer)5, t5.a5());
	}


	@Test
	public void testEquals() {
		Tuple t2_1 = Tuple.makeTuple("hi", "there");
		T2<String,String> t2_2 = Tuple.makeMutableTuple("hi", "there");
		assertEquals(t2_1, t2_2);
		assertEquals(t2_2, t2_1);
		t2_2.setA2("blah");
		assertNotEquals(t2_1, t2_2);
		assertNotEquals(t2_2, t2_1);
		
		Tuple t3_1 = Tuple.makeTuple(1, 2, 3);
		Tuple t3_2 = Tuple.makeTuple(1,  2, 1 + 2);
		assertEquals(t3_1, t3_2);
		assertEquals(t3_2, t3_1);
		
		T2<T2<Integer,Integer>,T2<Integer,Integer>> t2_3 = 
				makeTuple(Tuple.makeMutableTuple(1,2), makeTuple(3,4));
		T2<T2<Integer,Integer>,T2<Integer,Integer>>  t2_4 = 
				makeTuple(Tuple.makeMutableTuple(1,2), makeTuple(3,4));
		assertEquals(t2_3, t2_4);
		assertEquals(t2_4, t2_3);
		t2_3.a1().setA1(9);
		assertNotEquals(t2_3, t2_4);
		assertNotEquals(t2_4, t2_3);
		t2_4.a1().setA1(9);
		assertEquals(t2_3, t2_4);
		assertEquals(t2_4, t2_3);
		
	}

	@Test
	public void testHashCode() {
		Set<Tuple> tuples = new HashSet<Tuple>();
		tuples.add(makeTuple(1, 2, 3));
		tuples.add(makeTuple(1, 23, 4, 3));
		tuples.add(makeTuple(1, 1));
		tuples.add(makeTuple("hi", "there"));
		tuples.add(makeTuple(1, "2"));
		assertEquals(5, tuples.size());
		
		Set<Integer> codes = new HashSet<Integer>();
		for(Tuple t : tuples)
			codes.add(t.hashCode());
		
		assertTrue(codes.size() > 1); //it's possible some codes will overlap
		
		assertEquals(
				makeTuple("hi", "there"),
				Tuple.makeMutableTuple("hi",  "there"));
	}

}
