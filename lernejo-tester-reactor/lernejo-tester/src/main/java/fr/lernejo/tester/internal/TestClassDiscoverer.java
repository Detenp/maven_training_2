package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    private final String package_name;

    public TestClassDiscoverer(String package_name) {
        this.package_name = package_name;
    }

    public List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections(package_name,  new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        return allTypes.stream().map(TestClassDescription::new).filter(e -> e.listTestMethods().isEmpty()).toList();
    }

}
