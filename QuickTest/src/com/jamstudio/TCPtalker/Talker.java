package com.jamstudio.TCPtalker;

import com.jamstudio.util.SampleLogger;

import java.io.*;
import java.net.Socket;

/**
 * User: JamDesk
 * Date: 13-4-26
 * Time: 下午8:04
 */
public class Talker {
    //服务器地址与端口
    private final static String SERVER_ADDR = "127.0.0.1";
    private final static Integer SERVER_PORT = 8083;
    //保持服务器链接的Socket
    private Socket server = null;
    //公共的IO传输接口
    private BufferedReader inFromServer = null;
    private DataOutputStream outToServer = null;
    //储存服务器返回的数据
    private String dataFromServer = null;

    /**
     * 构造函数
     */
    public Talker(){
        connUP(SERVER_ADDR, SERVER_PORT);
    }
    public Talker(String server, Integer port) {
        connUP(server, port);
    }

    /**
     * 覆盖父类的 finalize() 关闭链接
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.connDown();
    }

    /**
     * 连接初始化，被构造方法调用
     * @param server String 服务器地址
     * @param port Integer 服务器端口
     */
    //连接初始化方法
    public void connUP(String server, Integer port){
        try {
            Socket socket = new Socket(server,port);
            inFromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            outToServer = new DataOutputStream(socket.getOutputStream());

            SampleLogger.LogAsOK("连接到 " + server + ":" + port + " 成功。");

            this.server = socket;
        } catch (IOException e) {
            SampleLogger.LogAsERR("无法建立连接，请确定已经联网并且检查防火墙。");
            e.printStackTrace();
        }
    }

    /**
     * 关闭到服务器连接的方法
     */
    public void connDown() {
        if (this.server != null) {
            try {
                server.close();
            } catch (IOException e) {
                SampleLogger.LogAsERR("无法关闭连接。");
                e.printStackTrace();
            }
        }
    }

    /**
     * 向服务器发送查询并且返回结果
     * !! 注意！必须以‘\n’结尾！
     * @param JSON String 查询用 JSON 格式的 Query
     * @return String 返回服务器JSON格式的Data
     */
    public String QueryByJSON(String JSON) {
        //若发送请求失败返回空字符串
        try {
            if (!JSON.endsWith("\n")) {
                JSON += '\n';
            }
            outToServer.writeBytes(JSON);
        } catch (IOException e) {
            SampleLogger.LogAsERR("无法发送数据到服务器，确定已经联网并检查防火墙。");
            e.printStackTrace();
        }

        try {
            dataFromServer = inFromServer.readLine();
            return dataFromServer;
        } catch (IOException e) {
            SampleLogger.LogAsERR("无法从服务器读取数据，确定已经联网并检查防火墙。");
            e.printStackTrace();
        }

        return "";
    }

    public String getDataFromServer() {
        return dataFromServer;
    }

    public void setDataFromServer(String dataFromServer) {
        this.dataFromServer = dataFromServer;
    }
}
