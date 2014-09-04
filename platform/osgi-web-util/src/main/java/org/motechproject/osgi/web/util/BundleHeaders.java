package org.motechproject.osgi.web.util;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;

public class BundleHeaders {

    public static final String BLUEPRINT_ENABLED = "Blueprint-Enabled";
    public static final String CONTEXT_PATH = "Context-Path";
    public static final String RESOURCE_PATH = "Resource-Path";

    private final Dictionary headers;

    public BundleHeaders(BundleContext bundleContext) {
        this(bundleContext.getBundle());
    }

    public BundleHeaders(Bundle bundle) {
        headers = bundle.getHeaders();
    }

    public Object get(Object key) {
        return headers.get(key);
    }

    public String getContextPath() {
        return getStringValue(CONTEXT_PATH);
    }

    public String getResourcePath() {
        return getStringValue(RESOURCE_PATH);
    }

    public String getSymbolicName() {
        return getStringValue("Bundle-SymbolicName");
    }

    public String getName() {
        return getStringValue("Bundle-Name");
    }

    public String getVersion() {
        return getStringValue("Bundle-Version");
    }

    public String getStringValue(String key) {
        return (String) get(key);
    }

    public boolean isBluePrintEnabled() {
        return Boolean.valueOf(getStringValue(BLUEPRINT_ENABLED));
    }
}
