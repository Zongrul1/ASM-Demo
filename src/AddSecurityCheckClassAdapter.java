import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * 改写类的一个方法
 *
 * @author T1938-李宗儒
 * @date 2021/4/28
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter {
    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    //重写 visitMethod，访问到 "operation" 方法时，给出自定义 MethodVisitor，实际改写方法内容
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //如果是删除的话不可以取出来，取出来会报错
        //visitInnerClass、visitField、visitMethod和visitEnd这些方法分成两组，一组是visitInnerClass、visitField、visitMethod，
        // 这些方法有可能会被多次调用，因此在这些方法中创建属性时要注意会重复创建
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);;
        System.out.println("AddSecurityCheckClassAdapter;" + "name:" + name + ";desc:" + desc + ";signature:" + signature);
        //移除operation方法
        if ("operation".equals(name)) {
            return null;
        }
        //修改anotheroperation方法
        if ("anotherOperation".equals(name)) {
            return new AddSecurityCheckMethodAdapter(cv.visitMethod(access, name, desc, signature, exceptions));
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
