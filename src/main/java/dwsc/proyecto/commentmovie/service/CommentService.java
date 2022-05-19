package dwsc.proyecto.commentmovie.service;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	public double getScoreAverageByMovie(String movieId);
}
