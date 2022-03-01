import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <=0) throw new IllegalArgumentException();
        if (getal == 1 || getal == 2) return 1;
        return fibonacci(getal-1) + fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal/10 == 0) return Math.abs(getal);
        getal = Math.abs(getal);
        return getal%10 + somVanCijfers((getal-getal%10)/10);
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.isBlank()) return "";
        if (s.length()==1) return s;
        return s.substring(s.length()-1) + keerOm(s.substring(0, s.length()-1));
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.isBlank()) return 0;
        String letter = s.substring(0,1);
        if (letter.equals("x")) return 1 + countX(s.substring(1));
        return countX(s.substring(1));
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.isBlank()) return 0;
        if (s.length()==1) return 0;
        String letter = s.substring(0,1);
        String letter2 = s.substring(1,2);
        if (letter.equals("h") && letter2.equals("i")) return 1 + countHi(s.substring(1));
        return countHi(s.substring(1));
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.isBlank()) return "";
        String letter = s.substring(0,1);
        if (letter.equals("x")) return "y" + changeXY(s.substring(1));
        return letter + changeXY(s.substring(1));
    }

    // oefening 7

    public static String changePi(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.isBlank()) return "";
        if (s.length()==1) return s;
        String letter = s.substring(0,1);
        String letter2 = s.substring(1,2);
        if (letter.equals("p") && letter2.equals("i")) return "3.14" + changePi(s.substring(2));
        return letter + changePi(s.substring(1));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal<=0) throw new IllegalArgumentException();
        if (getal==1) return 0;
        return 1 + tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst==null || lijst.size()==0) throw new IllegalArgumentException();
        if (lijst.size()==1) return lijst.get(0);
        double getal1 = lijst.get(0);
        double getal2 = lijst.get(1);
        if (getal1>getal2) lijst.remove(1);
        else lijst.remove(0);
        return findMaximum(lijst);
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string == null)
            throw new IllegalArgumentException();
        ArrayList<String> res = new ArrayList<String>();
        if (string.length() <= 1) { //ook de lege string telt mee!
            res.add(string);
            return res;
        }
        else {
            res.add(string.substring(0, 1));
            ArrayList<String> res2 = findSubstrings(string.substring(1));
            res.addAll(res2);
            for (String s : res2) {
                res.add(string.charAt(0) + s);
            }
            return res;
        }
    }

    // oefening 11;
    public static int aantalKaarten(int n) {
        if (n<=0) throw new IllegalArgumentException();
        if (n==1) return 2;
        return 2 + (n-1)*3 + aantalKaarten(n-1);
    }

}