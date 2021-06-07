package com.guedim.springbank.user.query.api.repositories;

import com.guedim.springbank.user.core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
