package org.springdoc.webflux.ui;

import java.util.Optional;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.core.providers.SpringWebProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerConfig}.
 */
public class SwaggerConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'swaggerConfig'.
   */
  public static BeanDefinition getSwaggerConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerConfig.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SwaggerConfig::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerWelcome'.
   */
  private static BeanInstanceSupplier<SwaggerWelcomeWebFlux> getSwaggerWelcomeInstanceSupplier() {
    return BeanInstanceSupplier.<SwaggerWelcomeWebFlux>forFactoryMethod(SwaggerConfig.class, "swaggerWelcome", SwaggerUiConfigProperties.class, SpringDocConfigProperties.class, SwaggerUiConfigParameters.class, SpringWebProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerWelcome(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'swaggerWelcome'.
   */
  public static BeanDefinition getSwaggerWelcomeBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerWelcomeWebFlux.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerWelcomeInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerConfigResource'.
   */
  private static BeanInstanceSupplier<SwaggerConfigResource> getSwaggerConfigResourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerConfigResource>forFactoryMethod(SwaggerConfig.class, "swaggerConfigResource", SwaggerWelcomeCommon.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerConfigResource(args.get(0)));
  }

  /**
   * Get the bean definition for 'swaggerConfigResource'.
   */
  public static BeanDefinition getSwaggerConfigResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerConfigResource.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerConfigResourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerWebFluxConfigurer'.
   */
  private static BeanInstanceSupplier<SwaggerWebFluxConfigurer> getSwaggerWebFluxConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerWebFluxConfigurer>forFactoryMethod(SwaggerConfig.class, "swaggerWebFluxConfigurer", SwaggerUiConfigParameters.class, SpringDocConfigProperties.class, SwaggerIndexTransformer.class, Optional.class, SwaggerResourceResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerWebFluxConfigurer(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'swaggerWebFluxConfigurer'.
   */
  public static BeanDefinition getSwaggerWebFluxConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerWebFluxConfigurer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerWebFluxConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'indexPageTransformer'.
   */
  private static BeanInstanceSupplier<SwaggerIndexTransformer> getIndexPageTransformerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerIndexTransformer>forFactoryMethod(SwaggerConfig.class, "indexPageTransformer", SwaggerUiConfigProperties.class, SwaggerUiOAuthProperties.class, SwaggerUiConfigParameters.class, SwaggerWelcomeCommon.class, ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).indexPageTransformer(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'indexPageTransformer'.
   */
  public static BeanDefinition getIndexPageTransformerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerIndexTransformer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getIndexPageTransformerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerResourceResolver'.
   */
  private static BeanInstanceSupplier<SwaggerResourceResolver> getSwaggerResourceResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerResourceResolver>forFactoryMethod(SwaggerConfig.class, "swaggerResourceResolver", SwaggerUiConfigProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerResourceResolver(args.get(0)));
  }

  /**
   * Get the bean definition for 'swaggerResourceResolver'.
   */
  public static BeanDefinition getSwaggerResourceResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerResourceResolver.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerResourceResolverInstanceSupplier());
    return beanDefinition;
  }
}
