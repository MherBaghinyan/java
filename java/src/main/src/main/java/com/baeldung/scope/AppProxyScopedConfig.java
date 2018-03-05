package com.baeldung.scope;

import com.baeldung.scope.prototype.PrototypeBean;
import com.baeldung.scope.singletone.SingletonBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * Created by Gebruiker on 3/1/2018.
 */
//https://www.logicbig.com/tutorials/spring-framework/spring-core/scoped-proxy.html
@Configuration
@ComponentScan("com.baeldung.scope")
public class AppProxyScopedConfig {

        @Bean
        @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
        public PrototypeBean prototypeBean() {
                return new PrototypeBean();
        }

        @Bean
        public SingletonBean singletonBean() {
                return new SingletonBean();
        }
}
