package prueba;

import dao.SubjectDAO;
import dao.SubjectDaoImpl;
import model.Subject;

public class Prueba02 {

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDaoImpl(); // ← Instanciación necesaria

        Subject sub = dao.find(1); // Buscar el registro con ID 1
        if (sub != null) {
            sub.setSubject("Roberto");
            sub.setCredits("90");
            dao.update(sub);
        } else {
            System.out.println("❌ No se encontró el registro con ID 1.");
        }

        ((SubjectDaoImpl) dao).close();
    }
}
