package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link WebClientConfigInfoBlox}.
 */
public class WebClientConfigInfoBlox__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static WebClientConfigInfoBlox apply(RegisteredBean registeredBean,
      WebClientConfigInfoBlox instance) {
    AutowiredFieldValueResolver.forRequiredField("userName").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("password").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("infoBloxUrl").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("bufferSize").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
