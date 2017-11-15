package com.brainysoftware.pyrmont.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

/**
 * Title:        Pyrmont Servlet Container
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Brainy Software
 * @author Budi Kurniawan
 * @version 1.0
 */

public class HttpSniffer extends JFrame {
  JTextArea response = new JTextArea();
  JTextField address = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField port = new JTextField();
  JButton send = new JButton();
  JLabel jLabel3 = new JLabel();
  JTextField command = new JTextField();
  JScrollPane jScrollPane1 = new JScrollPane();

  public HttpSniffer() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    HttpSniffer frame = new HttpSniffer();
    frame.setBounds(0, 0, 600, 400);
    frame.setVisible(true);

  }
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    address.setText("127.0.0.1");
    address.setBounds(new Rectangle(77, 7, 143, 19));
    jLabel1.setText("Address");
    jLabel1.setBounds(new Rectangle(6, 5, 69, 18));
    jLabel2.setText("Port");
    jLabel2.setBounds(new Rectangle(230, 7, 30, 20));
    port.setText("8080");
    port.setBounds(new Rectangle(265, 7, 72, 18));
    send.setText("Send Request");
    send.setBounds(new Rectangle(347, 6, 117, 58));
    send.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        send_actionPerformed(e);
      }
    });
    jLabel3.setText("Command");
    jLabel3.setBounds(new Rectangle(2, 39, 74, 24));
    command.setText("GET /index.jsp HTTP/1.1");
    command.setBounds(new Rectangle(74, 42, 265, 24));
    jScrollPane1.setBounds(new Rectangle(8, 76, 560, 270));
    this.getContentPane().add(address, null);
    this.getContentPane().add(address, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(port, null);
    this.getContentPane().add(send, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(command, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(response, null);
  }

  void send_actionPerformed(ActionEvent e) {
    response.setText("");
    String host = "";
    int portNumber = 0;
    boolean ok = true;
    try {
      host = address.getText();
      portNumber = Integer.parseInt(port.getText());
    }
    catch (Exception ex) {
      ok = false;
    }

    if (ok) {

      try {
        Socket socket = new Socket(host, portNumber);
        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;
        PrintWriter out = new PrintWriter( socket.getOutputStream(), autoflush);
        String message = command.getText();
        out.println(message);
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();
        BufferedReader in = new BufferedReader(
          new InputStreamReader( socket.getInputStream() ) );
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
          if ( in.ready() ) {
            int i=0;
            while (i!=-1) {
              i = in.read();
              sb.append((char) i);
            }
            loop = false;
          }
          Thread.currentThread().sleep(50);
        }
        response.setText(sb.toString());
        socket.close();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}