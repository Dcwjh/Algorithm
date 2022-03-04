package Test;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Person
 * @Date 2021/7/7 14:42
 * @Version 1.0
 */


public class Person implements Cloneable{
        private int age ;

        private String name;

        public Person(int age, String name) {
            this.age = age;

            this.name = name;

        }

        public Person() {}

        public int getAge() {
            return age;

        }

        public String getName() {
            return name;

        }

        @Override

        protected Object clone() throws CloneNotSupportedException {
            return (Person)super.clone();
        }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, new String("zhang"));

        Person p1 = (Person) p.clone();

        String result = p.getName() == p1.getName()

            ? "clone是浅拷贝的" : "clone是深拷贝的";

        System.out.println(result);
        System.out.println(p.getName());
    }

}

