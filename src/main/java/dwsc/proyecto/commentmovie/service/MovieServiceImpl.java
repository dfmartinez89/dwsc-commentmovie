package dwsc.proyecto.commentmovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.commentmovie.dao.MovieRepository;
import dwsc.proyecto.commentmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepo;

	public Optional<Movie> findMovieById(String movieId) {
		return movieRepo.findById(movieId);
	}

	public void updateScore(String id, double score) {
		Optional<Movie> movieOptional = movieRepo.findById(id);

		Movie movie = movieOptional.get();
		movie.setAverageScore(score);

		movieRepo.save(movie);

	}

}
