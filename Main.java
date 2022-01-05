import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File tabulka = new File("C:\\Škola\\Ukol7\\src\\naklady_zastoupeni.csv");
        Scanner sc = new Scanner(tabulka);
        ArrayList<Zalobce> list = new ArrayList<>();
        Zalobce zalobce = null;
        String jmeno;
        double cena;
        double sum = 0;

        while (sc.hasNext()) {
            final String line = sc.nextLine();
            final String[] divided = line.split(",");

            if (divided.length == 3) {
                zalobce = new Zalobce(Integer.parseInt(divided[0]), divided[1], Double.parseDouble(divided[2]));
            } else {
                final String delsi = line.substring(line.indexOf("\""), line.lastIndexOf("\""));
                zalobce = new Zalobce(Integer.parseInt(divided[0]), delsi, Double.parseDouble(divided[3]));
            }

            list.add(zalobce);
        }

        for (Zalobce z : list) {
            sum += z.getCastka();
        }
        double avg = sum / list.size();
        System.out.println("Prumer vsech castek je: " + avg / 100);


        Map<String, Double> map = new HashMap<>();
        for (Zalobce i : list) {
            jmeno = i.getJmeno();
            cena = map.get(jmeno) == null ? 0 : map.get(jmeno);

            map.put(jmeno, cena + i.getCastka());
        }

        Map<String, Double> nej = new HashMap<>();
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            nej.put((String) me.getKey(), (Double) me.getValue());
        }

        cena = Collections.max(nej.values());
        jmeno = Collections.max(nej.keySet());

        System.out.println("Jmeno nejdrazsiho zalobce je: " + jmeno + " a jeho celkova hodnota je: " + cena);
    }
}
