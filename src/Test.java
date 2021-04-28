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
 */
public class Test {
    public static void main(String[] args) throws IOException {
        // 使用 ClassReader 去读取 Account 类的字节码信息。
        ClassReader cr = new ClassReader("Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        // 通过accept方法扫描整个字节码,SKIP_DEBUG选项的意义是在扫描过程中掠过所有有关行号方面的内容
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("D:\\Git\\ASM\\out\\production\\ASM\\Account.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
        Account account = new Account();
        account.operation();
        account.anotherOperation();
    }
}
