package io.bytesbiter.servlet.servletsampleone;

import java.io.IOException;

public class OneStaticResoureProcessor {

    public void process(OneRequest request, OneResponse response) {
        response.sendStaticResource();
    }

}
