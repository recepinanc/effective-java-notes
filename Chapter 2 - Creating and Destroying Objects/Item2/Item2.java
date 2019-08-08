package com.recepinanc.effectivejava.chapter2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;

public class Item2
{
    public static void main(String[] args)
    {
        HardWorker hardWorker1 = new HardWorker.HardWorkerBuilder("Jon Doe", 22, new Date(), false).build();
        HardWorker hardWorker2 = new HardWorker.HardWorkerBuilder("Jon Doe", 22, new Date(), false)
                .hoursWorked(5)
                .build();
        HardWorker hardWorker3 = new HardWorker.HardWorkerBuilder("Jon Doe", 22, new Date(), false)
                .hoursWorked(12)
                .numberOfMedals(2)
                .salary(new BigDecimal(999.12).round(MathContext.DECIMAL32))
                .build();

        System.out.println(hardWorker1);
        System.out.println(hardWorker2);
        System.out.println(hardWorker3);
        
        // Output:
        // { HardWorker = name = Jon Doe, age = 22, dateOfBirth = Thu Jun 20 09:20:02 EET 2019, isMarried = false, 
        // hoursWorked = 0, numberOfMedals = 0, salary = null, holidays = null }
        //{ HardWorker = name = Jon Doe, age = 22, dateOfBirth = Thu Jun 20 09:20:02 EET 2019, isMarried = false, 
        // hoursWorked = 5, numberOfMedals = 0, salary = null, holidays = null }
        //{ HardWorker = name = Jon Doe, age = 22, dateOfBirth = Thu Jun 20 09:20:02 EET 2019, isMarried = false, 
        // hoursWorked = 12, numberOfMedals = 2, salary = 999.1200, holidays = null }
    }
}

class HardWorker
{

    private final String name;
    private final int age;
    private final Date dateOfBirth;
    private final boolean isMarried;
    private final long hoursWorked;
    private final int numberOfMedals;
    private final BigDecimal salary;
    private final List<String> holidays;

    public HardWorker(HardWorkerBuilder builder)
    {
        this.name = builder.name;
        this.age = builder.age;
        this.dateOfBirth = builder.dateOfBirth;
        this.isMarried = builder.isMarried;
        this.hoursWorked = builder.hoursWorked;
        this.numberOfMedals = builder.numberOfMedals;
        this.salary = builder.salary;
        this.holidays = builder.holidays;
    }

    public static class HardWorkerBuilder
    {
        // Required Parameters
        private String name;
        private int age;
        private Date dateOfBirth;
        private boolean isMarried;

        // Optional Parameters
        private long hoursWorked;
        private int numberOfMedals;
        private BigDecimal salary;
        private List<String> holidays;

        public HardWorkerBuilder(String name, int age, Date dateOfBirth, boolean isMarried)
        {
            this.name = name;
            this.age = age;
            this.dateOfBirth = dateOfBirth;
            this.isMarried = isMarried;
        }

        // Builder optional parameter building methods
        public HardWorkerBuilder hoursWorked(int hours)
        {
            hoursWorked = hours;
            return this;
        }

        public HardWorkerBuilder numberOfMedals(int medals)
        {
            numberOfMedals = medals;
            return this;
        }

        public HardWorkerBuilder salary(BigDecimal val)
        {
            salary = val;
            return this;
        }

        public HardWorkerBuilder holidays(List<String> val)
        {
            holidays = val;
            return this;
        }

        // Build method that binds all together
        public HardWorker build()
        {
            return new HardWorker(this);
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ HardWorker = ");
        stringBuilder.append("name = " + name);
        stringBuilder.append(", age = " + age);
        stringBuilder.append(", dateOfBirth = " + dateOfBirth);
        stringBuilder.append(", isMarried = " + isMarried);
        stringBuilder.append(", hoursWorked = " + hoursWorked);
        stringBuilder.append(", numberOfMedals = " + numberOfMedals);
        stringBuilder.append(", salary = " + salary);
        stringBuilder.append(", holidays = " + holidays);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
