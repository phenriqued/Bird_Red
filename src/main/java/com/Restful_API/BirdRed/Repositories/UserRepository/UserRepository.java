package com.Restful_API.BirdRed.Repositories.UserRepository;

import com.Restful_API.BirdRed.Entities.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
