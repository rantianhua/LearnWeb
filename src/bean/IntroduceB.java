package bean;

/**
 * Created by rantianhua on 17/1/2.
 */
public class IntroduceB implements IIntroduce {
    @Override
    public void introduce() {
        System.out.println(IntroduceB.class.getName());
    }
}
