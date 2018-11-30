package com.github.ontio.service.impl;

import com.github.ontio.dao.BetsInfoMapper;
import com.github.ontio.model.BetInfo;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IBetsHandleService;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("BetsHandleService")
@MapperScan("com.github.ontio.dao")
public class BetsHandleServiceImpl implements IBetsHandleService {

    private static final String VERSION = "1.0";

    @Autowired
    private BetsInfoMapper betsInfoMapper;


    @Override
    public Result getBetsByPage(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<Map> allBets = betsInfoMapper.selectBetInfoByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", allBets);
        return Helper.result("getbetsbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMyBets(String bettor) {
        List<Map> betsBettor= betsInfoMapper.selectBetInfoByBettor(bettor);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", betsBettor);
        return Helper.result("getmybets", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result insertBetInfo(BetInfo betInfo) {
        int res = betsInfoMapper.insertBetInfo(betInfo);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", res);
        return Helper.result("savebetinfo", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getHugeWinsTopByNum(Integer num) {
        List<Map> hugeWinsTop= betsInfoMapper.selectHugeWinsTopByNum(num);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", hugeWinsTop);
        return Helper.result("gethugewinstopbynum", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result insertHugeWin(BetInfo betInfo) {
        int total = betsInfoMapper.selectHugeWinTotalNum();
        int res;
        if (total < 10){
            res = betsInfoMapper.insertHugeWin(betInfo);
        }else {
            Map betInfoMinMap = betsInfoMapper.selectHugeWinMinBetInfo();
            BigDecimal minPayout = (BigDecimal) betInfoMinMap.get("payout");
            if(betInfo.payout.compareTo(minPayout) > 0){
                int id = (int)betInfoMinMap.get("id");
                int deleteRes = betsInfoMapper.deleteHugeWinMinBetInfoById(id);
                res = betsInfoMapper.insertHugeWin(betInfo);
            }else {
                res = 1;
            }
            res = 1;
        }
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", res);
        return Helper.result("savehugewin", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

}
