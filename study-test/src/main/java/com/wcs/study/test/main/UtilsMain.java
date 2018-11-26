package com.wcs.study.test.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.wcs.study.test.utils.CameToolUtil;

/**
 * utils包的mainlei
 *
 * @author pro
 */
public class UtilsMain {

    public static void cameToolUtilTest() {
        InputStream stream = UtilsMain.class.getClassLoader().getResourceAsStream("json/cameTool.json");

        String data = null;
        try {
            data = IOUtils.toString(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(CameToolUtil.convert(data));
    }

    public static void main(String[] args) {
        cameToolUtilTest();
    }
}
