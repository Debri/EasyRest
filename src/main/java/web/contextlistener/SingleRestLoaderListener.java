package web.contextlistener;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.commmon.WebApplicationEnvironment;
import web.reader.ConfigLoader;
import web.reader.WebScanedClassReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Liuqi
 * Date: 2017/5/20.
 */
public class SingleRestLoaderListener implements ServletContextListener {
    private static Logger log = LoggerFactory.getLogger(SingleRestLoaderListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //TODO 去掉Web.xml下的包配置,使用注解?
        log.info("contextInit...");
        try {
            String packages = ConfigLoader.loadConfig().getComponentscan();
            if (StringUtils.isEmpty(packages)) {
                packages = servletContextEvent.getServletContext().getInitParameter("component-scan");
            }
            log.debug("auto package: {}", packages);
            WebScanedClassReader webScanedClassReader = new WebScanedClassReader();
            webScanedClassReader.loadClass(packages);
            webScanedClassReader.initRequestMap();
            webScanedClassReader.instance4SingleMode();
            servletContextEvent.getServletContext().setAttribute(WebApplicationEnvironment.RUN_MODE, WebApplicationEnvironment.SINGLE_MODE);
            servletContextEvent.getServletContext().setAttribute(WebApplicationEnvironment.WEB_REQUEST_MAPPER, webScanedClassReader.getRequestMapper());
        } catch (Exception e) {
            log.error("start rest failed", e);
        }
    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("SingleRestLoaderListener destroyed...");
    }
}