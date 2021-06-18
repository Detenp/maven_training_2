package fr.lernejo.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;
import fr.lernejo.tester.internal.TestClassDescription;

import java.lang.reflect.Method;
import java.util.List;

class TestClassDescriptionLernejoTests {

    @TestMethod
    public void testListTestMethods() {
        TestClassDescription tcd = new TestClassDescription(SomeLernejoTests.class);

        List<Method> meths = tcd.listTestMethods();

        for (Method meth: meths) {
            if (!meth.getName().equals("ok") && !meth.getName().equals("ko")) {
                throw new IllegalStateException();
            }
        }
    }

    public static void main(String[] args) {
        new TestClassDescriptionLernejoTests().testListTestMethods();
    }
}
