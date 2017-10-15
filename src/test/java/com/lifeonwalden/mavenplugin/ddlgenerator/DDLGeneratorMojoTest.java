package com.lifeonwalden.mavenplugin.ddlgenerator;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class DDLGeneratorMojoTest extends AbstractMojoTestCase {
    @Before
    protected void setUp() throws Exception {
        super.setUp();
    }

    @After
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSomething() throws Exception {
        File pom = getTestFile("src/test/resources/unit/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        DDLGeneratorMojo myMojo = (DDLGeneratorMojo) lookupMojo("install", pom);
        assertNotNull(myMojo);
        myMojo.execute();
    }
}
