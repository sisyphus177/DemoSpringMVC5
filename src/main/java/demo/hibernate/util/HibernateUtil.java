package demo.hibernate.util;

/**
 * Created by raist on 2016/4/27.
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("unused")
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /**
     * @return 获取会话工厂
     */
    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory==null){
            //第一步:读取Hibernate的配置文件  hibernate.cfg.xml文件
            Configuration configuration = new Configuration().configure();
            //第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
            //创建注册服务
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
            //第三步:创建会话工厂
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

    /**
     * @return 获取会话对象
     */
    public static Session getSession()
    {
        return getSessionFactory().openSession();
    }

}
