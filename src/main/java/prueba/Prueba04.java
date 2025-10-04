package prueba;

import dao.SubjectDAO;
import dao.SubjectDaoImpl;
import model.Subject;

import java.util.List;

public class Prueba04 {

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDaoImpl();

        List<Subject> lista = dao.findAll();

        for (Subject sub : lista) {
            System.out.println(sub.getIdsubject() + " - " + sub.getSubject() + " - " + sub.getCredits());
        }

        ((SubjectDaoImpl) dao).close();
    }
}
