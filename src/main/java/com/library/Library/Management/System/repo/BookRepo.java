package com.library.Library.Management.System.repo;

import com.library.Library.Management.System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>
{

}
