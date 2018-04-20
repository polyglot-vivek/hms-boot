package com.nareshit.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.LogManager;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ForTesting {

	public static void main(String[] args) throws Exception {
	
		SSLContext context = SSLContext.getInstance("TLSv1.2");
		context.init(null,null,null);
		SSLContext.setDefault(context); 
		SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
		SSLSocket socket = (SSLSocket)factory.createSocket();
		socket.setEnabledProtocols(new String[] {"TLSv1.2"});
		String[] protocols = socket.getEnabledProtocols();
		
		
		for(String protocol : protocols) {
			System.out.println("protocol is:\t"+protocol);
		}
		
		System.out.println("context protocol is:\t"+context.getProtocol());
	}
}
