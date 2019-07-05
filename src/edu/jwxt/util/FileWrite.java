package edu.jwxt.util;

import java.io.File;
import java.util.List;



import edu.jwxt.bean.StudentGrade;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.Number;

public class FileWrite {

	public static void filewrite(List<StudentGrade> list) {
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("E:\\eclipse-workspace\\jwxt\\download\\grade.xls"));
			WritableSheet sheet = book.createSheet("sheet1", 0);
			
			Label label1 = new Label(0, 0, "序号");
			sheet.addCell(label1);
			
			Label label2 = new Label(1,0,"课程名称");
			sheet.addCell(label2);
			
			Label label3 = new Label(2,0,"课程成绩");
			sheet.addCell(label3);
			
			Label label4 = new Label(3,0,"课程学分");
			sheet.addCell(label4);
			
			Label label5 = new Label(4,0,"获得学分");
			sheet.addCell(label5);
			
			Label label6 = new Label(5,0,"获得绩点");
			sheet.addCell(label6);
			
			for (int i = 0; i < list.size(); i++) {
				Number number1 = new Number(0, i+1, i+1);
				sheet.addCell(number1);
				Label label = new Label(1, i+1, list.get(i).getName());
				sheet.addCell(label);
				Number number2 = new Number(2, i+1, list.get(i).getGrade());
				sheet.addCell(number2);
				Number number3 = new Number(3, i+1, list.get(i).getXuefen());
				sheet.addCell(number3);
				Number number4 = new Number(4, i+1, list.get(i).getGetxuefen());
				sheet.addCell(number4);
				Number number5 = new Number(5, i+1, list.get(i).getJidian());
				sheet.addCell(number5);
			}
			double grade=0,xuefen=0,getxuefen=0,jidian=0;
			int i=0;
			for(StudentGrade s:list) {
				grade+=s.getGrade();
				xuefen+=s.getXuefen();
				getxuefen+=s.getGetxuefen();
				jidian+=s.getJidian();
				i++;
			}
			Label label7 = new Label(0,i+1,"总计/平均");
			sheet.addCell(label7);
			Label label8 = new Label(2,i+1,grade+"/"+(grade/i));
			sheet.addCell(label8);
			Label label9 = new Label(3,i+1,xuefen+"/"+(xuefen/i));
			sheet.addCell(label9);
			Label label10 = new Label(4,i+1,getxuefen+"/"+(getxuefen/i));
			sheet.addCell(label10);
			Label label11 = new Label(5,i+1,jidian+"/"+(jidian/i));
			sheet.addCell(label11);
			book.write();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void CourseWrite(List<StudentGrade> list) {
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("E:\\eclipse-workspace\\jwxt\\download\\course.xls"));
			WritableSheet sheet = book.createSheet("sheet1", 0);
			
			Label label1 = new Label(0, 0, "序号");
			sheet.addCell(label1);
			
			Label label2 = new Label(1,0,"课程名称");
			sheet.addCell(label2);
			
			Label label3 = new Label(2,0,"课程学分");
			sheet.addCell(label3);
			
			Label label4 = new Label(3,0,"任课教师");
			sheet.addCell(label4);
			
			Label label5 = new Label(4,0,"上课时间");
			sheet.addCell(label5);
			
			Label label6 = new Label(5,0,"上课地点");
			sheet.addCell(label6);
			
			for (int i = 0; i < list.size(); i++) {
				Number number1 = new Number(0, i+1, i+1);
				sheet.addCell(number1);
				Label label = new Label(1, i+1, list.get(i).getName());
				sheet.addCell(label);
				Number number2 = new Number(2, i+1, list.get(i).getXuefen());
				sheet.addCell(number2);
				Label label31 = new Label(3, i+1, list.get(i).getTeacher());
				sheet.addCell(label31);
				Label number4 = new Label(4, i+1, list.get(i).getTime());
				sheet.addCell(number4);
				Label number5 = new Label(5, i+1, list.get(i).getClassroom());
				sheet.addCell(number5);
			}
			book.write();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
