package CodingTest.src;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SpringPractice {

    public class UpperClassHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String ret =(String) method.invoke(target, args);

            return ret.toUpperCase();
        }
        Hello target;
        public UpperClassHandler(Hello target){
            this.target = target;
        }

        Hello proxiHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new UpperClassHandler(new HelloTrarget())
        );
    }
}
