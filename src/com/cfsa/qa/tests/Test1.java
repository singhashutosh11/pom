package com.cfsa.qa.tests;

import com.cfsa.qa.utils.TestUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.testng.annotations.Test;

import com.cfsa.qa.utils.Log;


public class Test1 extends TestFrameWork {


    @Test
    public void testcase1() {
        Log.InfoLog("Test Case started");
        new Login().toCFSA();
        System.out.println("1st test case");

    }

    @Test(dataProvider = "parameter", dataProviderClass = TestUtil.class)
    public void testcase2(String x, Integer y) {
        System.out.println("2nd test case");
        System.out.println(x);
        System.out.println(y);
    }


    @Test(groups = {"grp1", "grp2"})

    public void testCase3() {

        System.out.println("3rd test case");
    }

    @Test(groups = "grp1")

    public void testCase4() {

        System.out.println("4th test case");
    }

}