package com.imooc.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @类名: AsyncController<br />
 * @包名：com.imooc.controller<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/10 18:49<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public Callable<String> order() {
        logger.info("主线程开始");
        Callable<String> result = () -> {
            logger.info("子线程开始");
            Thread.sleep(1000);
            logger.info("子线程返回");
            return "success";
        };
        logger.info("主线程结束");
        return result;
    }

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/order2")
    public DeferredResult<String> order2() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        logger.info("主线程结束");
        return result;
    }
}
