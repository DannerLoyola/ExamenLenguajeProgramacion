package prueba;

import dao.SubjectDAO;
import dao.SubjectDaoImpl;

public class Prueba03 {

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDaoImpl();

        dao.delete(1); // 

        ((SubjectDaoImpl) dao).close(); 
        
    }
}
