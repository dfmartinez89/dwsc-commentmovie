package dwsc.proyecto.commentmovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.commentmovie.dao.CommentRepository;
import dwsc.proyecto.commentmovie.dao.MovieRepository;
import dwsc.proyecto.commentmovie.domain.Comment;
import dwsc.proyecto.commentmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepo;

	@Autowired
	CommentRepository commentRepo;

	@Override
	public Optional<Movie> findMovieById(String movieId) {
		return movieRepo.findById(movieId);
	}

	@Override
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

	@Override
	public void updateScore(String id, double score) {
		Optional<Movie> movieOptional = movieRepo.findById(id);

		Movie movie = movieOptional.get();
		movie.setScore(score);

		movieRepo.save(movie);

	}

}
