package annotations;

import annotations.retention.runtime.RetentionAnnotation;

public class Main {

    public static void main(String[] args) {
        RetentionAnnotation retentionAnnotation = new RetentionAnnotation();
        retentionAnnotation.executeMethod();
    }
}
