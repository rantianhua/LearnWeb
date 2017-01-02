package bean;

/**
 * Created by rantianhua on 17/1/2.
 */
public class IntroduceA implements IIntroduce {
    @Override
    public void introduce() {
        System.out.println(IntroduceA.class.getName());
    }
}
