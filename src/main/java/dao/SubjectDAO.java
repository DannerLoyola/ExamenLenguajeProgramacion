package dao;

import java.util.List;

import model.Subject;

public interface SubjectDAO {
	
	    void create(Subject sub);
	    void update(Subject sub);
	    void delete(Integer id);
	    Subject find(Integer id);
	    List<Subject> findAll();
	}

	


