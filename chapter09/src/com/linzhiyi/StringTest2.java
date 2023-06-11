package com.linzhiyi;

public class StringTest2 {

    //test1
//    public static void main(String[] args) {
//        String s1 = "a" + "b" + "c"; //编译期优化：等同于"abc"。
//        String s2 = "abc"; //字面量的方式，一定是放在堆中的字符串常量池，将此地址赋给s2。
//        System.out.println(s1==s2); //true
//        System.out.println(s1.equals(s2)); //true
//    }

    //test2
//    public static void main(String[] args) {
//        String s1 = "javaEE";
//        String s2 = "hadoop";
//
//        String s3 = "javaEEhadoop";
//        String s4 = "javaEE" + "hadoop"; //编译期优化
//        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接后的结果。
//        String s5 = s1 + "hadoop";
//        String s6 = "javaEE" + s2;
//        String s7 = s1 + s2;
//
//        System.out.println(s3 == s4); //true
//        System.out.println(s3 == s5); //false
//        System.out.println(s3 == s6); //false
//        System.out.println(s3 == s7); //false
//        System.out.println(s5 == s6); //false
//        System.out.println(s5 == s7); //false
//        System.out.println(s6 == s7); //false
//        //intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址：
//        //如果字符串常量池不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，返回此对象的地址。
//        String s8 = s6.intern();
//        System.out.println(s3 == s8); //true
//    }

    //test3
//    public static void main(String[] args) {
//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "ab";
//        /**
//        * 如下的s1 + s2 的执行细节：(变量s是我临时定义的)
//         * 1.StringBuilder s1 = new StringBuilder();
//         * 2.s.append("a");
//         * 3.s.append("b");
//         * 4.s.toString(); ---> 约等于 new String("ab")
//         *
//         * 补充：在JDK5.0之后使用的是StringBuilder，在JDK5.0之前使用的是StringBuffer。
//        * */
//        String s4 = s1 + s2; //
//        System.out.println(s3 == s4); //false
//    }
    /**
     * 字符串拼接操作不一定使用的是StringBuilder！
     * 如果拼接符号左右两边都是字符串常量或者常量引用，则任然使用编译期优化，即非StringBuilder的方式。
     * 针对于final修饰类、方法、基本数据类型、引用类型的量的结构时，能使用上final的时候建议使用上。
     * */

    //test4
//    public static void main(String[] args) {
//        String s1 = "javaEEhadoop";
//        String s2 = "javaEE";
//        String s3 = s2 + "hadoop";
//        System.out.println(s1 == s3); //false
//
//        final String s4 = "javaEE"; //用final修饰的常量
//        String s5 = s4 + "hadoop";
//        System.out.println(s1 == s5); //true
//    }



    /** test5
     * 拼接操作和append操作的效率对比
     * 通过StringBuilder的append()的方式添加字符串的效率远高于使用String的字符串拼接
     * 好处：StringBuilder的append()方式：自始至终只创建一个StringBuilder的对象
     *      使用String的字符串拼接方式：创建多个StringBuilder和String的对象
     *                              内存中由于创建了较多的StringBuilder和String的对象，内存占用更大；如果进行GC需要花费额外的时间。
     * 改进空间：在实际开发中，如果基本确定要前前后后添加的字符串长度不高于某个限定值highLevel的情况下,建议使用构造器
     *          StringBuilder s = new StringBuilder(highLevel); //new char[highLevel]
     */

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        //method1(100000); //3822
        method2(100000); //6

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));
    }

    public static void method1(int highLevel){
        String src = "";
        for (int i = 0; i < highLevel; i++){
            src = src + "a"; //每次循环都会创建一个StringBuilder、String
        }

        //System.out.println(src);
    }

    public static void method2(int highLevel){
        //只需创建一个StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++){
            src.append("a");
        }

        //System.out.println(src);
    }
}
