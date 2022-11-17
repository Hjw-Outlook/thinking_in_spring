package org.hjw.ioc.java.lambda;

import java.util.function.*;

/**
 * @ClassName LambdaDemo
 * @see Supplier 一个输出
 * @see Consumer 一个输入
 * @see Function 一个输入一个输出（一般是不同类型）
 * @see BiConsumer 两个输入
 * @see UnaryOperator 一个输入一个输出（一般是同一类型）
 * @see BiFunction 两个个输入一个输出（一般是不同一类型）
 * @see BinaryOperator 两个个输入一个输出（一般是同一类型）
 * @Author H_jw
 * @Date 2022-11-08 0008 下午 03:16
 * @Version 1.0
 */
public class LambdaDemo {

    public static void main(String[] args) {

        // args -> expr 或者 (object... args) -> { 函数式接口抽象方法实现逻辑 }
        // () 表示 函数式方法参数，参数的个数，根据函数式接口里边抽象的参数个数来决定，当参数只有一个的时候，() 可以省略
        // -> 表示 函数式
        // {...} 表示 当expr 逻辑非常简单的时候，{}和return 可以省略，函数式接口抽象方法实现逻辑

        // Supplier 代表一个输出, 执行（没有参数）方法可以输出一个想要的类型
        Supplier<String> stringSupplier = () -> {return "123";};
        System.out.println("stringSupplier: " + stringSupplier.get());
        Supplier<String> stringSupplier2 = () -> "123";
        System.out.println("stringSupplier2: " + stringSupplier2.get());

        System.out.println("------------------------------------------------------");
        // Consumer 代表一个输入，执行（没有参数）方法可以输入一个类型然后进行处理逻辑
        Consumer<String> stringConsumer = (str) -> {
            // 通过传入的参数进行处理逻辑
            System.out.println(str);
        };
        stringConsumer.accept("stringConsumer: 123");
        Consumer<String> stringConsumer2 = (str) -> System.out.println(str);
        stringConsumer2.accept("stringConsumer2: 123");
        Consumer<String> stringConsumer3 = System.out::println;
        stringConsumer3.accept("stringConsumer3: 123");

        System.out.println("------------------------------------------------------");
        // Function 代表一个输入一个输出，执行（一个参数类型）方法可以输入一个参数类型进行处理逻辑，然后返回另一个(也可以是同一种)类型
        Function<String, Integer> stringIntegerFunction = (str) -> {
            System.out.println("stringIntegerFunction: " + str);
            return Integer.valueOf(str);
        };
        System.out.println(stringIntegerFunction.apply("123"));

        Function<Integer, String> integerStringFunction = (num) -> {
            System.out.println("integerStringFunction: " + num);
            return "" + num;
        };
        String integerStringFunctionApply = integerStringFunction.apply(123);
        System.out.println(integerStringFunctionApply);

        Function<String, String> stringStringFunction = (str) -> {
            System.out.println("stringIntegerFunction: " + str);
            return "处理stringStringFunction之后： " + str;
        };
        String stringStringFunctionApply = stringStringFunction.apply("123");
        System.out.println(stringStringFunctionApply);

        System.out.println("------------------------------------------------------");
        //

    }
}
