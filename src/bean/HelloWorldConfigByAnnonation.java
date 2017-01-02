package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rantianhua on 17/1/2.
 */
@Configuration
public class HelloWorldConfigByAnnonation {

    @Bean(name = "introduce")
    public IIntroduce getIntroduce() {
        return new IntroduceB();
    }
}
