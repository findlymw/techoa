package cn.mty.jts.jtsoa.service.impl;

import cn.mty.jts.jtsoa.dao.TotalAccountMapper;
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
    public int updateTotalAccount(TotalAccountMapper totalAccount) throws Exception {
        return totalAccountMapper.updateTotalAccount(totalAccount);
    }
}
