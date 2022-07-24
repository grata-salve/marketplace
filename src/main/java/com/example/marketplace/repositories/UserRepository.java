package com.example.marketplace.repositories;

import com.example.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update Product u set u.user.id = ?1 where u.id = ?2")
    void setBuyer(int userId, Integer id);

    @Query(value="select b.* from buyer b inner join product p on p.userid = b.id", nativeQuery=true)
    public List<User> productBuyer(int id);
}
