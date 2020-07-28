package com.aaa.service;

import com.aaa.mapper.StatisticsMapper;
import com.aaa.vo.StatisticsLevelVo;
import com.aaa.vo.StatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: StatisticsService
 * @author: 彭于晏
 * @create: 2020-07-15 20:40
 **/
@Service
public class StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    /**
     * 统计图 1.1  单位资质统计
     */
    public List<Map<String ,Object>> getQualification(){
        return statisticsMapper.getQualification();
    }

    /**
     * 统计图1.2 查询未完成成功的 和已完成的
     */
    public List<Map<String ,Object>> getNoproject(){
        List<Map<String, Object>> noproject = statisticsMapper.getNoproject();
        List<Map<String, Object>> yesproject = statisticsMapper.getYesproject();
        boolean b = noproject.addAll(yesproject);
        return noproject;
    }

    /**
     * 统计图2查询该公司的人员 人员统计
     */
   public List<Map<String ,Object>> getCompanyPeople(Integer userid){
        List<Map<String, Object>> companyPeople = statisticsMapper.getCompanyPeople(userid);
        List<Map<String, Object>> companyShebei = statisticsMapper.getCompanySpe(userid);
       List<Map<String, Object>> companyPro = statisticsMapper.getCompanyPro(userid);
       companyPeople.addAll(companyShebei);
       companyPeople.addAll(companyPro);
        return companyPeople;
    }

    /**
     * 统计图3
     */
   public List<Map<String,Object>> getSheBeiStatisticsAll(@RequestBody StatisticsVo statisticsVo ){
        List<Map<String, Object>> personnelStatistics = statisticsMapper.getPersonnelStatistics( statisticsVo);
        List<Map<String, Object>> sheBeiStatistics = statisticsMapper.getSheBeiStatistics(statisticsVo);
       List<Map<String, Object>> zhiStatistics = statisticsMapper.getZhiStatistics(statisticsVo);
       personnelStatistics.addAll(sheBeiStatistics);
       personnelStatistics.addAll(zhiStatistics);
        return personnelStatistics;
    }


    public List<StatisticsLevelVo> getMapToVo(StatisticsVo statisticsVo){
        List<Map<String, Object>> sheBeiStatisticsAll = getSheBeiStatisticsAll(statisticsVo);
        StatisticsLevelVo jia = new StatisticsLevelVo().setName("甲级");
        StatisticsLevelVo yi = new StatisticsLevelVo().setName("乙级");
        StatisticsLevelVo bing = new StatisticsLevelVo().setName("丙级");
        StatisticsLevelVo ding= new StatisticsLevelVo().setName("丁级");
        StatisticsLevelVo count= new StatisticsLevelVo().setName("丁级");

        ArrayList<StatisticsLevelVo> arrayList=new ArrayList<>();

        String [] name={"甲级","乙级","丙级","丁级"};

        arrayList.add(jia);
        arrayList.add(yi);
        arrayList.add(bing);
        arrayList.add(ding);


            for(int i=0;i<name.length;i++ ) {
                for (Map<String, Object> map : sheBeiStatisticsAll) {
                if (name[i].equals(map.get("level")) && "中级技术人员".equals(map.get("type"))) {
                    arrayList.get(i).setZhongCount(Integer.valueOf(map.get("value").toString()));
                    count.setZhongCount(count.getZhongCount()+Integer.valueOf(map.get("value").toString()));
                }
                if (name[i].equals(map.get("level")) && "初级技术人员".equals(map.get("type"))) {
                    arrayList.get(i).setChuCount(Integer.valueOf(map.get("value").toString()));
                    count.setChuCount(count.getChuCount()+Integer.valueOf(map.get("value").toString()));
                }
                if (name[i].equals(map.get("level")) && "高级技术人员".equals(map.get("type"))) {
                    arrayList.get(i).setGaoCount(Integer.valueOf(map.get("value").toString()));
                    count.setGaoCount(count.getGaoCount()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "测距仪".equals(map.get("type"))) {
                    arrayList.get(i).setCeJu(Integer.valueOf(map.get("value").toString()));
                    count.setCeJu(count.getCeJu()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "水准仪".equals(map.get("type"))) {
                    arrayList.get(i).setShuiZhui(Integer.valueOf(map.get("value").toString()));
                    count.setShuiZhui(count.getShuiZhui()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "接收机".equals(map.get("type"))) {
                    arrayList.get(i).setJie(Integer.valueOf(map.get("value").toString()));
                    count.setJie(count.getJie()+Integer.valueOf(map.get("value").toString()));
                }
                if (name[i].equals(map.get("level")) && "全站仪".equals(map.get("type"))) {
                    arrayList.get(i).setQuan(Integer.valueOf(map.get("value").toString()));
                    count.setQuan(count.getQuan()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "测速仪".equals(map.get("type"))) {
                    arrayList.get(i).setShu(Integer.valueOf(map.get("value").toString()));
                    count.setShu(count.getShu()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "水位仪".equals(map.get("type"))) {
                    arrayList.get(i).setShuiWei(Integer.valueOf(map.get("value").toString()));
                    count.setShuiWei(count.getShuiWei()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "声速仪".equals(map.get("type"))) {
                    arrayList.get(i).setSheng(Integer.valueOf(map.get("value").toString()));
                    count.setSheng(count.getSheng()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "地下管线探测仪".equals(map.get("type"))) {
                    arrayList.get(i).setDixia(Integer.valueOf(map.get("value").toString()));
                    count.setDixia(count.getDixia()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && "无人飞行器".equals(map.get("type"))) {
                    arrayList.get(i).setWuren(Integer.valueOf(map.get("value").toString()));
                    count.setWuren(count.getWuren()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && map.get("type")!=null && (map.get("type")+"").contains("GPS")) {
                    arrayList.get(i).setGPS(arrayList.get(i).getGPS()+Integer.valueOf(map.get("value").toString()));
                    count.setGPS(count.getGPS()+Integer.valueOf(map.get("value").toString()));

                }
                if (name[i].equals(map.get("level")) && map.get("type")!=null && (map.get("type")+"").contains("RTK")) {
                    arrayList.get(i).setRtk(arrayList.get(i).getRtk()+Integer.valueOf(map.get("value").toString()));
                    count.setRtk(count.getRtk()+Integer.valueOf(map.get("value").toString()));

                }
                    if (name[i].equals(map.get("level")) && map.get("levelvalue")!=null) {
                        arrayList.get(i).setCount(Integer.valueOf(map.get("levelvalue").toString()));
                        count.setCount(count.getCount()+Integer.valueOf(map.get("levelvalue").toString()));

                    }
            }

        }
        return arrayList;
    }


    public static void main(String[] args) {
         String s="GSP接收街";
         String b="GSP";
        System.out.println(s.contains(b));

    }
}
