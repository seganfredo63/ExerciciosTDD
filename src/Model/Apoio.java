package Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Apoio {
    void executa(HttpServletRequest req,
            HttpServletResponse res) throws Exception;
}