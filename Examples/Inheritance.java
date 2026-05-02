class A{
    public int feature1;
    A(){
        System.out.println("Here 1");
    }
}

class B extends A{
    public int feature2;
    B(){

        System.out.println("Here 2");
    }
}

class C extends B{
    public int feature3;
    C(){
       System.out.println("Here 3");
    }
}

public class Inheritance{
    public static void main(String[] args){
        A object = new C();

    }
}