package com.baeldung.scope.singletone;

import com.baeldung.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Gebruiker on 3/1/2018.
 */
//http://dolszewski.com/spring/accessing-prototype-bean-in-singleton/
//https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/ObjectFactory.html
public class SingletonObjectFactoryBean {

        @Autowired
        private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

        public PrototypeBean getPrototypeInstance() {
                return prototypeBeanObjectFactory.getObject();
        }
}
