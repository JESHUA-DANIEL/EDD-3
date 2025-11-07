package eva3_2_collections;
import java.util.Comparator;
import java.util.LinkedList;
public class EVA3_2_COLLECTIONS {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer> ();
        lista.add(500);
        lista.add(400);
        lista.add(300);
        lista.add(200);
        lista.add(100);
        System.out.println(lista);
        //comparator
        Comparator comparator = new Comparator(){
            @Override
        public int compare(Object o1, Object o2){
            Integer val1 = (Integer)o1;
            Integer val2 = (Integer)o2;
            return val1 - val2;
        }
        };
        lista.sort(comparator);
        System.out.println(lista);
                }
    }
    

