class A2 {
    int id;
    String name;

    A2(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("A2 constructor");
    }

    void instanceMethod() {
        System.out.println("A2 instanceMethod");
    }

    static void staticMethod() {
        System.out.println("A2 staticMethod");
    }

    void display() {
        System.out.println("  A2: id=" + id + ", name=" + name);
    }
}

class B2 extends A2 {
    int featureB;

    B2(int id, String name, int featureB) {
        super(id, name);
        this.featureB = featureB;
        System.out.println("B2 constructor");
    }

    @Override
    void instanceMethod() {
        System.out.println("B2 instanceMethod - overridden");
    }

    static void staticMethod() {
        System.out.println("B2 staticMethod");
    }

    void specificMethodB() {
        System.out.println("B2 specific method");
    }

    @Override
    void display() {
        System.out.println("  B2: id=" + id + ", name=" + name + ", featureB=" + featureB);
    }
}

class C2 extends A2 {
    String featureC;

    C2(int id, String name, String featureC) {
        super(id, name);
        this.featureC = featureC;
        System.out.println("C2 constructor");
    }

    @Override
    void instanceMethod() {
        System.out.println("C2 instanceMethod - overridden");
    }

    static void staticMethod() {
        System.out.println("C2 staticMethod");
    }

    void specificMethodC() {
        System.out.println("C2 specific method");
    }

    @Override
    void display() {
        System.out.println("  C2: id=" + id + ", name=" + name + ", featureC=" + featureC);
    }
}

interface InterfaceX2 {
    void methodX();
}

interface InterfaceY2 {
    void methodY();
}

class D2 implements InterfaceX2 {
    int value;

    D2(int value) {
        this.value = value;
        System.out.println("D2 constructor");
    }

    @Override
    public void methodX() {
        System.out.println("D2 implements methodX");
    }

    void display() {
        System.out.println("  D2: value=" + value);
    }
}

class E2 implements InterfaceX2, InterfaceY2 {
    String data;

    E2(String data) {
        this.data = data;
        System.out.println("E2 constructor");
    }

    @Override
    public void methodX() {
        System.out.println("E2 implements methodX");
    }

    @Override
    public void methodY() {
        System.out.println("E2 implements methodY");
    }

    void display() {
        System.out.println("  E2: data=" + data);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Non-Static Methods - Dynamic Binding ===");
        System.out.println("Reference type: A2, Object type: B2");
        A2 ref1 = new B2(1, "First", 100);
        ref1.instanceMethod();
        ref1.display();

        System.out.println("\nReference type: A2, Object type: C2");
        A2 ref2 = new C2(2, "Second", "Test");
        ref2.instanceMethod();
        ref2.display();

        System.out.println("\n=== Test 2: Static Methods - Reference Type Matters ===");
        System.out.println("Reference type: A2, Object type: B2");
        A2 ref3 = new B2(3, "Third", 200);
        ref3.staticMethod();

        System.out.println("\nReference type: B2, Object type: B2");
        B2 ref4 = new B2(4, "Fourth", 300);
        ref4.staticMethod();

        System.out.println("\nDirect class call:");
        A2.staticMethod();
        B2.staticMethod();
        C2.staticMethod();

        System.out.println("\n=== Test 3: Downcasting ===");
        A2 ref5 = new B2(5, "Fifth", 500);
        System.out.println("Before downcast - can only call A2 methods");
        ref5.instanceMethod();

        System.out.println("\nAfter downcast - can call B2 specific methods");
        if (ref5 instanceof B2) {
            B2 bRef = (B2) ref5;
            bRef.specificMethodB();
        }

        System.out.println("\n=== Test 4: Interface Reference Type ===");
        InterfaceX2 ix1 = new D2(100);
        InterfaceX2 ix2 = new E2("Data");

        ix1.methodX();
        ix2.methodX();

        System.out.println("\n=== Test 5: Downcasting with Interface ===");
        if (ix2 instanceof E2) {
            E2 e2Ref = (E2) ix2;
            e2Ref.methodY();
            e2Ref.display();
        }

        System.out.println("\n=== Test 6: Multiple Interface Reference ===");
        InterfaceY2 iy = new E2("MultiInterface");
        iy.methodY();

        if (iy instanceof InterfaceX2) {
            System.out.println("iy also implements InterfaceX2");
            ((InterfaceX2) iy).methodX();
        }
    }
}