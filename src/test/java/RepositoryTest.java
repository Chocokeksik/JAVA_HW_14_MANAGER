import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Book book1 = new Book(1, "Revizor1", 120, "Gogol");
    Book book2 = new Book(2, "Revizor2", 120, "Gogol");
    Book book3 = new Book(3, "Zorro", 120, "Makkali");

    @Test
    public void shouldSaveOneItem() {
        repo.add(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

