import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by rantianhua on 16/12/21.
 */
@WebServlet(urlPatterns = "/HelloWorld", name = "HelloWorld")
public class HelloWorldServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建Cookie
        Cookie cookieName = new Cookie("name",
                //中文转码
                URLEncoder.encode(req.getParameter("name"), "UTF-8"));
        Cookie cookieUrl = new Cookie("url",
                req.getParameter("url"));

        //过期时间为一分钟后
        cookieName.setMaxAge(60);
        cookieUrl.setMaxAge(60);
        resp.addCookie(cookieName);
        resp.addCookie(cookieUrl);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "使用 GET 方法读取表单数据";
        // 处理中文
        String name = req.getParameter("name");
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + req.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(getClass().getSimpleName() + " destroy");
    }
}
