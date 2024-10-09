public class Dynamic<T> extends Stack<T> {

    public Dynamic() {
        this.size = 1;
        stack = (T[]) new Object[size];
        top = 0;
    }

    @Override
    public void push(T val) {
        if (top == stack.length) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[top] = val;
        top++;
    }
    @Override
    public T pop() {
        if (top == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        if(stack.length >= 16 && top <= stack.length / 4) {
            T[] newStack = (T[]) new Object[stack.length / 2];
            for (int i = 0; i < newStack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
            System.out.println("Stack size reduced to " + stack.length);
        }
        top--;
        return stack[top];
    }
    
}
