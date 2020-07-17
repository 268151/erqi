package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.T_mapping_unitMapper;
import com.aaa.mapper.T_scoreMapper;
import com.aaa.model.T_mapping_unit;
import com.aaa.model.T_score;
import com.aaa.utils.IdUtils;
import com.aaa.utils.TimeUtils;
import com.aaa.vo.ScoreVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class T_scoreService extends BaseService<T_score> {

    @Autowired
    private T_scoreMapper scoreMapper;

    @Autowired
    private T_mapping_unitMapper mapping_unitMapper;

    public PageInfo<T_score> selectScoreByPage(ScoreVo scoreVo, Long unit_id) throws Exception {
        if (scoreVo.getPageNum()==null){
            scoreVo.setPageNum(1);
        }
        if (scoreVo.getPageSize()==null){
            scoreVo.setPageSize(10);
        }
        T_score t_score=new T_score();
        T_score a1 = scoreVo.getScore();

        if(a1!=null){
            t_score.setUnitId(a1.getUnitId());
        }

        t_score.setUnitId(unit_id);
        PageInfo<T_score> scorePageInfo = super.selectListByPage(t_score, scoreVo.getPageNum(), scoreVo.getPageSize());
        return scorePageInfo;
    }


    /*@Transactional(rollbackFor = Exception.class)
    public boolean insertToScore(T_score score){
        //生成id
        Long longID = IdUtils.getLongID();
        //获取创造时间
        String createTime = TimeUtils.getNowTimeYMDHMS();
        score.setId(longID).setCreateTime(createTime);
        try {
            //添加评分记录
            Integer add = super.add(score);
            //获取传递过来的单位id
            Long unitId = score.getUnitId();
            //是否加分
            Integer scorePlus = score.getScorePlus();
            if (scorePlus == null && scorePlus <= 0){
                //是否减分
                Integer scoreSubtract = score.getScoreSubtract();
                if (scoreSubtract == null && scoreSubtract <= 0){
                    if (add > 0) {
                        return true;
                    }
                }
                if (scoreSubtract > 0) {
                    //减分
                    //将数据存入TMappingUnit
                    T_mapping_unit tMappingUnit = new T_mapping_unit();
                    tMappingUnit.setScore(scoreSubtract*(-1)).setId(unitId);
                    Integer integer = mapping_unitMapper.UpdateMappingScore(tMappingUnit);
                    if (integer > 0 && add > 0) {
                        return true;
                    }
                }
            }
            if (scorePlus > 0){
                //加分
                //将数据存入TMappingUnit
                T_mapping_unit tMappingUnit = new T_mapping_unit();
                tMappingUnit.setScore(scorePlus).setId(unitId);
                Integer integer = mapping_unitMapper.UpdateMappingScore(tMappingUnit);
                if (integer > 0 && add > 0){
                    return true;
                }
            }
            if (add > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/
}
