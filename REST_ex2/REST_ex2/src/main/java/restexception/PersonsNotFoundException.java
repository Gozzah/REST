package restexception;

/**
 *
 * @author Peter Riis
 */
public class PersonsNotFoundException extends Exception {

    public PersonsNotFoundException() {
    }

    public PersonsNotFoundException(String msg) {
        super(msg);
    }
}
