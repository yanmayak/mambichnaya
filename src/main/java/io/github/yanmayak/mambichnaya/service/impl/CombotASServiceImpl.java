package io.github.yanmayak.mambichnaya.service.impl;

import io.github.yanmayak.mambichnaya.client.CombotASClient;
import io.github.yanmayak.mambichnaya.model.CombotASDto;
import io.github.yanmayak.mambichnaya.service.CombotASService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CombotASServiceImpl implements CombotASService {
    private final CombotASClient combotASClient;

    @Override
    public Boolean CombotASCheck(Long userId) {
        CombotASDto combotResponse = combotASClient.combotASCheck(userId.intValue());
        return combotResponse.getReason().isEmpty();
    }
}
