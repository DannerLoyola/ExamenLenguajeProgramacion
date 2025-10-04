package prueba;

import dao.SubjectDAO;
import dao.SubjectDaoImpl;
import model.Subject;

public class Prueba01 {

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDaoImpl();
        
        
        Subject sub = new Subject();
        sub.setSubject("carlos");
        sub.setCredits("25");  
                    
        
        
        dao.create(sub);
        
    }
}
