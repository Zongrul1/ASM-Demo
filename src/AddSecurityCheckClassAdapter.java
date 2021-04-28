import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * 实体基类
 *
 * @author T1938-李宗儒
 * @date 2021/4/28
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter {
    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    // 重写 visitMethod，访问到 "operation" 方法时，给出自定义 MethodVisitor，实际改写方法内容
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //不可以取出来，取出来会报错
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        System.out.println("AddSecurityCheckClassAdapter;" + "name:" + name + ";desc:" + desc + ";signature:" + signature);
//        if (mv != null) {
            if ("operation".equals(name)) {
                // 使用自定义的MethodVisitor,实际改写方法内容
                //return new AddSecurityCheckMethodAdapter(super.visitMethod(access, name, desc, signature, exceptions));
                //删除operate方法
                return null;
            }
//        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }

//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        if ("operation".equals(name)) {
//            return null;
//        }
//        return super.visitMethod(access, name, desc, signature, exceptions);
//    }
}
