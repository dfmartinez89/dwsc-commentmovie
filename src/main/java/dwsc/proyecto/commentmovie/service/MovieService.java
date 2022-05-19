package dwsc.proyecto.commentmovie.service;

import org.springframework.stereotype.Service;

@Service
public interface MovieService {
	public void updateScore(String id, int score);
}
