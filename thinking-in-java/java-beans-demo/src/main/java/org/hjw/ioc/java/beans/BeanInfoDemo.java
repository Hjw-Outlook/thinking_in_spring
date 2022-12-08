package org.hjw.ioc.java.beans;


import java.beans.*;
import java.util.stream.Stream;

/**
 * @ClassName BeanInfoDemo
 * @Description
 * {@link java.beans.BeanInfo}
 * @Author H_jw
 * @Date 2022-08-22 0022 上午 11:54
 * @Version 1.0
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo personBeanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(personBeanInfo.getPropertyDescriptors()).forEach(System.out::println);

        System.out.println("=========================================================");

        Student student = new Student();
        student.setAge("18");
        BeanInfo studentBeanInfo = Introspector.getBeanInfo(Student.class);

        Stream.of(studentBeanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
//                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();

                    // age字段进行类型转换 propertyEditor
                    if ("age".equals(propertyName)) {
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        propertyDescriptor.createPropertyEditor(student);
                        System.out.println(propertyDescriptor.getValue("age"));
                    }
                });


        System.out.println("=========================================================");

        BeanInfo studentBeanInfo2 = Introspector.getBeanInfo(Student.class, Person.class);
        Stream.of(studentBeanInfo2.getPropertyDescriptors())
                .forEach(System.out::println);
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(Integer.valueOf(text));
        }
    }
}
