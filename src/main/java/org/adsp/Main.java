package org.adsp;

import org.adsp.patterns.collections.Flyweight.FlyweightFactory;
import org.adsp.patterns.collections.Flyweight.FlyweightIntr;

import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> empList = initialize();
        FlyweightFactory factory = FlyweightFactory.getInstance();
        for (int i = 0; i < empList.size(); i++) {
            String s = empList.elementAt(i);
            StringTokenizer st = new StringTokenizer(s, ",");
            String name = st.nextToken();
            String code = st.nextToken();
            String faculty = st.nextToken();
            FlyweightIntr flyweight = factory.getFlyweight(faculty);
            flyweight.print(name, code);
        }
    }

    private static Vector<String> initialize() {
        Vector<String> v = new Vector<>();
        v.add("Luis Torres,2020010004,Eng");
        v.add("Juana Lesmes,2020010003,Tech");
        v.add("Pacho Lazo,2020010012,Env");
        v.add("Luisa Gamez,2020010023,Arts");
        v.add("Carla Ants,2020010018,Arts");
        v.add("Mario Antolinez,2020010045,Env");
        v.add("Liz Pardo,2020010323,Eng");
        v.add("Pedro Pardo,2020010345,Eng");
        v.add("Oscar Ortiz,2020010278,Arts");
        v.add("Luis Garduan,2020010009,Tech");
        v.add("Conchita Cardona,2020010346,Eng");
        v.add("Esperanza Tarde,2020010034,Arts");
        return v;
    }
}
