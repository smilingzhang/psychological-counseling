/**
 * 
 */
package com.psychologicalcounseling.background.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.psychologicalcounseling.background.service.TimeSeqScheduledTaskService;
import com.psychologicalcounseling.entity.ListenRecord;

/**
 *@desc:后台中关于时间序列数据可视化的定时任务
 *@author 邓旸
 *@date:2019年6月6日上午9:10:55
 */

@Controller
public class TimeSeqScheduledTaskController {
	@Resource
	private TimeSeqScheduledTaskService timeSeqScheduledTaskService;
	
	/**
	 * 
	 *@desc:调用py整合数据
	 *	<li>更新频率：每天</li>
	 *	<li>更新时间：凌晨2点</li>
	 *@return:void
	 * @throws Exception 
	 * @trhows
	 */
	@Scheduled(cron = "0 0/3 * * * ? ")
    public void updateData() throws Exception {
		//从数据库读取当天倾听数据
		//条件：当天，已倾听
		ArrayList<ListenRecord> list = (ArrayList<ListenRecord>) timeSeqScheduledTaskService.getTodayListenRecord();
		
		//写入日志文件：开始时间，结束时间，1
		String rootPath = this.getClass().getClassLoader().getResource("/").getPath();
		String filePath = rootPath+"resource/log/";
		String logFileName = "listenning_record.csv";
		File file = new File(logFileName);
		if(!file.exists())file.createNewFile();
		OutputStream os = new FileOutputStream(new File(filePath + logFileName));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
		for(ListenRecord lr : list) {
			StringBuilder buffer = new StringBuilder();
			buffer.append(lr.getListenrecordStartTime());
			buffer.append(",");
			buffer.append(lr.getListenrecordEndTime());
			buffer.append(",");
			buffer.append("1");
			buffer.append("\n");
			System.out.println(buffer.toString());
			writer.write(buffer.toString());
		}
		writer.close();os.close();
		//调用py处理日志，将日志追加到数据集末尾
		//生成路径
		String pyName = "log_processer.py";
		String pyPath = filePath + pyName;
		//执行脚本文件
		Process proc = null;
        try {
            proc = Runtime.getRuntime().exec("H:\\Anaconda3\\envs\\py36\\python.exe " + pyPath.substring(1));
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("updateData");
    }
	
	/**
	 * 
	 *@desc:调用py的代码更新模型
	 *	<li>更新频率：每天</li>
	 *	<li>更新时间：凌晨3点</li>
	 *@return:void
	 *@trhows
	 */
//	@Scheduled(cron = "0 5/20 * * * ? ")
    public void upgradeModule() {
		//生成路径
		String rootPath = this.getClass().getClassLoader().getResource("/").getPath();
		String filePath = rootPath+"resource/pyfile/time_sequence/";
		String pyName = "module_exercising.py";
		String pyPath = filePath + pyName;
		//执行脚本文件
		Process proc = null;
        try {
            proc = Runtime.getRuntime().exec("H:\\Anaconda3\\envs\\py36\\python.exe " + pyPath.substring(1));
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("updateModule");
    }
}
