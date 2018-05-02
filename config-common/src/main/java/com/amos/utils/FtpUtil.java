package com.amos.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * ftp上传下载工具类
 * <p>Title: FtpUtil</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p>
 *
 * @author 入云龙
 * @version 1.0
 * @date 2015年7月29日下午8:11:51
 */
public class FtpUtil {

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param host     FTP服务器hostname
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) throws Exception {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        basePath = new String(basePath.getBytes(), "iso-8859-1");
        filePath = new String(filePath.getBytes(), "iso-8859-1");
        filename = new String(filename.getBytes(), "iso-8859-1");
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            ftp.setControlEncoding("UTF-8");
            //ftp.enterLocalPassiveMode();       //设置被动模式    通知server端开通端口传输数据
            ftp.setBufferSize(256);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * Description: 从FTP服务器下载文件
     *
     * @param host       FTP服务器hostname
     * @param port       FTP服务器端口
     * @param username   FTP登录账号
     * @param password   FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName   要下载的文件名
     * @param localPath  下载后保存到本地的路径
     * @return
     */
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            remotePath = new String(remotePath.getBytes(), "iso-8859-1");
//            fileName = new String(fileName.getBytes(), "iso-8859-1");
            localPath = new String(localPath.getBytes(), "iso-8859-1");
            int reply;
            ftp.connect(host, port);
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();       //设置被动模式    通知server端开通端口传输数据
            ftp.setBufferSize(256);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, HttpServletResponse response) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            remotePath = new String(remotePath.getBytes(), "iso-8859-1");
//            fileName = new String(fileName.getBytes(), "iso-8859-1");
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            ftp.enterLocalPassiveMode();       //设置被动模式    通知server端开通端口传输数据
            ftp.setBufferSize(256);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setControlEncoding("utf-8");
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    String fileNameNew = new String(fileName.getBytes(),"iso-8859-1");
                    OutputStream is = response.getOutputStream();
                    ftp.retrieveFile(fileNameNew, is);
                    is.close();
                }
            }
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    public static boolean deleteFile(String host, Integer port, String userName, String password,
                                     String filePath, String fileName) {
        boolean flag = false;
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(host, port);
            ftpClient.login(userName, password);
            flag = ftpClient.deleteFile(filePath + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/chenlunwei/Desktop/test.txt");
        InputStream inputStream = new FileInputStream(file);
        String basePath = new String("/home/ftpuser".getBytes(),"UTF-8");
        String filePath = new String("/datasheet/DB测试".getBytes(),"UTF-8");
        uploadFile("97.64.21.206", 21, "ftpuser", "clw142720", basePath, filePath, file.getName(), inputStream);
    }
}
