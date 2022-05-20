package dwsc.proyecto.commentmovie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommentDuplicatedException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public CommentDuplicatedException(HttpStatus code, String message) {
		super(code, message);
	}
}
