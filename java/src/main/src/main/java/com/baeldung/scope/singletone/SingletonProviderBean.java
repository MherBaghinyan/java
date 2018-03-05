package com.baeldung.scope.singletone;

import com.baeldung.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Provider;

/**
 * Created by Gebruiker on 3/1/2018.
 */
//https://www.logicbig.com/tutorials/spring-framework/spring-core/using-jsr-330-provider.html
public class SingletonProviderBean {

        @Autowired
        private Provider<PrototypeBean> myPrototypeBeanProvider;

        public PrototypeBean getPrototypeInstance() {
                return myPrototypeBeanProvider.get();
        }
}
