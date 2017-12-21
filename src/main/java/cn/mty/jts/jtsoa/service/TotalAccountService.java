package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.dao.TotalAccountMapper;

public interface TotalAccountService {
    public int updateTotalAccount(TotalAccountMapper totalAccount) throws Exception;
    public long getTotalAccount() throws Exception;
}
