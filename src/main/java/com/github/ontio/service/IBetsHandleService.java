package com.github.ontio.service;

import com.github.ontio.model.BetInfo;
import com.github.ontio.paramBean.Result;

public interface IBetsHandleService {
    Result getBetsByPage(Integer pageSize, Integer pageNumber);
    Result getMyBets(String bettor);
    Result insertBetInfo(BetInfo betInfo);

    Result getHugeWinsTopByNum(Integer num);
    Result insertHugeWin(BetInfo betInfo);
}
