package backend.function;

import java.sql.SQLException;

public interface F<T> {
    T apply(T... x) throws SQLException;
}
