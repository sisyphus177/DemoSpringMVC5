package demo.spring.aop;

/**
 * Created by raist on 2016/4/25.
 *
 */
public class DemoAspect {

    public void before(){
        System.out.println("This is DemoAspect.before()");
    }

    public void after(){
        System.out.println("This is DemoAspect.after()");
    }

}
