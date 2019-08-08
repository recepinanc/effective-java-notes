package com.recepinanc.effectivejava;

public enum EnumSingleton
{
    INSTANCE;
    
    // This constructor can be omitted completely
    // since enum constructors are implicitly private
    private EnumSingleton() {
        
    }
    
    public int counter = 9;

    public int getCounter()
    {
        return counter;
    }
    
    // You can also omit this method, but it 
    // gives a better singleton feeling for the
    // users of this class. Instead of accessing
    // like: EnumSingleton.INSTANCE;
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
    
    static class Test {
        public static void main(String[] args) {
            int result = EnumSingleton.getInstance().getCounter();
            System.out.println(result);
        }
    }
}
