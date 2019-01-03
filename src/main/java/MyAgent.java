import java.lang.instrument.Instrumentation;

/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 19-1-3 下午1:06
 */
public class MyAgent {

    private static Instrumentation inst;

    /**
     * 这个方法必须写，在agent调用时会被启用
     */
    public static void premain(String agentArgs, Instrumentation instP) {
        System.out.println("On premain, agentArgs: [" + agentArgs + "]");
        inst = instP;
    }

    /**
     * 用来测量java对象的大小,调用了Instrumentation实例方法
     */
    public static long sizeOf(Object o) {
        if(inst == null) {
            throw new IllegalStateException("Can not access instrumentation environment.\n" +
                    "Please check if jar file containing SizeOfAgent class is \n" +
                    "specified in the java's \"-javaagent\" command line argument.");
        }
        return inst.getObjectSize(o);
    }


}
