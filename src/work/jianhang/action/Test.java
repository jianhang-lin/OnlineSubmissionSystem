package work.jianhang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.debug("测试logback日志..");
        logger.info("测试logback日志..");
        logger.error("测试logback日志..");

    }
}
