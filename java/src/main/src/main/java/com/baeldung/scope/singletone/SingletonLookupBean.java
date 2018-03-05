package com.baeldung.scope.singletone;

import com.baeldung.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Created by Gebruiker on 3/1/2018.
 */
//https://www.logicbig.com/tutorials/spring-framework/spring-core/using-lookup-method.html
//https://netjs.blogspot.am/2016/02/injecting-prototype-bean-in-singleton-spring.html
@Component
public class SingletonLookupBean {

        @Lookup
        public PrototypeBean getPrototypeBean(){
                return null;
        }
}
