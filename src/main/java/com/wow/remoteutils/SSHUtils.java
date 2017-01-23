package com.wow.remoteutils;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service based on ssh
 *
 * Created by kisrosen on 17/1/23.
 */
public class SSHUtils {

    @Autowired
    private SSHClient sshClient;

    /**
     * login to ssh server
     *
     * @param host
     * @param port
     * @param username
     * @param password
     */
    public void loginClient(String host, Integer port, String username, String password) {
        // initialize
        sshClient.setUsername(username);
        sshClient.setPassword(password);

        this.loginClient(host, port);
    }

    /**
     * login to ssh server
     *
     * @param host
     * @param port
     */
    public void loginClient(String host, Integer port) {

        sshClient.setHost(host);
        sshClient.setPort(port);

        sshClient.login();
    }

    /**
     * logout of sshclient
     */
    public void closeClient() {

        sshClient.logout();
    }

    /**
     * command ls
     *
     * @return
     */
    public String showFiles() {
        return sshClient.sendCmd("ls");
    }

    /**
     * command pwd
     *
     * @return
     */
    public String showCurrentPath() {
        return sshClient.sendCmd("pwd");
    }

    /**
     * command vmStat
     *
     * @return
     */
    public String showVmstat() {
        return sshClient.sendCmd("vmstat");
    }
}
