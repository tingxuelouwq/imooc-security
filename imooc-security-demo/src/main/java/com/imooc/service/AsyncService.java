package com.imooc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @类名: AsyncService<br />
 * @包名：com.imooc.service<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/10 22:33<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void testAsync() {
        logger.info("AsyncService begins to execute!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("AsyncService was interrupted!", e);
            return;
        }
        logger.info("AsyncService execution completed!");
    }
}
