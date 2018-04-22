package ch.frankel.blog.multiboot.service

import ch.frankel.blog.multiboot.repo.PersonRepository
import org.springframework.context.annotation.*

@Configuration
class ServiceConfig {

    @Bean
    fun service(repo: PersonRepository) = PersonService(repo)
}

class PersonService(private val repo: PersonRepository) {
    fun persons() = repo.findAll()
}