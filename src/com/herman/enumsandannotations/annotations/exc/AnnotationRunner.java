package com.herman.enumsandannotations.annotations.exc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationRunner {
    public static void main(String[] args) throws Exception {
        Class<?> forName = Class.forName("com.herman.enumsandannotations.annotations.exc.Sample");

        int tests = 0;
        int passed = 0;

        for (Method method: forName.getDeclaredMethods()) {
            tests++;
            if (method.isAnnotationPresent(ExceptionsTest.class)
                || method.isAnnotationPresent(ExceptionTestContainer.class)) {
                try {
                    method.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", method);
                } catch (InvocationTargetException wrappedException) {
                    Throwable actualException = wrappedException.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] expectedExceptionTypes = method.getAnnotation(ExceptionsTest.class).values();

                    for (Class<? extends Throwable> expectedAnnotationType : expectedExceptionTypes) {
                        if (expectedAnnotationType.isInstance(actualException)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", method, actualException);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @ExceptionTest: " + method);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
