package org.example.test.utils.demo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.example.test.cases.login.LoginPage_001_LoginSuccessFunction_Test;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {

    @Test
    public void excelDataUtil(){
        try {
            String path = "data/data.xls";
            InputStream inputStream = new FileInputStream(path);
            Workbook book = Workbook.getWorkbook(inputStream);
            Sheet sheet = book.getSheet("register");   //如sheet：login
            int rowNum = sheet.getRows();                  //获取行数量，除去表头用例数量为 rows-1
            Cell[] cells = sheet.getColumn(0);       // 获取第一列的所有数据
            // 获取用例id作为key
            List<String> caseKey = new ArrayList<String>();
            for (int i = 1; i < rowNum; i++) {
                caseKey.add(cells[i].getContents().toString());
            }
            // 获取excel表头作为每行数据的key
            List<String> dataKey = new ArrayList<String>();
            Cell[] rows = sheet.getRow(0);         //获取第一行所有数据
            int columns = sheet.getColumns();        //获取所有列
            for (int j = 1; j < columns-1; j++) {
                dataKey.add(rows[j].getContents().toString());
            }
            // 表头数据与值建立对应关系封装成Map
            Map<String, Object> cases = new HashMap<String, Object>();
            Map<String, String> data = null;
            for (int r = 1; r < rowNum; r++) {
                data = new HashMap<String, String>();
                // 获取当前行
                Cell[] row = sheet.getRow(r);
                String value = "";
                for (int c = 1; c < row.length-1; c++) {
                    value = row[c].getContents().toString();
                    data.put(dataKey.get(c-1), value);   // list中从0开始计算需要-1
                }
                cases.put(caseKey.get(r-1),data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel封装Map
     */
    public void readExcel2Map(){
        String path = "C:\\Users\\WangChao\\Desktop\\20200701\\清单.xls";
        try {
            InputStream inputStream = new FileInputStream(path);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            List<String> key = new ArrayList<>();
            Cell[] row = sheet.getRow(0);
            for (int i = 0; i < row.length; i++) {
                key.add(row[i].getContents().toString());
            }
            int columns = sheet.getColumns();
            List<Object> datas = new ArrayList<>();
            Map<String, String> data;
            for (int i = 1; i < columns; i++) {
                data = new HashMap<String, String>();
                String value = "";
                Cell[] column = sheet.getRow(i);
                for (int j = 0; j < column.length; j++) {
                     value = column[j].getContents().toString();
                     data.put(key.get(j),value);
                }
                datas.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readAllData(){
        String path = "C:\\Users\\WangChao\\Desktop\\20200701\\清单.xls";
        try {
            InputStream inputStream = new FileInputStream(path);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            // 明细数据
            for (int j=0; j < rows-1; j++){
                Cell[] row = sheet.getRow(j);
                for (int i = 0; i < row.length; i++) {
                    String s = row[i].getContents().toString();
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readTest(){
        String path = "C:\\Users\\WangChao\\Desktop\\20200701\\清单.xls";
        try {
            InputStream inputStream = new FileInputStream(path);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();         // 获取总行数
            Cell[] cells = sheet.getRow(0);  // 获取第一行数据
            int length = cells.length;          // 第一行数据的值的个数
            String[] name = new String[cells.length];
            for (int i = 0; i < cells.length; i++) {
                name[i] = cells[i].getContents().toString();
            }
            for(String n: name){
                System.out.println(n.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun01(){
        String className = LoginPage_001_LoginSuccessFunction_Test.class.getName();
        System.out.println(className);
        int dotIndexNum = className.indexOf(".");
        int underlineIndexNum = className.indexOf("_");
        if (dotIndexNum > 0){
            String moduleName = className.substring(23, className.lastIndexOf("."));
            System.out.println(moduleName);
        }
        if (underlineIndexNum > 0){
            String substring = className.substring(underlineIndexNum + 1, underlineIndexNum + 4);
            System.out.println(substring);
        }
    }
}
