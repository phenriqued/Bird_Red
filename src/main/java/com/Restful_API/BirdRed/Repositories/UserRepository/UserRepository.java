package com.Restful_API.BirdRed.Repositories.UserRepository;

import com.Restful_API.BirdRed.Entities.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByNicknameOrEmail(String nickname, String email);

}
