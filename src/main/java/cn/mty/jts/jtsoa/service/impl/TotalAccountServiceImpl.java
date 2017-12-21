package cn.mty.jts.jtsoa.service.impl;

import cn.mty.jts.jtsoa.dao.TotalAccountMapper;
import cn.mty.jts.jtsoa.pojo.TotalAccount;
import cn.mty.jts.jtsoa.service.TotalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalAccountServiceImpl implements TotalAccountService{
    @Autowired
    private TotalAccountMapper totalAccountMapper;
    @Transactional
    @Override
    public int updateTotalAccount(TotalAccount totalAccount) throws Exception {
        return totalAccountMapper.updateTotalAccount(totalAccount);
    }

    @Override
    public long getTotalAccount() throws Exception {
        return totalAccountMapper.getTotalAccount();
    }
}
