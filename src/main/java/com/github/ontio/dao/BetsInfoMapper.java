package com.github.ontio.dao;


import com.github.ontio.model.BetInfo;
import com.github.ontio.model.BetInfoWithId;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "BetsInfoMapper")
public interface BetsInfoMapper {
    List<BetInfo> selectBetInfoByPage(Integer start, Integer pageSize);
    List<BetInfo> selectBetInfoByBettor(String bettor);
    List<BetInfo> selectMyBetInfoByPage(String bettor, Integer start, Integer pageSize);
    int insertBetInfo(BetInfo betInfo);
    int insertHugeWin(BetInfo hugeWin);
    List<BetInfo> selectHugeWinsByPage(Integer start, Integer pageSize);
    List<Map> selectHugeWinsTopByNum(Integer num);
    int selectHugeWinTotalNum();
    Map selectHugeWinMinBetInfo();
    int updateHugeWinMinBetInfoById(BetInfoWithId betInfoWithId);
}
