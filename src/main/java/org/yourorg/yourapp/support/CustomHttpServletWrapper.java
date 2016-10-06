package org.yourorg.yourapp.support;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.log4j.Logger;
import org.yourorg.yourapp.interceptors.NoCacheInterceptor;

public class CustomHttpServletWrapper extends HttpServletRequestWrapper {
    private static final Logger LOGGER = Logger.getLogger(NoCacheInterceptor.class.getName());
    private static final long serialVersionUID = 12345L;
    
    private String body = "";

    public CustomHttpServletWrapper(HttpServletRequest request) {
        super(request);

        StringBuilder sb1 = new StringBuilder();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            while ((line = br.readLine()) != null) {
                sb1.append(line);
            }
            this.body = sb1.toString();
        } catch (IOException ex) {
            LOGGER.debug(ex.getMessage());
        }

    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());

        ServletInputStream inputStream = new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isReady() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        return inputStream;
    }

    public String getBody() {
        return body;
    }
}
