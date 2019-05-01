package com.dzeru.springloginformandoauth2tutorial.repos;

import com.dzeru.springloginformandoauth2tutorial.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface NoteRepo extends JpaRepository<Note, Long>
{
	List<Note> findByUserId(Long userId);
}
