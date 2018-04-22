package ch.frankel.blog.multiboot.repo

import org.springframework.context.annotation.*
import org.springframework.data.repository.*
import javax.persistence.*

@Configuration
class RepoConfig

@Entity
data class Person(@Id val id: Long, var firstName: String, var lastName: String)

interface PersonRepository : CrudRepository<Person, Long>