package io.valentinsoare.rianamonitoringapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import java.lang.String;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link OpenAPIConfig}.
 */
public class OpenAPIConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'openAPIConfig'.
   */
  public static BeanDefinition getOpenAPIConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenAPIConfig.class);
    beanDefinition.setTargetType(OpenAPIConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(OpenAPIConfig.class);
    beanDefinition.setInstanceSupplier(OpenAPIConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'actuatorApi'.
   */
  private static BeanInstanceSupplier<GroupedOpenApi> getActuatorApiInstanceSupplier() {
    return BeanInstanceSupplier.<GroupedOpenApi>forFactoryMethod(OpenAPIConfig.class, "actuatorApi")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(OpenAPIConfig.class).actuatorApi());
  }

  /**
   * Get the bean definition for 'actuatorApi'.
   */
  public static BeanDefinition getActuatorApiBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GroupedOpenApi.class);
    beanDefinition.setInstanceSupplier(getActuatorApiInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'customOpenAPI'.
   */
  private static BeanInstanceSupplier<GroupedOpenApi> getCustomOpenAPIInstanceSupplier() {
    return BeanInstanceSupplier.<GroupedOpenApi>forFactoryMethod(OpenAPIConfig.class, "customOpenAPI")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(OpenAPIConfig.class).customOpenAPI());
  }

  /**
   * Get the bean definition for 'customOpenAPI'.
   */
  public static BeanDefinition getCustomOpenAPIBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GroupedOpenApi.class);
    beanDefinition.setInstanceSupplier(getCustomOpenAPIInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'rianaMonitoringAPI'.
   */
  private static BeanInstanceSupplier<OpenAPI> getRianaMonitoringAPIInstanceSupplier() {
    return BeanInstanceSupplier.<OpenAPI>forFactoryMethod(OpenAPIConfig.class, "rianaMonitoringAPI", String.class, String.class, String.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OpenAPIConfig.class).rianaMonitoringAPI(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'rianaMonitoringAPI'.
   */
  public static BeanDefinition getRianaMonitoringAPIBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenAPI.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setInstanceSupplier(getRianaMonitoringAPIInstanceSupplier());
    return beanDefinition;
  }
}
