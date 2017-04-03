package curs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import curs.utils.StringUtils;

public class StringUtilTest {

	@Test
	public void testRevert() {
		assertEquals("dcba", StringUtils.revert("abcd"));
	}

}
