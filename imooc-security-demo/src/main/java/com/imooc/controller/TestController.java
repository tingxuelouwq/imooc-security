package com.imooc.controller;

import com.imooc.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @类名: TestController<br />
 * @包名：com.imooc.controller<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/10 22:20<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@RestController
@RequestMapping("/test1")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskExecutor taskExecutor;

    @RequestMapping("/testTaskExecutor")
    public String testTaskExecutor() {
        logger.info("TestTaskExecutor function begin to execute!");
        taskExecutor.execute(() -> {
            logger.info("Real thread begin to execute!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.error("Real thread was interrupted!", e);
                return;
            }
            logger.info("Real thread has been executed!");
        });
        logger.info("TestTaskExecutor function has been executed!");
        return "Succeed!";
    }

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/testAsync")
    public String testAsync() {
        logger.info("TestAsync begins to execute!");
        asyncService.testAsync();
        logger.info("TestAsync execution completed");
        return "End!";
    }

    @RequestMapping("/testCallable")
    public Callable<String> testCallable() {
        logger.info("Controller开始执行！");
        Callable<String> callable = () -> {
            Thread.sleep(5000);
            logger.info("实际工作执行完成！");
            return "succeed!";
        };
        logger.info("Controller执行结束！");
        return callable;
    }
}
