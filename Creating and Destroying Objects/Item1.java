package com.recepinanc.effectivejava.chapter2;

import java.util.Date;

public class Item1
{
     public static void main(String[] args) {
         Worker worker = Worker.getInstance("Recep", 22, new Date(), false);
         System.out.println(worker);
         worker = Worker.getInstance("Inanc", 23, new Date(), true);
         System.out.println(worker);
     }
}

class Worker {
    
    private static Worker workerInstance; 
    
    private String name;
    private int age;
    private Date dateOfBirth;
    private boolean isMarried;

    public static Worker getInstance(String name, int age, Date dateOfBirth, boolean isMarried) {
        Worker worker = new Worker();
        if (workerInstance != null) {
            worker = workerInstance;
        } else {
            worker.name = name;
            worker.age = age;
            worker.dateOfBirth = dateOfBirth;
            worker.isMarried = isMarried;
            workerInstance = worker;
        }
        return worker;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ Worker = ");
        stringBuilder.append("name = " + name);
        stringBuilder.append(", age = " + age);
        stringBuilder.append(", dateOfBirth = " + dateOfBirth);
        stringBuilder.append(", isMarried = " + isMarried);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
