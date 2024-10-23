import com.ticketmachine.PapelMoeda;
import java.util.NoSuchElementException;

public class PapelMoedaInvalidaException extends Exception {
    public PapelMoedaInvalidaException(String message) {
        super(message);
    }
}
