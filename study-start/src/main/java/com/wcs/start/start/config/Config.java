package com.wcs.start.start.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * TODO 类描述
 *
 * @author pro
 */
@Component
public class Config extends AbstractConfig implements InitializingBean  {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("config");
    }
}
