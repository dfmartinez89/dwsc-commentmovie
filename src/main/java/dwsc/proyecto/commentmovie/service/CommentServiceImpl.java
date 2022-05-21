package dwsc.proyecto.commentmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.commentmovie.dao.CommentRepository;
import dwsc.proyecto.commentmovie.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepo;

	public Iterable<Comment> getAllByMovieId(String movieId) {
		return commentRepo.findAllByMovieId(movieId);
	}

	public void saveComment(Comment comment) {
		commentRepo.save(comment);
	}

}
