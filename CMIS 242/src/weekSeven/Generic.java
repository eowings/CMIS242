package weekSeven;

public class Generic<T> {
    T value;
    void add(T obj) {
        this.value=obj;
    }  
    T get() {
        return value;
    }  
} 