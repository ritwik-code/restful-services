package com.practice.restwebservices.restfulservices.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post,Integer> {
}
