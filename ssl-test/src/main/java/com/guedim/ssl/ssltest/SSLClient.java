package com.guedim.ssl.ssltest;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class SSLClient {

  private final Logger logger = LoggerFactory.getLogger(getClass());


  private final ApplicationProperties properties;

  @Autowired
  public SSLClient(ApplicationProperties properties) {
    this.properties = properties;
  }

  public void sslTest() {

    String hostname = properties.getHostname();
    Integer port = properties.getPort();

    if (StringUtils.isEmpty(hostname) || port == null) {
      logger.info("using default values for host and port !!!!");
      hostname = "google.com";
      port = 443;
    }

    logger.info("using [{}] as hostname and  [{}] as port", hostname, port);


    SSLContext sslContext = createSSLContext();
    try {
      SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
      SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(hostname, port);
      sslSocket.startHandshake();
      SSLSession sslSession = (SSLSession) sslSocket.getSession();
      logger.info("SSLSession :");
      logger.info("\tSessionID: " + new BigInteger(sslSession.getId()));
      logger.info("\tProtocol : " + sslSession.getProtocol());
      logger.info("\tCipher suite : " + sslSession.getCipherSuite());
      logger.info("\tServer: " + sslSession.getPeerHost());
      logger.info("\tSSL Port: " + sslSession.getPeerPort());
      logger.info("\nSupported Protocol :");
      for (int i = 0; i < sslSocket.getEnabledProtocols().length; i++) {
        logger.info("\t" + sslSocket.getEnabledProtocols()[i]);
      }
      logger.info("\nSupported CipherSuites: ");
      for (int j = 0; j < sslSocket.getEnabledCipherSuites().length; j++) {
        logger.info("\t" + sslSocket.getEnabledCipherSuites()[j]);
      }
      X509Certificate[] certs = (X509Certificate[]) sslSession.getPeerCertificateChain();
      logger.info("\nCertificate Chain Info :");
      for (int i = 0; i < certs.length; i++) {
        logger.info("\tSubject DN :" + ((X509Certificate) certs[i]).getSubjectDN());
        logger.info("\tIssuer DN  : " + ((X509Certificate) certs[i]).getIssuerDN());
        logger.info("\tSerial No. : " + ((X509Certificate) certs[i]).getSerialNumber());
        logger.info("\tExpires On : " + ((X509Certificate) certs[i]).getNotAfter() + "\n");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private SSLContext createSSLContext() {
    try {
      KeyStore keyStore = KeyStore.getInstance("JKS");

      final String cacertPath = System.getenv("JAVA_HOME") + "/jre/lib/security/cacerts";
      logger.info("reading cacerts from " + cacertPath);

      keyStore.load(new FileInputStream(cacertPath), "changeit".toCharArray());
      // Create key manager
      KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
      keyManagerFactory.init(keyStore, "changeit".toCharArray());
      KeyManager[] km = keyManagerFactory.getKeyManagers();
      // Create trust manager
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
      trustManagerFactory.init(keyStore);
      TrustManager[] tm = trustManagerFactory.getTrustManagers();
      // Initialize SSLContext
      SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
      sslContext.init(km, tm, null);
      return sslContext;
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
