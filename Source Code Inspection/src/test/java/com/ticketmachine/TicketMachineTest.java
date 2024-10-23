import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {

    private TicketMachine tm;

    @Before
    public void setUp() {
        tm = new TicketMachine(100);  // Preço do bilhete: 100
    }

    @Test
    public void testInsertValidAmount() {
        tm.insert(50);  // Insere um valor de 50
        assertEquals(50, tm.getBalance());  // Verifica se o saldo é 50
    }

    @Test
    public void testInsertInvalidAmount() {
        try {
            tm.insert(-10);  // Tenta inserir um valor inválido
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Valor inválido", e.getMessage());
        }
    }

    @Test
    public void testPrintTicketWithSufficientFunds() throws Exception {
        tm.insert(100);  // Insere o valor exato do ticket
        assertTrue(tm.print());  // Verifica se o bilhete é impresso
    }

    @Test
    public void testPrintTicketWithInsufficientFunds() {
        tm.insert(50);  // Insere um valor insuficiente
        try {
            tm.print();
            fail("Deveria ter lançado exceção de saldo insuficiente");
        } catch (Exception e) {
            assertEquals("Saldo insuficiente", e.getMessage());
        }
    }
}
