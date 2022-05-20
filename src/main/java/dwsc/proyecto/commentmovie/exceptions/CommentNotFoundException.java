package dwsc.proyecto.commentmovie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommentNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public CommentNotFoundException(HttpStatus code, String message) {
		super(code, message);
	}

}
