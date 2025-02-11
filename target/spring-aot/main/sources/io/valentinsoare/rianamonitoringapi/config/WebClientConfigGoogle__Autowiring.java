package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link WebClientConfigGoogle}.
 */
public class WebClientConfigGoogle__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static WebClientConfigGoogle apply(RegisteredBean registeredBean,
      WebClientConfigGoogle instance) {
    AutowiredFieldValueResolver.forRequiredField("googleResolverUrl").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("bufferSize").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
