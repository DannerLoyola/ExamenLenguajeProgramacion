package prueba;

import dao.SubjectDaoImpl;
import model.Subject;
import java.util.List;

public class Prueba05 {

    public static void main(String[] args) {
        SubjectDaoImpl dao = new SubjectDaoImpl();

        
        List<Subject> resultados = dao.findByName("Roberto");

        for (Subject sub : resultados) {
            System.out.println(sub.getIdsubject() + " - " + sub.getSubject() + " - " + sub.getCredits());
        }

        dao.close();
    }
}
