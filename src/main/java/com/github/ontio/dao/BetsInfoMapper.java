package com.github.ontio.dao;


import com.github.ontio.model.BetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "BetsInfoMapper")
public interface BetsInfoMapper {
    List<Map> selectBetInfoByPage(Integer start, Integer pageSize);
    List<Map> selectBetInfoByBettor(String bettor);
    List<Map> selectMyBetInfoByPage(String bettor, Integer start, Integer pageSize);
    int insertBetInfo(BetInfo betInfo);
    int insertHugeWin(BetInfo hugeWin);
    List<Map> selectHugeWinsByPage(Integer start, Integer pageSize);
    List<Map> selectHugeWinsTopByNum(Integer num);
    int selectHugeWinTotalNum();
    Map selectHugeWinMinBetInfo();
    int deleteHugeWinMinBetInfoById(Integer id);
}
