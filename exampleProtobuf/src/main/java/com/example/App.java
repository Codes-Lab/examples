package com.example;

import com.example.na.proto.domain.PeopleProvider;
import com.example.pojo.Address;
import com.example.pojo.People;
import com.example.pojo.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, ProtoBuf User, Please provide a disk path to write output stream...");
        final Scanner sc = new Scanner(System.in);

        //Normal Java Objects
        System.out.print("Enter the second path - ");
        String filePath2 = sc.nextLine();
        final long start2 = System.currentTimeMillis();
        final Address address1 = new Address("Main Street, NY", 123);
        final Address address2 = new Address("Main Street, NY", 123);

        final List<Person> john_doe = new People.Builder("John Doe",
                                                         new String[] { "1122334455", "1122334466" },
                                                         new String[] { "jdoe@example.com", "jdoe@example.com" },
                                                         new Address[] { address1, address2 }).build();

        final FileOutputStream output2 = new FileOutputStream(filePath2);
        ObjectOutputStream objectOut = new ObjectOutputStream(output2);
        objectOut.writeObject(john_doe);
        objectOut.close();
        System.out.println("Time taken " + (System.currentTimeMillis() - start2));

        System.out.print("Enter the path - ");
        String filePath = sc.nextLine();
        final long start = System.currentTimeMillis();

        //Person Address 1
        final PeopleProvider.Address johnAddress1 = PeopleProvider.Address
            .newBuilder()
            .setNumber(123)
            .setStreet("Main Street, NY")
            .build();

        //Person Address 2
        final PeopleProvider.Address johnAddress2 = PeopleProvider.Address
            .newBuilder()
            .setNumber(123)
            .setStreet("Main Street, NY")
            .build();

        //Person John Doe
        final PeopleProvider.Person john = PeopleProvider.Person
            .newBuilder()
            .setName("John Doe")
            .addEmail("jdoe@example.com")
            .addEmail("jdoe2@example.com")
            .addMobile("1122334455")
            .addMobile("1122334466")
            .addAddress(johnAddress1)
            .addAddress(johnAddress2)
            .build();

        final FileOutputStream output = new FileOutputStream(filePath);
        john.writeTo(output);
        System.out.println("Time taken " + (System.currentTimeMillis() - start));
    }
}
