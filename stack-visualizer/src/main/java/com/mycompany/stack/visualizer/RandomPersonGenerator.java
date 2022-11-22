package com.mycompany.stack.visualizer;

public class RandomPersonGenerator {

    public Person generate() {
        Person randomPerson;
        
        String name;
        int age;
        float weight, height;

        RandomNumbers r = new RandomNumbers();
        String[] names = {"Jorge", "Mario", "Jailson", "Neves", "Alexandre", 
                           "Maria", "Joana", "Romilda", "Sabrina", "Jennifer"};

        int i = r.randomInt(0,names.length - 1);
        
        name = names[i];
        age = r.randomInt(18, 60);
        weight = r.randomFloat(50, 120);
        height = r.randomFloat(1.5f, 2.0f);

        randomPerson = new Person(name, age, weight, height);
        
        return randomPerson;
    }
}
