import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Revizor1", 120, "Gogol");
        Book book2 = new Book(2, "Revizor2", 120, "Gogol");
        Book book3 = new Book(3, "Zorro", 120, "Makkali");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchNameBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Revizor1", 120, "Gogol");
        Book book2 = new Book(2, "Revizor2", 120, "Gogol");
        Book book3 = new Book(3, "Zorro", 120, "Makkali");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Zorro");

        Assertions.assertArrayEquals(expected, actual);

    }


}
