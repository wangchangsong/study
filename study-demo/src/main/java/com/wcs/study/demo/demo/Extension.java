package com.wcs.study.demo.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Extension {

    private static final ConcurrentMap<String, Extension> EXTENSION_LOADERS = new ConcurrentHashMap<String, Extension>();

    public static Extension getInstance() {
        Extension extension = EXTENSION_LOADERS.get("extension");
        if (extension == null) {

        }
        return extension;
    }
}
