class A3 {
    void method1() {
        System.out.println("=== Basic Try-Catch-Finally ===");

        try {
            System.out.println("Try block starts");
            int result = 10 / 2;
            System.out.println("Result: " + result);
            System.out.println("Try block ends");
        } catch (ArithmeticException e) {
            System.out.println("Catch block: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }

        System.out.println("After try-catch-finally\n");
    }

    void method2() {
        System.out.println("=== Try-Catch-Finally with Exception ===");

        try {
            System.out.println("Try block starts");
            int result = 10 / 0;
            System.out.println("This line will NOT execute");
        } catch (ArithmeticException e) {
            System.out.println("Catch block: Division by zero!");
        } finally {
            System.out.println("Finally block executes even after exception");
        }

        System.out.println("After try-catch-finally\n");
    }

    void method3() {
        System.out.println("=== Finally without Catch ===");

        try {
            System.out.println("Try block");
            int x = 5;
        } finally {
            System.out.println("Finally block without catch");
        }

        System.out.println("After try-finally\n");
    }
}

class B3 {
    void nestedTryCatch() {
        System.out.println("=== Nested Try-Catch-Finally ===");

        try {
            System.out.println("Outer try starts");

            try {
                System.out.println("  Inner try starts");
                int result = 10 / 0;
                System.out.println("  This won't print");
            } catch (ArithmeticException e) {
                System.out.println("  Inner catch: " + e.getMessage());
            } finally {
                System.out.println("  Inner finally");
            }

            System.out.println("Outer try continues");
            String s = null;
            s.length();

        } catch (NullPointerException e) {
            System.out.println("Outer catch: NullPointerException");
        } finally {
            System.out.println("Outer finally");
        }

        System.out.println("After nested blocks\n");
    }

    void multipleNestedBlocks() {
        System.out.println("=== Multiple Nested Levels ===");

        try {
            System.out.println("Level 1 try");

            try {
                System.out.println("  Level 2 try");

                try {
                    System.out.println("    Level 3 try");
                    int x = 10 / 0;
                } catch (ArithmeticException e) {
                    System.out.println("    Level 3 catch");
                } finally {
                    System.out.println("    Level 3 finally");
                }

                System.out.println("  Level 2 continues");

            } finally {
                System.out.println("  Level 2 finally");
            }

        } finally {
            System.out.println("Level 1 finally");
        }

        System.out.println("After all levels\n");
    }
}

class C3 {
    void exceptionHierarchy1() {
        System.out.println("=== Exception Hierarchy - Specific First ===");

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught: IndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Caught: Exception");
        }

        System.out.println();
    }

    void exceptionHierarchy2() {
        System.out.println("=== Exception Hierarchy - NullPointer ===");

        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("Caught: NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("Caught: RuntimeException");
        } catch (Exception e) {
            System.out.println("Caught: Exception");
        }

        System.out.println();
    }

    void exceptionHierarchy3() {
        System.out.println("=== Exception Hierarchy - Arithmetic ===");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught: ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("Caught: RuntimeException");
        } catch (Exception e) {
            System.out.println("Caught: Exception");
        }

        System.out.println();
    }
}

class D3 {
    void methodWithThrows() throws ArithmeticException {
        System.out.println("Method with throws - dividing by zero");
        int result = 10 / 0;
    }

    void methodWithMultipleThrows() throws ArithmeticException, NullPointerException {
        System.out.println("Method with multiple throws");
        String s = null;
        s.length();
    }

    void methodThatHandles() {
        System.out.println("=== Method with Throws ===");

        try {
            methodWithThrows();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception from methodWithThrows");
        }

        System.out.println();
    }

    void methodThatPropagates() throws NullPointerException {
        System.out.println("=== Method that Propagates Exception ===");
        methodWithMultipleThrows();
    }
}

class E3 {
    void customExceptionDemo() throws Exception {
        System.out.println("Method that throws checked Exception");
        throw new Exception("Custom exception message");
    }

    void callerMethod() {
        System.out.println("=== Throws with Checked Exception ===");

        try {
            customExceptionDemo();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println();
    }
}

class F3 {
    void finallyWithReturn() {
        System.out.println("=== Finally with Return ===");

        String result = methodWithFinallyReturn();
        System.out.println("Returned value: " + result);
        System.out.println();
    }

    String methodWithFinallyReturn() {
        try {
            System.out.println("Try block");
            return "From try";
        } catch (Exception e) {
            System.out.println("Catch block");
            return "From catch";
        } finally {
            System.out.println("Finally block executes before return");
        }
    }

    void finallyAlwaysExecutes() {
        System.out.println("=== Finally Always Executes ===");

        try {
            System.out.println("Try block");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Catch block");
            return;
        } finally {
            System.out.println("Finally executes even with return in catch");
        }
    }
}

public class ExceptionPart {
    public static void main(String[] args) {
        A3 a = new A3();
        a.method1();
        a.method2();
        a.method3();

        B3 b = new B3();
        b.nestedTryCatch();
        b.multipleNestedBlocks();

        C3 c = new C3();
        c.exceptionHierarchy1();
        c.exceptionHierarchy2();
        c.exceptionHierarchy3();

        D3 d = new D3();
        d.methodThatHandles();

        try {
            d.methodThatPropagates();
        } catch (NullPointerException e) {
            System.out.println("Main caught propagated exception");
            System.out.println();
        }

        E3 e = new E3();
        e.callerMethod();

        F3 f = new F3();
        f.finallyWithReturn();
        f.finallyAlwaysExecutes();
    }
}