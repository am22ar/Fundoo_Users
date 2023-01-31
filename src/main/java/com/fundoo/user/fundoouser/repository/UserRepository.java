package com.fundoo.user.fundoouser.repository;

import com.fundoo.user.fundoouser.dto.LoginDto;
import com.fundoo.user.fundoouser.model.User;
import io.netty.util.AsyncMapping;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Mono<User> findByEmail(String email);
}
