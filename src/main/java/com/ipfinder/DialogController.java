package com.ipfinder;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DialogController {
    @FXML
    private Text ipText;

    @FXML
    private void initialize() {
        ipText.setText("SEU IP: " + getIpAddress());
    }

    @FXML
    private void close() {
        System.exit(0);
    }

    private static String getIpAddress() {
        String ipAddress = "NÃO ENCONTRADO";
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    String ip = address.getHostAddress();
                    if (ip.startsWith("192.168.")) {
                        ipAddress = ip;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}
