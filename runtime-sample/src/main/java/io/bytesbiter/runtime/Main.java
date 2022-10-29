package io.bytesbiter.runtime;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

/**
 * Some runtime samples to handle runtime environment from within the application.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        // Get the Java Runtime
        Runtime runtime = Runtime.getRuntime();

        // The amount of max memory allocated to the JVM (processed manually)
        System.out.println(runtime.maxMemory() / 1024 / 1024 + "mb");
        // The amount of max memory allocated to the JVM (processed by library)
        System.out.println(FileUtils.byteCountToDisplaySize(runtime.maxMemory()));

        // The amount of unused memory allocated to the JVM (processed manually)
        System.out.println(runtime.freeMemory() / 1000 / 1000 + "mb");
        // The amount of unused memory allocated to the JVM (processed by library)
        System.out.println(FileUtils.byteCountToDisplaySize(runtime.freeMemory()));

        // The amount of processors allocated to the JVM
        System.out.println(runtime.availableProcessors());

        // Current process running
        System.out.println(ProcessHandle.current().pid());
        // Execute specific string command in separate processes
        System.out.println(runtime.exec("Command Placeholder One").pid());
        System.out.println(runtime.exec("Command Placeholder Two").pid());

        // Get current runtime version
        System.out.println(Runtime.version());

    }
}
