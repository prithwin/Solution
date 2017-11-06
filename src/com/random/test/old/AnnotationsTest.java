package com.random.test.old;

/**
 * Created by prajeeva on 8/19/17.
 */
public class AnnotationsTest {
    @ClassAnnotation(configfile = "someFile")
    private static class SomeThing {

        SomeThing() {
            try {
                int sum = 0 ;
                for(VariableAnnotation item : this.getClass().getField("a").getAnnotationsByType(VariableAnnotation.class)) {
                    sum += Integer.parseInt(item.value());
                }

                this.a = sum;
                System.out.println();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        @VariableAnnotation(value = "1")
        @VariableAnnotation(value = "2")
        @VariableAnnotation(value = "3")
        @VariableAnnotation(value = "4")
        public int a;

        @VariableAnnotation(value = "someString+someString")
        public String b;

        @MethodAnnotation(toDo = "someThing")
        public void m() {

        }
    }

    public static void  main(String[] args) {
        //here is something we can do at this moment
        SomeThing someThing = new SomeThing();

        System.out.println("check that values of all the variables that have been set in this area");
    }
}
