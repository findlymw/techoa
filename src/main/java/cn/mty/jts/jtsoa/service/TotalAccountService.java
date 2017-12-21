package cn.mty.jts.jtsoa.service;

import cn.mty.jts.jtsoa.dao.TotalAccountMapper;
import cn.mty.jts.jtsoa.pojo.TotalAccount;

public interface TotalAccountService {
    public int updateTotalAccount(TotalAccount totalAccount) throws Exception;
    public long getTotalAccount() throws Exception;
}
