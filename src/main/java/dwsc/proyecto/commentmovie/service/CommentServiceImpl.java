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
	
	public void saveComment (Comment comment) {
		commentRepo.save(comment);
	}

	public double getScoreAverageByMovie(String movieId) {
		Iterable<Comment> comments = commentRepo.findAllByMovieId(movieId);
		int elem = 0;
		double totalScore = 0;
		for (Comment comment : comments) {
			elem++;
			totalScore = totalScore + comment.getScore();
		}

		if (elem != 0) {
			return totalScore / elem;
		} else {
			return 0;
		}

	}

}
