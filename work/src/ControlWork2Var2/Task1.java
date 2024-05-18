package ControlWork2Var2;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer[]> map = new HashMap<>();
        Reader.getStream().forEach((human -> {
            if (map.get(human.race) == null) {
                map.put(human.race, new Integer[]{human.bwt, 1});
            } else {
                map.get(human.race)[0] += human.bwt;
                map.get(human.race)[1] += 1;
            }
        }));
        for (Map.Entry<String, Integer[]> i : map.entrySet()) {
            System.out.println(i.getKey() + " - " + (i.getValue()[0] / i.getValue()[1]));
        }
    }
}
