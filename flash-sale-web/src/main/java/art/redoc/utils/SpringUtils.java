package art.redoc.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext对象
     *
     * @param
     * @return org.springframework.context.ApplicationContext
     * @throws
     * @author sq
     * @date 2018/5/22 23:46
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据name获取Bean
     *
     * @param name
     * @return java.lang.Object
     * @throws
     * @author sq
     * @date 2018/5/22 23:46
     */
    public static Object getBeanByName(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 根据type获取bean
     *
     * @param clazz
     * @return
     */
    public static <T> T getBeanByType(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 跟库key获取application.properties value，优先读取jar包相同目录的外部yml properties 文件
     *
     * @param key
     * @return java.lang.String
     * @throws
     * @author sq
     * @date 2018/5/22 23:46
     */
    public static String getProperties(String key) {
        Environment environment = (Environment) SpringUtils.getBeanByName("environment");
        return environment.getProperty(key);
    }
}