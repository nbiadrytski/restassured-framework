package com.nikolay.constructors;

public class BankingDemo {

    public static void main(String[] args) {
        //Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "f@f.net",
        //        "123-456-987");

        //Account timsAccount = new Account("Tim", "tim@tim.com",
        //        "87-87-98");

        //System.out.println(bobsAccount.getNumber() + " name " + bobsAccount.getCustomerName());
        //System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("Bob", 2500.0);
        System.out.println(person2.getName());

        VipPerson person3 = new VipPerson("Tim", 100.0, "tim@tim.com");
        System.out.println(person3.getName());





    }
}
