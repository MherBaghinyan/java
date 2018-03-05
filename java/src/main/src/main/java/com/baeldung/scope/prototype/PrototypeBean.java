package com.baeldung.scope.prototype;

import org.apache.log4j.Logger;

/**
 * Created by Gebruiker on 3/1/2018.
 */
public class PrototypeBean {

        private final Logger logger = Logger.getLogger(this.getClass());

        public PrototypeBean() {
                System.out.println("Prototype instance created");
                logger.info("Prototype instance created");
        }
}
