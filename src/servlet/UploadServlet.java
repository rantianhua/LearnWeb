package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by rantianhua on 16/12/25.
 */
@WebServlet(name = "servlet.UploadServlet",
    urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if(!ServletFileUpload.isMultipartContent(request)) {
            out.println("Error : enctype must be mutipart/form-data");
            out.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        itemFactory.setSizeThreshold(3 * 1024 * 1024);
        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        System.out.println("itemFactory's tmp file is " + tmpDir.getAbsoluteFile());
        itemFactory.setRepository(tmpDir);

        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        //上传的最大文件
        fileUpload.setFileSizeMax(1024 * 1024 * 40);
        // 最大的请求值
        fileUpload.setSizeMax(1024 * 1024 * 50);

        String uploadFile = getServletContext().getRealPath("./") + "upload";
        System.out.println("uploadFile path is " + uploadFile);
        File upFile = new File(uploadFile);
        if(!upFile.exists()) {
            upFile.mkdirs();
        }

        try {
            //获取上传的文件信息
            List<FileItem> items = fileUpload.parseRequest(request);
            if (items != null && items.size() > 0) {
                for (FileItem item : items) {
                    if(!item.isFormField()) {
                        System.out.println("FileItem's name is " + item.getName());
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadFile + File.separator + fileName;
                        System.out.println("upload file path is " + filePath);
                        item.write(new File(filePath));
                    }
                }
                request.setAttribute("result", "upload success");
            }else  {
                request.setAttribute("result", "upload failed 0");
            }
        } catch (Exception e) {
            request.setAttribute("result", "upload failed 1 " + e.getMessage());
        }

        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

}
