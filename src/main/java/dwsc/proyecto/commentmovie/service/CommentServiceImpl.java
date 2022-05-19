package dwsc.proyecto.commentmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.commentmovie.dao.CommentRepository;
import dwsc.proyecto.commentmovie.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepo;

	@Override
	public double getScoreAverageByMovie(String movieId) {
		List<Comment> comments = commentRepo.findAllByMovieId(movieId);
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
