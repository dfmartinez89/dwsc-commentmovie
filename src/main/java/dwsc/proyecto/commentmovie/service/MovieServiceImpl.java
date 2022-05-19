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

	public void updateScore(String id, int score) {
		Optional<Movie> movieOptional = movieRepo.findById(id);

		Movie movie = movieOptional.get();
		movie.setAverageScore(score);

		movieRepo.save(movie);

	}

}
