package com.ljw;


import com.ljw.utils.ExecCmdResult;
import com.ljw.utils.SSH2Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.ethz.ssh2.Connection;


public class TestSSH2Util {
	  
    private static  int port = 22;
	  
	private String host = "49.232.29.45";

    private String username = "root";

    private String password = "zhaoyuyy";

    private Connection connection;

    // 执行每个单元测试用例前, 创建ssh2连接
    @Before
    public void setup(){
        connection = SSH2Util.openConnection(host, username, password);
    }

    // 执行每个单元测试后, 关闭连接
    @After
    public void tearDown(){
        connection.close();
    }

    /** 测试连接 */
    @Test
    public void test_connect(){
        System.out.println("hostname:" + connection.getHostname());
    }


    /** 测试执行正确命令 */
    @Test
    public void test_exec_right() {
        //ExecCmdResult execCmdResult = SSH2Util.execCommand(connection, "ls /home -l");
    	//ExecCmdResult result3 = SSH2Util.execCommand(openConnection, "mv "+oracle_exp_path+File.separatorChar+"* "+bak_oracle_path+File.separatorChar+DateUtils.dateToStringShort(d2).replace("-", ""));
        ExecCmdResult execCmdResult = SSH2Util.execCommand(connection, "sh /home/oracle/test/sh_data/expT1F_LAB_PROJECT.sh");
//        ExecCmdResult execCmdResult = SSH2Util.execCommand(connection, "sqlplus");
        System.out.println("命令是否正确执行:" + execCmdResult.isSuccess());
        System.out.println("命令执行结果:\n" + execCmdResult.getResult());
    }

    /** 测试执行带命令通配符的命令 */
    @Test
    public void test_exec_ms() {
        ExecCmdResult execCmdResult = SSH2Util.execCommand(connection, "ls -d /*bin");

        System.out.println("命令是否正确执行:" + execCmdResult.isSuccess());
        System.out.println("命令执行结果:\n" + execCmdResult.getResult());
    }

    /** 测试执行错误命令 */
    @Test
    public void test_exec_wrong() {
        ExecCmdResult execCmdResult = SSH2Util.execCommand(connection, "ls /2");

        System.out.println("命令是否正确执行:" + execCmdResult.isSuccess());
        System.out.println("命令执行结果:\n" + execCmdResult.getResult());
    }

    /** 测试下载单个文件 */
    @Test
    public void test_download() {
        SSH2Util.download(connection, ".","/etc/passwd");
    }

    /** 测试批量下载多个文件 */
    @Test
    public void test_download_batch(){
        SSH2Util.download(connection, ".", "/etc/passwd", "/bin/bash");
    }

    /** 测试通配符下载多个文件 */
    @Test
    public void test_download_Parttern(){
        SSH2Util.downloadByPattern(connection, ".", "/bin", "*m");
    }

    /** 测试单个上传 */
    @Test
    public void test_upload() {
        SSH2Util.upload(connection, "/tmp/zongf", "passwd");
    }

    /** 测试批量上传 */
    @Test
    public void test_upload_batch() {
        SSH2Util.upload(connection, "/tmp/zongf/tt", "rm", "udevadm");
    }
}



