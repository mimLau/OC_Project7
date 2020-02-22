package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.users.Member;
import com.mimi.mlibrary.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query( "SELECT m FROM Member m" )
    List<Member> getAllMembers();

    @Query( "SELECT m FROM Member m WHERE m.id= :id" )
    Member getMemberById( @Param("id") Integer id);

    @Query( "SELECT m FROM Member m WHERE m.email= :email" )
    Member getMemberByEmail( @Param("email") String email);

    @Query( "SELECT m FROM Member m WHERE m.firstname= :firstname AND m.lastname= :lastname")
    Member getMemberByNames( @Param("firstname") String firstname, @Param("lastname") String lastname );

    /*@Query ("UPDATE Member m SET m.getNbOfCurrentsBorrowings = m.getNbOfCurrentsBorrowings + :increment WHERE m.barcode= :barcode")
    void incrementNbOfCurrentsBorrowings( @Param("increment") int increment, @Param("barcode") int barcode );*/

    /*
    * @Query ("UPDATE Member m SET m.nbOfCurrentsBorrowings = m.nbOfCurrentsBorrowings + 1 WHERE m.barcode= :barcode")
    void incrementNbOfCurrentsBorrowings( @Param("barcode") String barcode );*/

    @Modifying
    @Transactional
    @Query ("UPDATE Member m SET m.nbOfCurrentsBorrowings = m.nbOfCurrentsBorrowings + 1 WHERE m.barcode= :barcode")
    void incrementNbOfCurrentsBorrowings( @Param("barcode") String barcode );

}
