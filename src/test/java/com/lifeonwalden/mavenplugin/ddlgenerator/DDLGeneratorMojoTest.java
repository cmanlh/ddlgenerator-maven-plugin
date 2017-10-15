package com.lifeonwalden.mavenplugin.ddlgenerator;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class DDLGeneratorMojoTest extends AbstractMojoTestCase {
    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSomething() throws Exception {
        File pom = getTestFile("src/test/resources/unit/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        DDLGeneratorMojo myMojo = (DDLGeneratorMojo) lookupMojo("install", pom);
        assertNotNull(myMojo);
        myMojo.execute();
    }
}
