package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.util.List;

public class TestClassDiscovererLernejoTests {
    public void testTestClassDiscoverer() {
        TestClassDiscoverer tsc = new TestClassDiscoverer("fr.lernejo.tester");

        List<TestClassDescription> tcds = tsc.listTestClasses();

        //if (!(tcds.size() == 3))
        //    throw new IllegalStateException("Expected 3, got: " + tcds.size());
    }

    public static void main(String[] args) {
        new TestClassDiscovererLernejoTests().testTestClassDiscoverer();
    }
}
