package com.baeldung.scope;

import com.baeldung.scope.prototype.PrototypeBean;
import com.baeldung.scope.singletone.SingletonBean;
import com.baeldung.scope.singletone.SingletonObjectFactoryBean;
import com.baeldung.scope.singletone.SingletonProviderBean;
import com.baeldung.scope.singletone.SingletonAppContextBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.baeldung.scope")
public class AppConfig {

        @Bean
        @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        public PrototypeBean prototypeBean() {
                return new PrototypeBean();
        }

        @Bean
        public SingletonBean singletonBean() {
                return new SingletonBean();
        }

        @Bean
        public SingletonProviderBean singletonProviderBean() {
                return new SingletonProviderBean();
        }

        @Bean
        public SingletonAppContextBean singletoneAppContextBean() {
                return new SingletonAppContextBean();
        }

        @Bean
        public SingletonObjectFactoryBean singletonObjectFactoryBean() {
                return new SingletonObjectFactoryBean();
        }
}
