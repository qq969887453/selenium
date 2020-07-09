package org.example.test.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 读取excel提供的数据
 */
public class ExcelDataProvider implements Iterator<Object[]> {
    private Workbook book = null;
    private Sheet sheet = null;
    private int rowNum = 0;
    private int currentRowNo=0;
    private int columnNum = 0;
    private String[] columnName;
    private String path = null;
    private InputStream inputStream = null;
    public static Logger logger = Logger.getLogger(ExcelDataProvider.class.getName());

    /**
     * @param moduleName 模块名称
     * @param caseNum 测试用例编号
     */
    public ExcelDataProvider(String moduleName, String caseNum){
        try {
            path = "data/"+moduleName+".xls";
            inputStream = new FileInputStream(path);
            book = Workbook.getWorkbook(inputStream);
            sheet = book.getSheet(caseNum); //读取第一个sheet
            rowNum = sheet.getRows();       //获取当前sheet的所有行
            Cell[] cells = sheet.getRow(0);  //获取表头
            columnNum = cells.length;       // 单元格的个数 值 赋给 列数
            columnName = new String[cells.length];
            for (int i=0; i< cells.length; i++){
                columnName[i] = cells[i].getContents().toString();
            }
            this.currentRowNo++;
        } catch (FileNotFoundException e) {
            logger.error("没有找到指定的文件：" + "[" + path + "]");
            Assert.fail("没有找到指定的文件：" + "[" + path + "]");
        } catch (Exception e) {
            logger.error("不能读取文件： [" + path + "]",e);
            Assert.fail("不能读取文件： [" + path + "]");
        }
    }

    /**
     * @return 判断是否还有下一个内容
     *         1、当行为空或者当前行数大于总行数（数据已经读完）不再读取；
     *         2、
     */
    @Override
    public boolean hasNext() {
        if (this.rowNum ==0 || this.currentRowNo >= this.rowNum){
            try {
                inputStream.close();
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }else {
            if ((sheet.getRow(currentRowNo))[0].getContents().equals("")){
                return false;
            }
        }
        return true;
    }

    /**
     * @return 返回的内容
     */
    @Override
    public Object[] next() {
        Cell[] c = sheet.getRow(this.currentRowNo);
        Map<String, String> data = new HashMap<String, String>();
        for (int i=0; i<this.columnNum; i++){
            String temp = "";
            try {
                temp = c[i].getContents().toString();
            } catch (ArrayIndexOutOfBoundsException e) {
                temp = "";
            }
            data.put(this.columnName[i], temp);
        }
        Object object[] = new Object[1];
        object[0] = data;
        this.currentRowNo++;
        return object;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove unsupported");
    }
}
