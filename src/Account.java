import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实体基类
 *
 * @author T1938-李宗儒
 * @date 2021/4/28
 * @since 0.0.1
 */
public class Account {
    public void operation() { System.out.println("operation..."); }
    public void anotherOperation() {
        System.out.println("anotheroperation...");
    }

}
