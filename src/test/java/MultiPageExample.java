import page.example.PageA;
import page.example.PageB;
import page.example.PageC;

public class MultiPageExample {
    public static void main(String[] args) {
        PageA a = new PageA();
        PageB b = new PageB();
        PageC c = new PageC();
        System.out.println(a.getTitle());
        System.out.println(b.getTitle());
        System.out.println(c.getTitle());
    }
}
