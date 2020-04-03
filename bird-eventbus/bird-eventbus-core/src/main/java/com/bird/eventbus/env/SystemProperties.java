
package com.bird.eventbus.env;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author leihtg
 * @date 2020/4/3 18:10
 */
public class SystemProperties extends PropertySource<String> {

    /**
     * Name of the system {@link PropertySource}.
     */
    public static final String  RANDOM_PROPERTY_SOURCE_NAME = "system";

    private static final String PREFIX                      = "system.";

    public SystemProperties() {

        super(RANDOM_PROPERTY_SOURCE_NAME);
    }

    public SystemProperties(String name) {

        super(name, new String());
    }

    @Override
    public Object getProperty(String s) {

        if (!name.startsWith(PREFIX)) {
            return null;
        }
        if (logger.isTraceEnabled()) {
            logger.trace("Generating random property for '" + name + "'");
        }
        return getPropertyValue(name.substring(PREFIX.length()));
    }

    private Object getPropertyValue(String prop) {

        return System.getProperty(prop);
    }

    public static void addToEnvironment(ConfigurableEnvironment environment) {

        environment.getPropertySources().addAfter(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME,
                                                  new SystemProperties(RANDOM_PROPERTY_SOURCE_NAME));
    }
}
