package app;

import bean.HelloWorldConfigByAnnonation;
import bean.HelloWorldConfigByXml;
import bean.IIntroduce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rantianhua on 17/1/2.
 */
public class Print {

    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorldConfigByXml helloBean = (HelloWorldConfigByXml) springContext.getBean("helloBean");
        System.out.println(helloBean);
        helloBean.getIntroduce().introduce();

        springContext = new AnnotationConfigApplicationContext(HelloWorldConfigByAnnonation.class);
        IIntroduce introduce = (IIntroduce) springContext.getBean("introduce");
        introduce.introduce();
    }
}
