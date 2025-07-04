package zairastra.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String isbn) {
        super("Non esiste un elemento in catalogo con codice ISBN " + isbn);
    }
}
