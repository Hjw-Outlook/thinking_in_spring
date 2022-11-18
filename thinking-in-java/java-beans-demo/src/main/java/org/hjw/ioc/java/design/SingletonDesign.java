package org.hjw.ioc.java.design;

/**
 * @ClassName design.SingletonDesign
 * @Description TODO
 * @Author H_jw
 * @Date 2022-08-11 0011 下午 05:17
 * @Version 1.0
 */
public class SingletonDesign {

    // 第一步把构造函数设置为私有
    private SingletonDesign(){}

//    单例 饿汉式
//    private static final design.SingletonDesign singletonDesignInstance = new design.SingletonDesign();

//    private static design.SingletonDesign singletonDesignInstance = null;

//    单例 懒加载式
//    private static synchronized design.SingletonDesign getInstance() {
//
//        if (singletonDesignInstance == null) {
//            singletonDesignInstance = new design.SingletonDesign();
//        }
//        return singletonDesignInstance;
//    }

//    单例 双重检测式1
//    private static design.SingletonDesign getInstance() {
//
//        if (singletonDesignInstance == null) {
//            synchronized (design.SingletonDesign.class) {
//                if (singletonDesignInstance == null) {
//                    singletonDesignInstance = new design.SingletonDesign();
//                }
//            }
//        }
//        return singletonDesignInstance;
//    }

//    单例 双重检测式2（静态内部类式）
//    private static final class singletonDesignInstanceHolder {
//        private static final design.SingletonDesign singletonDesignInstance = new design.SingletonDesign();
//    }
//    private static design.SingletonDesign getInstance() {
//        return singletonDesignInstanceHolder.singletonDesignInstance;
//    }

//    public static design.SingletonDesign getSingletonDesignInstance() {
//        return getInstance();
//    }

    // 枚举
//    enum singletonDesignEum {

//    }


    public static void main(String[] args) {
//        System.out.println(getSingletonDesignInstance());
    }
}
