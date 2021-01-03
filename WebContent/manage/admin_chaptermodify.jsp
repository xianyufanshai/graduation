<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_chapterselect?bid=${c.c_BID }">章节管理</a><span class="crumb-step">&gt;</span><span>修改章节</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/graduation/manage/admin_dochapterupdate?cid=${c.CHAPTER_ID }&bid=${p.BOOK_ID}" method="post"  enctype="multipart/form-data" id="myform" name="myform">
                    <input type="hidden" name="cid" value="${c.CHAPTER_ID }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                        <tr>   
                               <th><i class="require-red">*</i>章节名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Cname" size="50" value="${c.CHAPTER_NAME }" type="text">
                                </td>
                            </tr> 
                             <tr>   
                               <th><i class="require-red">*</i>当前章节文件：</th>
                              <td>
                                 <input class="common-text required" id="title" name="Content1" size="50" value="${c.c_FILENAME }" type="text">
                                 </td>
                            </tr>    
                            
                                                       
                            <tr>
                                <th><i class="require-red">*</i>更改章节文件：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Content" size="50" value="" type="file">
                                    
                                </td>
                                
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>书籍名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Bname" size="50" value="${c.c_BNAME }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>书籍ID：</th>
                                <td>
                                     <input class="common-text required" id="title" name="Bid" size="50" value="${c.c_BID }" type="text">
                                </td>
                            </tr>
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>