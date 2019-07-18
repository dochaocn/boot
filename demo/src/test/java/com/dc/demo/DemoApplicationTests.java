//package com.dc.demo;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.beans.PropertyDescriptor;
//import java.io.*;
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.*;
//
//import static org.springframework.beans.BeanUtils.getPropertyDescriptors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DemoApplicationTests {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    ApplicationContext ioc;
//
//    @Autowired
//    DataSource dataSource;
//
//    @Test
//    public void BigDecimal() {
//        BigDecimal a = BigDecimal.ZERO;
//        add(a);
//        System.out.println("test方法:" + a.toString());
//        Object personController = ioc.getBean("personController");
//        logger.info(personController.toString());
//    }
//
//    private void add(BigDecimal a) {
//        a = a.add(new BigDecimal(1));
//        System.out.println("add方法:" + a.toString());
//    }
//
//    @Test
//    public void BigDecimal1() {
//        BigDecimal a = BigDecimal.ZERO;
//        Map<String,BigDecimal> map = new HashMap<>();
//        map.put("a",a);
//        add(a,map);
//        System.out.println("test方法:" + map.get("a").toString());
//    }
//
//    private void add(BigDecimal a, Map<String,BigDecimal> map) {
//        a = a.add(new BigDecimal(1));
//        map.put("a",a);
//        System.out.println("add方法:" + a.toString());
//    }
//
//    @Test
//    public void face(){
//        int a = 4;
//        int b = 5;
//        method(a,b);
//        System.out.println("a=:" + a + "  b=" + b);
//    }
//
//    private void method(int a, int b) {
//        System.out.println("a=:" + a * 100 + "  b=" + b * 100);
//        System.exit(0);
//    }
//
//
//    /**
//     * 导出数据
//     *
//     */
//
//
//    private String json = "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"1\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"27.45\",\"REPAY_BASE_AMT\":\"27.45\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"Y\",\"PAY_OFF_DATE\":\"2018-09-06 00:00:00\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"7.40\",\"INTEREST_CALCULATION\":\"7.40\",\"ACCRUAL_CALCULATION\":\"11472.8682\",\"ACCRUAL_BEGIN_DATE\":\"20180806\",\"ACCRUAL_CURRENT_DATE\":\"20180906\",\"LEFT_PLAN_BASE_AMT\":\"370.00\",\"LATE_REPAY_DATE\":\"20180906\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"7.40\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-09-07 00:11:31\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"2\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"28.22\",\"REPAY_BASE_AMT\":\"28.22\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"6.63\",\"INTEREST_CALCULATION\":\"6.63\",\"ACCRUAL_CALCULATION\":\"10279.0698\",\"ACCRUAL_BEGIN_DATE\":\"20180906\",\"ACCRUAL_CURRENT_DATE\":\"20190111\",\"LEFT_PLAN_BASE_AMT\":\"342.55\",\"LATE_REPAY_DATE\":\"20181006\",\"LOAN_DUE_DAYS\":\"97\",\"INTEREST_DUE_DAYS\":\"97\",\"LOAN_STATUS\":\"03\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"6.63\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"20190104\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"03\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2019-01-11 01:03:33\"}," +
//            "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"3\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"28.56\",\"REPAY_BASE_AMT\":\"28.56\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"Y\",\"PAY_OFF_DATE\":\"2018-11-07 00:00:00\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"6.29\",\"INTEREST_CALCULATION\":\"6.29\",\"ACCRUAL_CALCULATION\":\"9744.2300\",\"ACCRUAL_BEGIN_DATE\":\"20181006\",\"ACCRUAL_CURRENT_DATE\":\"20181106\",\"LEFT_PLAN_BASE_AMT\":\"314.33\",\"LATE_REPAY_DATE\":\"20181106\",\"LOAN_DUE_DAYS\":\"1\",\"INTEREST_DUE_DAYS\":\"1\",\"LOAN_STATUS\":\"02\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"6.29\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"20181106\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"02\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-11-08 00:09:49\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"4\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"29.32\",\"REPAY_BASE_AMT\":\"29.32\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"Y\",\"PAY_OFF_DATE\":\"2018-12-06 00:00:00\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"5.53\",\"INTEREST_CALCULATION\":\"5.53\",\"ACCRUAL_CALCULATION\":\"8573.1000\",\"ACCRUAL_BEGIN_DATE\":\"20181106\",\"ACCRUAL_CURRENT_DATE\":\"20181206\",\"LEFT_PLAN_BASE_AMT\":\"285.77\",\"LATE_REPAY_DATE\":\"20181206\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"5.53\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-12-07 00:09:15\"}," +
//            "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"5\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"29.72\",\"REPAY_BASE_AMT\":\"29.72\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"Y\",\"PAY_OFF_DATE\":\"2019-01-07 00:00:00\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"5.13\",\"INTEREST_CALCULATION\":\"5.13\",\"ACCRUAL_CALCULATION\":\"7949.9500\",\"ACCRUAL_BEGIN_DATE\":\"20181206\",\"ACCRUAL_CURRENT_DATE\":\"20190106\",\"LEFT_PLAN_BASE_AMT\":\"256.45\",\"LATE_REPAY_DATE\":\"20190106\",\"LOAN_DUE_DAYS\":\"1\",\"INTEREST_DUE_DAYS\":\"1\",\"LOAN_STATUS\":\"02\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"5.13\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"20190106\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"02\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2019-01-08 00:08:48\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"6\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"30.32\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"4.53\",\"INTEREST_CALCULATION\":\"0.73\",\"ACCRUAL_CALCULATION\":\"1133.6500\",\"ACCRUAL_BEGIN_DATE\":\"20190106\",\"ACCRUAL_CURRENT_DATE\":\"20190111\",\"LEFT_PLAN_BASE_AMT\":\"226.73\",\"LATE_REPAY_DATE\":\"20190206\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2019-01-11 00:27:55\"}," +
//            "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"7\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"31.30\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"3.55\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190206\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"196.41\",\"LATE_REPAY_DATE\":\"20190306\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"8\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"31.55\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"3.30\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190306\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"165.11\",\"LATE_REPAY_DATE\":\"20190406\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"}," +
//            "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"9\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"32.27\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"2.58\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190406\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"133.56\",\"LATE_REPAY_DATE\":\"20190506\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"10\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"32.82\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"2.03\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190506\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"101.29\",\"LATE_REPAY_DATE\":\"20190606\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"}," +
//            "{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"11\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"33.53\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"1.32\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190606\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"68.47\",\"LATE_REPAY_DATE\":\"20190706\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"},{\"ORDER_NO\":\"C021808060021388023\",\"INSTALL_CNT\":\"12\",\"CAPITAL_SOURCE\":\"0000000000\",\"CUST_NO\":\"150006910957\",\"PROD_SUB_NO\":\"900001\",\"TRANS_AMT\":\"34.94\",\"REPAY_BASE_AMT\":\"0.00\",\"REPAY_TYPE\":\"03\",\"INSTALL_RATE\":\"0.2322000000\",\"PAY_OFF_FLAG\":\"N\",\"PAY_OFF_DATE\":\"\",\"OVERDUE_INTEREST_RATE\":\"0.0009680000\",\"INSTAL_INTEREST\":\"0.70\",\"INTEREST_CALCULATION\":\"0.00\",\"ACCRUAL_CALCULATION\":\"0.0000\",\"ACCRUAL_BEGIN_DATE\":\"20190706\",\"ACCRUAL_CURRENT_DATE\":\"0\",\"LEFT_PLAN_BASE_AMT\":\"34.94\",\"LATE_REPAY_DATE\":\"20190806\",\"LOAN_DUE_DAYS\":\"0\",\"INTEREST_DUE_DAYS\":\"0\",\"LOAN_STATUS\":\"01\",\"OVERDUE_INTEREST\":\"0.00\",\"DUE_INTEREST_CALCULATION\":\"0.0000\",\"REPAYMENT_INTEREST\":\"0.00\",\"REPAY_OVERDUE_INTEREST\":\"0.00\",\"FEE\":\"0.00\",\"REPAY_FEE\":\"0.00\",\"DUE_FEE\":\"0.00\",\"REPAY_DUE_FEE\":\"0.00\",\"SERVICE_CHARGE_FEE\":\"0.00\",\"REPAY_SERVICE_CHARGE_FEE\":\"0.00\",\"LAST_TRANS_DATE\":\"0\",\"TRANS_CHANNEL_CODE\":\"0000000000\",\"FEE_CNT\":\"0\",\"FEE_COUPON_AMT\":\"0.00\",\"FEE_COUPON_DAYS\":\"\",\"FEE_COUPON_RATE\":\"\",\"LOAN_STATUS_MDF_DATE\":\"0\",\"MANUL_PROCESS_CODE\":\"\",\"MANUL_PROCESS_DATE\":\"0\",\"TABLE_STATUS\":\"01\",\"INTABLE_INTEREST\":\"0.00\",\"INTABLE_DUE_INTEREST\":\"0.00\",\"DAYS_OF_GRACE\":\"3\",\"CREATE_DATETIME\":\"2018-08-06 01:52:09\",\"UPDATE_DATETIME\":\"2018-08-06 01:52:09\"}\n";
//
//
////    @Autowired
////    LoanPlanDao loanPlanDao;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    public void jsonToObjectAndInsert() throws Exception {
//        System.out.println(jdbcTemplate);
//        Class<?> aClass = LoanPlan.class;
//        List<Object> object = new ArrayList<>();
//        String[] jsonArray = json.split("},");
//        for (int i = 0; i < jsonArray.length; i++){
//            if (i != jsonArray.length -1)
//                json = jsonArray[i] + "}";
//            this.getObject(aClass,json,object);
//        }
//        logger.debug(object.toString());
//
//    }
//
//    private void getObject(Class<?> c, String json,List<Object> object) throws Exception {
////        Map<String, Object> map = JSONUtil.jsonToMap(json,false);
////        object.add(this.instanceObj(c, map));
//    }
//
//    private Object instanceObj(Class<?> c, Map<String,Object> map) throws Exception {
//        Object o = c.getConstructor().newInstance();
//        PropertyDescriptor[] targetPds = getPropertyDescriptors(c);
//        for (PropertyDescriptor targetPd : targetPds) {
//            String fieldName = targetPd.getName();
//            if (fieldName.equals("class"))
//                continue;
//            StringBuilder col = new StringBuilder();
//            for (int i = 0; i < fieldName.length(); i++){
//                char charAt = fieldName.charAt(i);
//                if (charAt >= 65 && charAt <= 90)
//                    col.append("_");
//                col.append(String.valueOf(charAt).toUpperCase());
//            }
//            Object value = map.get(col.toString());
//            if (value == null || value.toString().equals(""))
//                continue;
//            if(targetPd.getPropertyType().isAssignableFrom(BigDecimal.class))
//                value = new BigDecimal(map.get(col.toString()).toString());
//            if(targetPd.getPropertyType().isAssignableFrom(Integer.class))
//                value = Integer.parseInt((String) map.get(col.toString()));
////            if(targetPd.getPropertyType().isAssignableFrom(Date.class))
////                value = DateUtil.parseDate((String) map.get(col.toString()),DateUtil.YYYY_MM_DD$hh$mm$ss_FORMAT);
//            Method writeMethod = targetPd.getWriteMethod();
//            writeMethod.invoke(o,value);
//        }
//        return o;
//    }
//
//
//
//    @Test
//    public void testInsertSql() throws Exception {
//        List<String> sqlList = new ArrayList<>();
//        List<String> sqlList1 = new ArrayList<>();
//        long start = System.currentTimeMillis();
//        this.readTxt(sqlList);
//        for (int i = 0;i < 1; i++){
//            sqlList1.addAll(sqlList);
//        }
//        this.writeSql(sqlList1);
////        for (String sql : sqlList) {
////            jdbcTemplate.execute(sql);
////        }
//        System.out.println("总计耗时" + (System.currentTimeMillis() - start));
//    }
//
//    private void readTxt(List<String> sqlList) throws Exception {
//        String readFileName = "d://web-json/loan_by.txt";
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
//        while (true){
//            String line = bufferedReader.readLine();
//            if (line == null || "".equals(line))
//                break;
//            String[] tableNameAndJson = line.split("\\|");
//            this.jsonToSql(tableNameAndJson[0],tableNameAndJson[1],sqlList);
//        }
//        bufferedReader.close();
//    }
//    private void jsonToSql(String tableName,String json,List<String> sqlList) throws Exception {
//        String[] jsonArray = json.split("},");
//        for (int i = 0; i < jsonArray.length; i++){
//            String oneJson = i==jsonArray.length-1?jsonArray[i]:jsonArray[i]+"}";
//            this.jsonToMap(oneJson,sqlList,tableName);
//        }
//    }
//    private void jsonToMap(String json,List<String> sqlList,String tableName) throws Exception {
////        Map<String, Object> map = JacksonUtil.jsonToMap(json,false);
////        this.getSql(map,tableName,sqlList);
//    }
//    private void getSql(Map<String, Object> map,String tableName,List<String> sqlList) {
//        StringBuilder sql = new StringBuilder("insert into `acs`.`");
//        StringBuilder insert = new StringBuilder();
//        StringBuilder value = new StringBuilder();
//        List<String> list = new ArrayList<>(map.keySet());
//        for (int i = 0; i < list.size(); i++) {
//            insert.append("`").append(list.get(i)).append(i==list.size()-1?"`":"`,");
//            value.append("'").append(map.get(list.get(i))).append(i==list.size()-1?"'":"',");
//        }
//        sql.append(tableName).append("` ( ").append(insert).append(") VALUES ( ").append(value).append(");");
//        sqlList.add(sql.toString());
//    }
//    private void writeSql(List<String> sqlList) throws Exception {
//        File file = new File("d://web-sql/" +11233 + ".sql");
//        FileOutputStream stream = new FileOutputStream(file,true);
//        BufferedOutputStream buff = new BufferedOutputStream(stream);
//        BufferedWriter bufff = new BufferedWriter(new FileWriter(file));
//        long start = System.currentTimeMillis();
//        byte[] next = "\n".getBytes();
//        for (String sql : sqlList) {
//            buff.write(sql.getBytes());
//            buff.write(next);
////            writer.write(sql);
////            bufff.write(sql);
//        }
//        System.out.println("写文件耗时" + (System.currentTimeMillis() - start));
//        buff.close();
////        writer.close();
//    }
//
//    @Test
//    public void readTxtTest() throws Exception {
//        InputStream input = new FileInputStream(new File("d://1qaz/buff0.txt"));
//        OutputStream output = new FileOutputStream(new File("d://1qaz/buff1.txt"));
//
//        input.close();
//        output.close();
//    }
//
//
//
//    private void execute(String sql)  {
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/acs";
//            connection = DriverManager.getConnection(url, "root", "");
//            statement = connection.createStatement();
//            statement.execute(sql);
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                assert connection != null;
//                connection.close();
//                assert statement != null;
//                statement.close();
//            } catch (SQLException e) {
//                System.out.println("=====================");
//            }
//        }
//    }
//
//    @Test
//    public void testIf(){
//        if (1 == 2);
//        {System.out.println("111");}
//    }
//}
//
