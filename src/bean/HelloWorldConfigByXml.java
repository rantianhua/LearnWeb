package bean;

/**
 * Created by rantianhua on 17/1/2.
 * a simple example to use spring bean
 */
public class HelloWorldConfigByXml {

    private String name;

    private IIntroduce introduce;

    @Override
    public String toString() {
        return "name : " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIntroduce(IIntroduce introduce) {
        this.introduce = introduce;
    }

    public IIntroduce getIntroduce() {
        return introduce;
    }
}
