package com.asop.jf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

public class PropertiUtil
{
  private static final transient Logger log = Logger.getLogger(PropertiUtil.class);
  private static final String PROPERTIES_FILENAME = "jdbc.properties";
  private static Properties properties;

  public static Properties getProperties()
  {
    return properties;
  }

  public static String getProperty(String key)
  {
    if (key == null) {
      return null;
    }
    return properties.getProperty(key);
  }

  public static int getNumerProperty(String key) {
    String value = properties.getProperty(key);
    if (NumberUtils.isNumber(value)) {
      return Integer.parseInt(value);
    }
    return 0;
  }

  public static void loadProperties(String filename)
  {
    InputStream in = null;
    ClassLoader threadContextClassLoader = Thread.currentThread().getContextClassLoader();
    properties = new Properties();
    if (threadContextClassLoader != null) {
      in = threadContextClassLoader.getResourceAsStream(filename);
    }
    if (in == null) {
      in = PropertiUtil.class.getResourceAsStream(filename);
      if (in == null)
        log.warn("No properties file found in the classpath by filename " + filename);
    }
    else {
      try {
        properties.load(in);
        log.info("Properties read " + properties);
      } catch (Exception e) {
        log.error("Error reading from " + filename, e);
      } finally {
        try {
          in.close();
        } catch (IOException e) {
          log.warn("IOException while closing InputStream: " + e.getMessage());
        }
      }
    }
  }

  static
  {
    loadProperties("jdbc.properties");
  }
}