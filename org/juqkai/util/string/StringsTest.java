package org.juqkai.util.string;

import static org.junit.Assert.*;

import org.junit.Test;
public class StringsTest {
	
	@Test
	public void testjoint(){
		String x = Strings.joint("|", 1,2,3);
		String y = "1|2|3";
		assertEquals(y, x);
	}
	
	@Test
	public void format(){
		assertEquals(Strings.format("zk{}xx", 1), "zk1xx");
		assertEquals(Strings.format("zk{}", 1), "zk1");
		assertEquals(Strings.format("zk{}", 1,1), "zk1");
		assertEquals(Strings.format("zk{}a{}b{}c", 1,1), "zk1a1bc");
		assertEquals(Strings.format("zk{}a{}{}c", 1,1,1), "zk1a11c");
		assertEquals(Strings.format("{},{}", 1,1), "1,1");
		assertEquals(Strings.format("{}{}_", 1,1), "11_");
		assertEquals(Strings.format("{}", 1,1), "1");
		assertEquals(Strings.format("{}{}", 1,1), "11");
		assertEquals(Strings.format("{}{}{}{}{}{}", 1,1,1,1,1), "11111");
	}
	
	public void toMath(){
		assertEquals((Integer)(-1), Strings.toInt(null));
		assertEquals((Integer)(-1), Strings.toInt("zk"));
		assertEquals((Integer)2, Strings.toInt("2"));
	}
}
