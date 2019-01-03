/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 19-1-3 下午1:08
 */
public class TestSize {

    public void test(){
        System.out.println("int:\t" + MyAgent.sizeOf(1));//输出为16
    }

    public static void main(String []args) {
        new TestSize().test();
    }

}
