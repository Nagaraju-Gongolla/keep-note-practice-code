package com.stackroute.keepnote.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


import com.stackroute.keepnote.model.Note;

/*
 * This class contains the code for data storage interactions and methods
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

public class NoteRepository {

    /* Declare a variable called "list" to store all the notes. */
    private List<Note> list;

    public NoteRepository() {

        /* Initialize the variable using proper data type */
        list = new ArrayList<>();
    }

    /* This method should return all the notes in the list */

    public List<Note> getList() {
        return this.list;
    }

    /* This method should set the list variable with new list of notes */

    public void setList(List<Note> list) {
        this.list = list;
    }

    /*
     * This method should Note object as argument and add the new note object into
     * list
     */

    public void addNote(Note note) {
        this.list.add(note);
    }

    /* This method should deleted a specified note from the list */

    public boolean deleteNote(int noteId) {
        /* Use list iterator to find matching note id and remove it from the list */
        List<Note> notesList1 = this.getAllNotes();
        ListIterator<Note> iterator = notesList1.listIterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getNoteId() == noteId) {
                this.list.remove(note);
                return true;
            }
        }
        return false;
    }

    /* This method should return the list of notes */

    public List<Note> getAllNotes() {
        return this.getList();
    }

    /*
     * This method should check if the matching note id present in the list or not.
     * Return true if note id exists in the list or return false if note id does not
     * exists in the list
     */

    public boolean exists(int noteId) {

        //List<Note> notesList = this.getAllNotes();
        List<Note> notesList = this.getAllNotes();
        ListIterator<Note> iterator = notesList.listIterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getNoteId() == noteId) {
                return true;
            }
        }

        return false;
//		for(Note note: notesList) {
//			if(note.getNoteId()==noteId) {
//				return true;
//			}
//		}
//		return false;
    }

	// updating the note if already present in the notes

	public boolean updateNote(Note incomingNote){
		boolean isUpdated = false;
		int incomingNoteNoteId = incomingNote.getNoteId();
		if(this.exists(incomingNoteNoteId)){
			for(Note note1 : getAllNotes()){
				if(note1.getNoteId() == incomingNoteNoteId){
					Note existingNote = note1;
					existingNote.setNoteTitle(incomingNote.getNoteTitle());
					existingNote.setNoteContent(incomingNote.getNoteContent());
					existingNote.setNoteStatus(incomingNote.getNoteStatus());
					existingNote.setCreatedAt(LocalDateTime.now());
					isUpdated = true;
				}
			}

		}else isUpdated = false;

		return isUpdated;
	}
}