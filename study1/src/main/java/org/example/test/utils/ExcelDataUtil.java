package org.example.test.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class ExcelDataUtil{

    private Workbook book = null;
    private Sheet sheet = null;
    private int rowNum = 0;        // 行数量
    private int columnNum = 0;     // 所有列
    private String path = null;
    private InputStream inputStream = null;
    public static Logger logger = Logger.getLogger(ExcelDataUtil.class.getName());

    /**
     * @param moduleName 为excel的sheet页,与模块名相同
     * @param caseId sheet中的编号，对应excel的编号
     *           理想数据结构：
     *           {
     *           1:{username:jojo;password:bean};
     *           2:{username:zhangsan;password:123456}
     *           }
     *           Map<String,Map<String,String>>
     */
    public Object[] getCaseData(String moduleName, int caseId){
        try {
            path = "data/data.xls";
            Object[] caseData = new Object[2];
            inputStream = new FileInputStream(path);
            book = Workbook.getWorkbook(inputStream);
            sheet = book.getSheet(moduleName);   //如sheet：login
            rowNum = sheet.getRows();                  //获取行数量，除去表头用例数量为 rows-1
            Cell[] cells = sheet.getColumn(0);       // 获取第一列的所有数据
            List<String> caseKey = new ArrayList<String>();
            for (int i = 1; i < rowNum; i++) {
                caseKey.add(cells[i].getContents().toString());
            }
            //获取excel表头作为每行数据的key
            List<String> dataKey = new ArrayList<String>();
            Cell[] rows = sheet.getRow(0);           //获取第一行所有数据
            columnNum = sheet.getColumns();             //获取所有列
            for (int j = 1; j < columnNum-1; j++) {
                dataKey.add(rows[j].getContents().toString());
            }
            Map<Object, Map<String, String>> cases = new HashMap<Object, Map<String, String>>();
            Map<String, String> data = new HashMap<String, String>();
            Cell[] row = sheet.getRow(caseId);
            String value = "";
            for (int c = 1; c < row.length-1; c++) {
                value = row[c].getContents().toString();
                data.put(dataKey.get(c-1), value);
            }
            cases.put(caseId, data);
            caseData[0] = cases;
            caseData[1] = caseId;
            return caseData;
            /*Map<String, String> data = null;
            for (int r = 1; r < rowNum; r++) {
                data = new HashMap<String, String>();
                Cell[] row = sheet.getRow(r);
                String value = "";
                for (int c = 1; c < row.length-1; c++) {
                    value = row[c].getContents().toString();
                    data.put(dataKey.get(c-1), value);
                }
                cases.put(caseKey.get(r-1), data);
            }*/
        } catch (FileNotFoundException e) {
            logger.error("没有找到指定的文件：" + "[" + path + "]");
            Assert.fail("没有找到指定的文件：" + "[" + path + "]");
        } catch (Exception e){
            logger.error("不能读取文件： [" + path + "]",e);
            Assert.fail("不能读取文件： [" + path + "]");
        }
        return null;
    }
}
