package com.github.ontio.asyncService;

import com.alibaba.fastjson.JSONArray;
import com.github.ontio.common.Address;
import com.github.ontio.dao.BankerInfoMapper;
import com.github.ontio.dao.BetsInfoMapper;
import com.github.ontio.model.BankerInfo;
import com.github.ontio.model.BetInfo;
import com.github.ontio.model.BetInfoWithId;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service
public class BlkSyncService {

    private static final Logger logger = LoggerFactory.getLogger(BlkSyncService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private BetsInfoMapper betsInfoMapper;

    @Autowired
    private BankerInfoMapper bankerInfoMapper;


    /**
     * handle the block and the transactions in this block
     *
     * @param
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void handleEventList(List<Object> stateList, int dbBlockHeight) throws Exception {

        //设置一个模式为BATCH，自动提交为false的session，最后统一提交，需防止内存溢出

        logger.info("{} run-------", Helper.currentMethod());
        for(Object obj : stateList) {
            String funcName = new String(com.github.ontio.common.Helper.hexToBytes(((JSONArray)obj).getString(0)));
            if (funcName.equals("bet")) {
                String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
                int rollUnder = (Integer) ((JSONArray)obj).get(3);
                double bet = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(5)),16).doubleValue();
                BigDecimal betBig = BigDecimal.valueOf(bet/1000000000);
                int roll = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(4)),16).intValue();
                Long payout = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(6)),16);
                BigDecimal payoutWin = BigDecimal.valueOf(payout.doubleValue()/1000000000);

                BetInfo betInfo = new BetInfo();
                betInfo.setBettor(bettor);
                betInfo.setRollUnder(rollUnder);
                betInfo.setBet(betBig);
                betInfo.setPayout(payoutWin);
                betInfo.setRoll(roll);
                betsInfoMapper.insertBetInfo(betInfo);
                if(payoutWin.compareTo(BigDecimal.ZERO) != 0) {
                    int total = betsInfoMapper.selectHugeWinTotalNum();
                    if (total < ConstantParam.HUGE_WIN_SIZE){
                        betsInfoMapper.insertHugeWin(betInfo);
                    } else {
                        Map betInfoMinMap = betsInfoMapper.selectHugeWinMinBetInfo();
                        BigDecimal minPayout = (BigDecimal) betInfoMinMap.get("payout");
                        if(betInfo.payout.compareTo(minPayout) > 0){
                            int id = (int)betInfoMinMap.get("id");
                            BetInfoWithId betInfoWithId = new BetInfoWithId();
                            betInfoWithId.id = id;
                            betInfoWithId.bettor = betInfo.bettor;
                            betInfoWithId.bet = betInfo.bet;
                            betInfoWithId.rollUnder = betInfo.rollUnder;
                            betInfoWithId.payout = betInfo.payout;
                            betInfoWithId.roll = betInfo.roll;
                            betsInfoMapper.updateHugeWinMinBetInfoById(betInfoWithId);
                        }
                    }
                }
            } else if (funcName.equals("bankerInvest")) {
                String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
                double bet = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
                BigDecimal ongAmount = BigDecimal.valueOf(bet/1000000000);
                BankerInfo bankerInfo = new BankerInfo();
                bankerInfo.setBanker(bettor);
                bankerInfo.setOngAmount(ongAmount);
                bankerInfoMapper.insertBankerInvest(bankerInfo);
            } else if (funcName.equals("bankerWithdrawDividend")) {
                String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
                double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
                BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/1000000000);
                BankerInfo bankerInfo = new BankerInfo();
                bankerInfo.setBanker(bettor);
                bankerInfo.setOngAmount(ongAmt);
                bankerInfoMapper.insertBankerInvest(bankerInfo);
            } else if (funcName.equals("bankerWithdrawEarning")) {
                String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
                double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
                BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/1000000000);
                BankerInfo bankerInfo = new BankerInfo();
                bankerInfo.setBanker(bettor);
                bankerInfo.setOngAmount(ongAmt);
                bankerInfoMapper.insertBankerInvest(bankerInfo);
            } else if (funcName.equals("bankerExit")) {
                String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
                double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
                BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/1000000000);
                BankerInfo bankerInfo = new BankerInfo();
                bankerInfo.setBanker(bettor);
                bankerInfo.setOngAmount(ongAmt);
                bankerInfoMapper.insertBankerInvest(bankerInfo);
            }
        }
    }
}
