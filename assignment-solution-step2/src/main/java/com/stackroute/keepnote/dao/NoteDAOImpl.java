package com.stackroute.keepnote.dao;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	SessionFactory sessionFactory;

	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Serializable id = getSession().save(note);
		if (id != null) {
			return true;
		}
		return false;
	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		Note note = getNoteById(noteId);
		if (note != null) {
			getSession().delete(note);
			return true;
		}
		return false;
	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		/*List<Note> noteList = (List<Note>) getSession().createQuery("from Note").getResultList();
		noteList.sort(Comparator.comparing(Note:: getCreatedAt).reversed());
		return noteList;*/
		return sessionFactory.getCurrentSession()
				.createQuery("from Note order by createdAt desc", Note.class)
				.getResultList();
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		/*Query query = getSession().createQuery("from Note where noteId=?1");
		query.setParameter(1, noteId);
		return  (Note) query.getSingleResult();*/
		return sessionFactory.getCurrentSession()
				.createQuery("from Note where noteId = :noteId", Note.class)
				.setParameter("noteId", noteId)
				.uniqueResult();

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		/*if(note!=null) {
			getSession().update(note);
			return true;
		}
		return false;*/
		if (note == null) {
			return false;
		}
		sessionFactory.getCurrentSession().update(note);
		return true;

	}

}
