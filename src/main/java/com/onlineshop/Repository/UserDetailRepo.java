package com.onlineshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.entity.UserDetail;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {

}
