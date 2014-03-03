/**
 * Sample From http://stuf.ro/calling-c-code-from-java-using-jni
 * Created by thomasgros on 2/23/14.
 */
public class HelloWorld {
    native void helloFromC(); /* (1) */
    static {
        System.loadLibrary("ctest"); /* (2) */
    }
    static public void main(String argv[]) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.helloFromC(); /* (3) */
    }
}
