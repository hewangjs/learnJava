package com.xml.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.Test;

public class XMLUtilsTest {

	@Test
	public void testReadXMLFile() throws DocumentException, IOException {
		assertEquals(true, new XMLUtils().readXMLFile());
	}

}
