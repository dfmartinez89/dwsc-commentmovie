package dwsc.proyecto.commentmovie.service;

import org.springframework.stereotype.Service;

import dwsc.proyecto.commentmovie.domain.Comment;

@Service
public interface CommentService {
	public Iterable<Comment> getAllByMovieId(String movieId);

	public double getScoreAverageByMovie(String movieId);
	
	public void saveComment (Comment comment);
}
