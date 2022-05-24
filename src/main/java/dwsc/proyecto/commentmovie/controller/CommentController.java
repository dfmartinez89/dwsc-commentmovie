package dwsc.proyecto.commentmovie.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dwsc.proyecto.commentmovie.domain.Comment;
import dwsc.proyecto.commentmovie.domain.Movie;
import dwsc.proyecto.commentmovie.exceptions.CustomResponse;
import dwsc.proyecto.commentmovie.exceptions.MovieNotFoundException;
import dwsc.proyecto.commentmovie.service.CommentService;
import dwsc.proyecto.commentmovie.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "comment", description = "create comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	MovieService movieService;

	@Operation(summary = "Get all comments related to a given movie", description = "Operation to list comments")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "comments listed succesfully"),
			@ApiResponse(responseCode = "404", description = "comment not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.GET, path = "/comment/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Comment>> getAllCommentsByMovieId(
			@Parameter(description = "Movie id") @PathVariable String movieId) throws MovieNotFoundException {
		Optional<Movie> movie = movieService.findMovieById(movieId);
		if (!movie.isPresent()) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND,
					"The movie with id: " + movieId + " does not exists");
		}

		return ResponseEntity.ok(commentService.getAllByMovieId(movieId));
	}

	@Operation(summary = "insert a new comment related to a given movie", description = "Operation to create a comment")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "comment created succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.POST, path = "/comment/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> saveComment(@Parameter(description = "Movie id") @PathVariable String movieId,
			@Parameter(description = "Comment details") @RequestBody Comment comment) throws MovieNotFoundException {
		Optional<Movie> movie = movieService.findMovieById(movieId);

		if (!movie.isPresent()) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND,
					"The movie with id: " + movieId + " does not exists");
		}

		comment.setMovie(movie.get());

		commentService.saveComment(comment);

		double score = movieService.getScoreAverageByMovie(movieId);
		movieService.updateScore(movieId, score);

		return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);

	}
}
