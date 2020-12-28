package com.lanceolata.code.snippets.basic.java.util;

public final class ClassUtils {

    private ClassUtils() {}

    /**
     * Instantiate the class
     */
    public static <T> T newInstance(Class<T> c) throws ClassNotFoundException {
        if (c == null)
            throw new ClassNotFoundException("class cannot be null");
        try {
            return c.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new ClassNotFoundException("Could not find a public no-argument constructor for " + c.getName(), e);
        } catch (ReflectiveOperationException | RuntimeException e) {
            throw new ClassNotFoundException("Could not instantiate class " + c.getName(), e);
        }
    }

    /**
     * Look up the class by name and instantiate it.
     * @param klass class name
     * @param base super class of the class to be instantiated
     * @param <T> the type of the base class
     * @return the new instance
     */
    public static <T> T newInstance(String klass, Class<T> base) throws ClassNotFoundException {
        return ClassUtils.newInstance(loadClass(klass, base));
    }

    /**
     * Look up a class by name.
     * @param klass class name
     * @param base super class of the class for verification
     * @param <T> the type of the base class
     * @return the new class
     */
    public static <T> Class<? extends T> loadClass(String klass, Class<T> base) throws ClassNotFoundException {
        return Class.forName(klass, true, ClassUtils.getThreadOrUtilsContextClassLoader()).asSubclass(base);
    }

    /**
     * Get the ClassLoader which loaded Kafka.
     */
    public static ClassLoader getUtilsClassLoader() {
        return ClassUtils.class.getClassLoader();
    }

    /**
     * Get the Context ClassLoader on this thread or, if not present, the ClassLoader that
     * loaded ClassUtils.
     *
     * This should be used whenever passing a ClassLoader to Class.forName
     */
    public static ClassLoader getThreadOrUtilsContextClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null)
            return getUtilsClassLoader();
        else
            return cl;
    }


}
