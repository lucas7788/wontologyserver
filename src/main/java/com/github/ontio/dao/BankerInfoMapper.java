package com.github.ontio.dao;


import com.github.ontio.model.BankerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BankerInfoMapper")
public interface BankerInfoMapper {
    List<BankerInfo> selectBankerInvestByPage(String banker, Integer start, Integer pageSize);
    List<BankerInfo> selectBankerWithdrawByPage(String banker, Integer start, Integer pageSize);
    int insertBankerInvest(BankerInfo bankerInvest);
    int insertBankerWithdraw(BankerInfo bankerWithdraw);
}
