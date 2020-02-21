package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.users.Admin;
import com.mimi.mlibrary.model.users.Librarian;
import com.mimi.mlibrary.model.users.Member;
import com.mimi.mlibrary.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT m FROM Member m")
    List<Member> getAllMembers();

    @Query("SELECT m FROM Member m WHERE m.id= :id")
    Member getMemberById( @Param("id") Integer id);

    @Query("SELECT m FROM Member m WHERE m.email= :email")
    Member getMemberByEmail( @Param("email") String email);

    @Query("SELECT m FROM Member m WHERE m.firstname= :firstname AND m.lastname= :lastname")
    Member getMemberByNames( @Param("firstname") String firstname, @Param("lastname") String lastname );
}
