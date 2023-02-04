import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundTest {

    @Test
    public void testRemove() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"Revizor1", 120, "Gogol");
        Book book2 = new Book(2, "Revizor2", 120, "Gogol");
        Book book3 = new Book(3,"Zorro", 120, "Makkali");
        Smartphone smartphone1 = new Smartphone(4, "Galaxy", 1000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);

        Assertions.assertThrows(NotFoundException.class,
                () -> manager.removeByID(6));

    }

    @Test
    public void testRemove2() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"Revizor1", 120, "Gogol");
        Book book2 = new Book(2, "Revizor2", 120, "Gogol");
        Book book3 = new Book(3,"Zorro", 120, "Makkali");
        Smartphone smartphone1 = new Smartphone(4, "Galaxy", 1000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.removeByID(4);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}
