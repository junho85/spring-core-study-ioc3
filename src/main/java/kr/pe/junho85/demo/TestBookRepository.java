package kr.pe.junho85.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("test")
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
