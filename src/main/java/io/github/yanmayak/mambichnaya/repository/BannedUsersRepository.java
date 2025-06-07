package io.github.yanmayak.mambichnaya.repository;

import io.github.yanmayak.mambichnaya.entity.User;
import io.github.yanmayak.mambichnaya.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannedUsersRepository extends JpaRepository<User, Long> {
}
