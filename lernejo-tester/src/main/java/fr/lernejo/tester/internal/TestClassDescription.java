package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {
    private final Class<?> obj;

    public TestClassDescription(Class<?> obj) {
        this.obj = obj;
    }

    public List<Method> listTestMethods() {
        Method[] meths = obj.getDeclaredMethods();

        return Arrays.stream(meths)
                .filter(e -> e.getParameterCount() == 0
                        && e.getReturnType().equals(Void.TYPE)
                        && Modifier.isPublic(e.getModifiers())
                        && e.isAnnotationPresent(TestMethod.class)
                ).toList();
    }
}
