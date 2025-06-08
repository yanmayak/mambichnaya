package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.repository.BannedUsersRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckBanned {
    private final BannedUsersRepository banned;

    public CheckBanned(BannedUsersRepository banned) {
        this.banned = banned;
    }

    public boolean checkBanned(Long userId) {
        return banned.findById(userId).isPresent();
    }
}
