package eva3_3_comparator;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Date;
public class EVA3_3_COMPARATOR {
    public static void main(String[] args) {
        LinkedList<Persona> lista = new LinkedList<Persona> ();
       lista.add(new Persona("Juan", "Perez", new Date(1980 - 1900, 10, 11)));
        lista.add(new Persona("Karla", "Hernandez", new Date(2005 - 1900, 5, 30)));
        lista.add(new Persona("Antonio", "Zarate", new Date(2025 - 1900, 10, 11)));

        Comparator<Persona> nombreComparator = new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        };
        lista.sort(nombreComparator);
        for (Persona p : lista) {
            System.out.println(p);
        }
        Comparator<Persona> cmpApellido = new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareToIgnoreCase(p2.getApellido());
            }
        };
        lista.sort(cmpApellido);
        lista.forEach(System.out::println);
        Comparator<Persona> cmpFechaNac = new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getFechaNac().compareTo(p2.getFechaNac());
            }
        };
                lista.sort(cmpFechaNac);
        lista.forEach(System.out::println);
    }
}

class Persona {
    private String nombre;
    private String apellido;
    private Date fechaNac;

    public Persona(String nombre, String apellido, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + fechaNac + ")";
    }
}