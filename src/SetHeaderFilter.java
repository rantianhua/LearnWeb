import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by rantianhua on 16/12/24.
 */
@WebFilter(filterName = "SetHeaderFilter",
        urlPatterns = "/SetHeader",
        initParams = {
            @WebInitParam(name = "realTime", value = "10")
        })
public class SetHeaderFilter implements Filter {

    private int realRefreshInterval;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (realRefreshInterval > 0) {
            req.setAttribute("interval", realRefreshInterval);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        final String realTime = config.getInitParameter("realTime");
        realRefreshInterval = realTime != null ? Integer.valueOf(realTime) : 0;
        System.out.println("realRefreshInterval is " + realRefreshInterval);
    }

}
