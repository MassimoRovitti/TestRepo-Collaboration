package com.testina.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Implementiamo per finta la classe Servlet3
 */

/**
 * @author IoIo e TuTu
 *
 */
public class Servlet3 extends HttpServlet {
    private static final String METHOD_MASSIMO3 = "Massimo3";

    /*
     **********************************
     **********************************
     * Metodi overrided
     **********************************
     */
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        customLog("Sono il costruttore public Servlet3() di Servlet3");
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void Init(
        ServletConfig config
    ) throws ServletException {
        customLog("Sono il costruttore public void Init(ServletConfig) di Servlet3");
        super.init(config);

        /* Eventual codice custom da qui in poi */
    }

    /**
     * @see Servlet#destroy()
     */
    public void Destroy(
    ) {
        customLog("Sono il distruttore public void Destroy() di Servlet3");

        /* Eventual codice custom da qui in poi */
        super.destroy();
    }

    /**
     * Processa la richiesta Head
     */
    @Override
    protected void doHead(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Get
     */
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Post
     */
    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Put
     */
    @Override
    protected void doPut(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Delete
     */
    @Override
    protected void doDelete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Options
     */
    @Override
    protected void doOptions(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta Trace
     */
    @Override
    protected void doTrace(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        doMyOp(request, response);
    }

    /**
     * Processa la richiesta LastModified
     * questa pare che non passi da service(..., ...)
     * quindi dovrebbe chiamarla direttamente l'engine del web server
     */
    @Override
    protected long getLastModified(
        HttpServletRequest request
    ) {
        try {
            doMyOp(request, null);
        } catch (IOException e) {
          customLog("Eccezione in getLastModfied di Servlet2");
        }
        return 0;
    }
    
    /**
     * Processa la richiesta all'internal service handler
     */
    @Override
    protected void service(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        /*
            Ignoriamo il metodo standard cosi ci facciamo le richieste nostre
            // super.service(request, response);
        */
        String method = request.getMethod();
        customLog("Sono il metodo protected void service(HttpServletRequest, HttpServletResponse) [" + method + "] di Servlet3");
        
        switch (method) {
            case "HEAD" :
                doHead(request, response);
                break;
            case "GET" :
                doGet(request, response);
                break;
            case "POST" :
                doPost(request, response);
                break;
            case "PUT" :
                doPut(request, response);
                break;
            case "DELETE" :
                doDelete(request, response);
                break;
            case "OPTIONS" :
                doDelete(request, response);
                break;
            case "TRACE" :
                doDelete(request, response);
                break;
            case METHOD_MASSIMO3 :
                doDelete(request, response);
                break;
            default:
                customLog("Sono il metodo protected void service(HttpServletRequest, HttpServletResponse) [" + method + "] di Servlet3 e ... questo metodo non mi piace!");

                response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "<br>Questo metodo <h2>"+method+"</h2> non mi piace...");
                break;
        }
    }
    
    /**
     * Processa la richiesta al public service handler
     */
    @Override
    public void service(
        ServletRequest request,
        ServletResponse response
    ) throws ServletException, IOException {
        String method = "Ancora non mi ha detto chi è";
        customLog("Sono il metodo public void service(ServletRequest, ServletResponse) [" + method + "] di Servlet3");

        if (!(request instanceof HttpServletRequest &&
                response instanceof HttpServletResponse)) {
            throw new ServletException("Questa non era una richiesta o una risposta HTTP ...");
        }

        service(request, response);

        /*
            Ignoriamo il metodo standard cosi ci facciamo le richieste nostre
            // super.service(request, response);
        */
    }    
    
    /**
     **********************************
     **********************************
     * Metodi custom
     **********************************
     */
     
    /*
     * Un handler comune che per ora non fa niente
     */
    private void customLog(
        String message
    ) {
        /* Log4J per una cosa così, anche no.*/
        System.out.println(message);
    }
     
    /*
     * Un handler comune che per ora non fa niente
     */
    private void doMyOp(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {
        String method = "Ancora non mi ha detto chi è";
        customLog("Sono il metodo private void doMyOp(HttpServletRequest, HttpServletResponse) [" + method + "] di Servlet3");
        if (response != null) {
            PrintWriter out = response.getWriter();
            out.write("<html><body><h4>Hai chiamato il metodo [" + method + "] di Servlet13</h4></body></html>");
        }
    }
}
