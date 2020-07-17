package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.T_result_commit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_result_commitService extends BaseService<T_result_commit> {


    public List<T_result_commit> selectList(Long ref_id) {
        T_result_commit t_result_commit=new T_result_commit();
        t_result_commit.setRefId(ref_id);
        List<T_result_commit> commitList = super.selectList(t_result_commit);
        if (commitList.size()>0&& commitList!=null){
            return commitList;
        }
        return null;
    }
}
