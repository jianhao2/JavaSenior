package com.atcafuc.java1;

/**
 * 一、理解Annotation
 * 1.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译,
 * 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * 代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 * <p>
 * 2.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，
 * 忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 * <p>
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * <p>
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *
 * @author jh
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示 过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * <p>
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * <p>
 * 3.如何自定义注解：参照@SuppressWarnings定义
 * 注解声明为：@interface
 * 内部定义成员，通常使用value表示
 * 可以指定成员的默认值，使用default定义
 * 如果自定义的注解没有成员，标明是一个标识作用
 * 如果注解有成员，使用时需要给成员赋值。
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 * 自定义注解通常都指明两个注解：Retention、Target
 * <p>
 *
 * 4.jdk提供的4种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention：  指定该 Annotation 的生命周期：SOURCE\CLASS(默认行为) \RUNTIME
                (只有声明为RUNTIME，才能被反射获取)
 * Target：  用于指定被修饰的Annotation能用于修饰哪些程序元素
 * ************************出现频率较低******************
 * Documented： 表示所修饰的注解在被javadoc解析时，保留下来
 * Inherited：被它修饰的 Annotation 将具有继承性
 *
 * 5、通过反射获取
 *
 * 6. jdk8注解的新特性：可重复注解、类型注解
 * 6.1 可重复注解： MyAnnotation上声明@Repeatable, 成员值为MyAnnotation.class
 *                 MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
 *
 * @create 2021-08-20 13:51
 */
public class AnnotationTest {

}


@MyAnnotation(value = "hello")
class Person {
    private String name;
    private int age;


    public Person(String namel, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }

}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("student walk");
    }

    @Override
    public void show() {
        System.out.println("student sport");
    }
}
