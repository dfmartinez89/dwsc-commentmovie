package dwsc.proyecto.commentmovie.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dwsc.proyecto.commentmovie.domain.Comment;

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentRepository extends MongoRepository<Comment, String> {
	public Iterable<Comment> findAllByMovieId(String movieId);
}
