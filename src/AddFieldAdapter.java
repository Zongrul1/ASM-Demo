import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;
import com.sun.xml.internal.ws.org.objectweb.asm.Type;

/**
 * 为类增加一个成员属性
 *
 * @author T1938-李宗儒
 * @date 2021/4/29
 */
public class AddFieldAdapter extends ClassAdapter {

    public AddFieldAdapter(ClassVisitor cv) {
        super(cv);
    }

    //visitEnd这个方法只有在最后才会被调用且只调用一次，
    //所以在这个方法中添加属性是唯一的，因此一般添加属性选择在这个方法里编码
    @Override
    public void visitEnd() {
        // 第一个参数指定的是这个属性的操作权限，第二个参数是属性名，第三个参数是类型描述，
        // 第四个参数是泛型类型，第五个参数是初始化的值，
        // 这里需要注意一下的是第五个参数，这个参数只有属性为static(final)时才有效，
        // 也就是数只有为static时，这个值才真正会赋值给我们添加的属性上，对于非static属性，它将被忽略。
        cv.visitField(Opcodes.ACC_PUBLIC, "age", Type.getDescriptor(int.class),
                null, null);
        cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC + Opcodes.ACC_FINAL, "static_age", Type.getDescriptor(int.class),
                null, 5);
    }

}
