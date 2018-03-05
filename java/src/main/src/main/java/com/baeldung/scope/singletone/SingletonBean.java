package com.baeldung.scope.singletone;

import com.baeldung.scope.prototype.PrototypeBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Gebruiker on 3/1/2018.
 */
public class SingletonBean {

        private final Logger logger = Logger.getLogger(this.getClass());

        @Autowired
        private PrototypeBean prototypeBean;

        public SingletonBean() {
                System.out.println("Singleton instance created");
                logger.info("Singleton instance created");
        }

        public PrototypeBean getPrototypeBean() {
                logger.info(String.valueOf(LocalTime.now()));
                System.out.println(LocalTime.now());
                return prototypeBean;
        }
}
