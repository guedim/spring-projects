package ch.frankel.blog.multiboot.web

import ch.frankel.blog.multiboot.repo.*
import ch.frankel.blog.multiboot.service.*
import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.boot.autoconfigure.domain.*
import org.springframework.data.jpa.repository.config.*
import org.springframework.web.bind.annotation.*

@SpringBootApplication(scanBasePackageClasses = [ServiceConfig::class])
@EntityScan(basePackageClasses = [RepoConfig::class])
@EnableJpaRepositories(basePackageClasses = [RepoConfig::class])
class WebApplication

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}

@RestController
class PersonController(private val service: PersonService) {

    @GetMapping
    fun getPersons() = service.persons()
}