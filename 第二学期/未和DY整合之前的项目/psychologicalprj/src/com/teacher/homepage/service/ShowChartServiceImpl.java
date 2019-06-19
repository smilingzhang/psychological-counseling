package com.teacher.homepage.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ConsultationRecord;
import com.entity.TypeTable;
import com.entity.User;
import com.teacher.homepage.dao.ShowChartDaoImpl;

@Service
public class ShowChartServiceImpl {
	@Resource
	private ShowChartDaoImpl showchartdao;
	
//-----------孙明伟----------------
    
    /**
     *    统计时间
     * @throws ParseException 
     * */
    public long getTime(Date d,int teacherid) throws ParseException {
    	List<ConsultationRecord> list = this.showchartdao.selectConsultationRecord(d, teacherid);
    	long totaltime = 0;
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	for(ConsultationRecord temp:list) {
    		long timelong =(sdf.parse(temp.getConsultationrecordEndTime()).getTime() -sdf.parse(temp.getConsultationrecordStartTime()).getTime())/(60*60*1000);
    		totaltime = totaltime + timelong;
    	}
    	int time = new Long(totaltime).intValue();
    	System.out.println(time);
    	return totaltime;
    }
    
    /**
     * 统计咨询数量
     * */
    public int getUserNum(Date d,int teacherid) {
    	List<ConsultationRecord> list = this.showchartdao.getUsercount(d, teacherid);
    	int num = list.size();
    	return num;
    }
    
    
    /**
     * 统计各种类型的数量	
     * */
    public List<Map<Object,Object>> gettypeNum(Date d,int teacherid){
    	List<ConsultationRecord> list = this.showchartdao.selectConsultationRecord(d, teacherid);
    	List<TypeTable> list1 = this.showchartdao.selectTypeTable();
    	int num = list1.size();
    	int num1 = 0;
    	int listnum[] = new int[num];
    	System.out.println("list1.size()"+list1.size());
    	for(ConsultationRecord temp:list) {
    		User u = temp.getUser();
    		int userid = u.getUserId();
//    		System.out.println("咨询的用户类型有："+ temp.getUser().getUserLabels().toString());
    		List<String> list2 = this.showchartdao.selectuserLabel(userid);
    		for(int i = 0;i<list2.size();i++) {
//    			System.out.println(list2.get(i)+"----");
    			String str = list2.get(i);
    			for (int j = 0;j<list1.size();j++) {
//    				System.out.println(list1.get(j).getTypetableName());
    				String str1 = list1.get(j).getTypetableName();
    			
    				if(str.equals(str1)) {
//    					System.out.println("--------");
    					listnum[j]++;
    					num1++;
//    					System.out.println(listnum[j]);
    				}
    			}
    		}
    	}
    	List<Map<Object,Object>> list3 = new ArrayList<Map<Object,Object>>();
    	if(num1==0) {
    		Map<Object,Object> map = new HashMap<Object,Object>();
    		map.put("y", "100");
    		map.put("label","无记录" );
    		list3.add(map);
    	}else {
	    	for(int q = 0;q<listnum.length;q++) {
	    		Map<Object,Object> map = new HashMap<Object,Object>();
	    		DecimalFormat df=new DecimalFormat("0.00");
	    		System.out.println(listnum[q]);
	    		System.out.println(num1);
	    		String y =df.format((float)listnum[q]/num1*100);
	    		System.out.println(y);
	//    		int Y = Integer.parseInt(y);
	    		map.put("y", y);
	    		map.put("label",list1.get(q).getTypetableName());
	    		list3.add(map);
	    	}	
    	}
    	return list3;
    }
}
