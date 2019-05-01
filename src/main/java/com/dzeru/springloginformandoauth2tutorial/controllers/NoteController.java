package com.dzeru.springloginformandoauth2tutorial.controllers;

import com.dzeru.springloginformandoauth2tutorial.entities.Note;
import com.dzeru.springloginformandoauth2tutorial.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController
{
	@Autowired
	private NoteRepo noteRepo;

	@GetMapping("/notes")
	public String notes(Model model)
	{
		List<Note> notes = noteRepo.findAll();
		model.addAttribute("notes", notes);

		return "notes";
	}

	@PostMapping("/addnote")
	public String addNote(String title, String note)
	{
		Note newNote = new Note();
		newNote.setTitle(title);
		newNote.setNote(note);

		noteRepo.save(newNote);

		return "redirect:/notes";
	}
}
